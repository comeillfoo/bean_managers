package beanClasses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

public class DBOperator {
    private static final String PERSISTENCE_UNIT_NAME = "PointHitResultsUnit";
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    // fetching all point hit results details from the db
    @SuppressWarnings("unchecked")
    public static List<ResultsEntityManager> getAllResultsDetails() {
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM beanClasses.ResultsEntityManager s");
        List<ResultsEntityManager> resultsList = queryObj.getResultList();
        if (resultsList != null && resultsList.size() > 0) {
            return resultsList;
        } else {
            return null;
        }
    }

    // adding (creating) new results
    public static String createNewResultFromObj(ResultsEntityManager resultsEntityManager) {
        if(!transactionObj.isActive()) {
            transactionObj.begin();
        }
        resultsEntityManager.setId(getMaxResultId());
//        resultsEntityManager.setTime(System.currentTimeMillis() - resultsEntityManager.getTime());
        entityMgrObj.persist(resultsEntityManager);
        transactionObj.commit();
        return "resultsList.xhtml?faces-redirect=true";
    }
    // adding (creating) new results
    public static String createNewResults(double x, double y, double r, String hitting, long checkingTime) {
        if(!transactionObj.isActive()) {
            transactionObj.begin();
        }

        ResultsEntityManager newResultObj = new ResultsEntityManager();
        newResultObj.setId(getMaxResultId());
        newResultObj.setDate(new Date());
        newResultObj.setX(x);
        newResultObj.setY(y);
        newResultObj.setR(r);
        newResultObj.setHit(hitting);
//        newResultObj.setTime(checkingTime);
        entityMgrObj.persist(newResultObj);
        transactionObj.commit();
        return "resultsList.xhtml?faces-redirect=true";
    }

    // deleting the selected result id from the db
    public static String deleteResultDetails(long resultId) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        ResultsEntityManager deletedResultId = new ResultsEntityManager();
        if(isResultIdPresent(resultId)) {
            deletedResultId.setId(resultId);
            entityMgrObj.remove(entityMgrObj.merge(deletedResultId));
        }
        transactionObj.commit();
        return "schoolsList.xhtml?faces-redirect=true";
    }

    // updating the result details for a particular result id in the db
    public static String updateResultDetails(long resultId, double x, double y, double r, String hitting, long time) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        if(isResultIdPresent(resultId)) {
            Query queryObj = entityMgrObj.createQuery("UPDATE beanClasses.ResultsEntityManager s SET s.date=:date, s.x=:x, s.y=:y, s.r=:r, s.hit=:hit, s.time=:time WHERE s.id= :id");
            queryObj.setParameter("id", resultId);
            queryObj.setParameter("date", new Date());
            queryObj.setParameter("x", x);
            queryObj.setParameter("y", y);
            queryObj.setParameter("r", r);
            queryObj.setParameter("hit", hitting);
            queryObj.setParameter("time", time);
            int updateCount = queryObj.executeUpdate();
            if(updateCount > 0) {
                System.out.println("Record For Id: " + resultId + " Is Updated");
            }
        }
        transactionObj.commit();
        FacesContext.getCurrentInstance().addMessage("editResultForm:ResultId", new FacesMessage("Result Record #" + resultId + " is successfully updated in db"));
        return "resultEdit.xhtml";
    }

    // fetching maximum result Id from the db
    private static int getMaxResultId() {
        int maxResultId = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(s.id)+1 FROM beanClasses.ResultsEntityManager s");
        if(queryObj.getSingleResult() != null) {
            maxResultId = (Integer) queryObj.getSingleResult();
        }
        return maxResultId;
    }

    // fetching particular result details on the basis of result Id from the db
    private static boolean isResultIdPresent(long resultId) {
        boolean idResult = false;
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM beanClasses.ResultsEntityManager s WHERE s.id = :id");
        queryObj.setParameter("id", resultId);
        ResultsEntityManager selectedResultId = (ResultsEntityManager) queryObj.getSingleResult();
        if(selectedResultId != null) {
            idResult = true;
        }
        return idResult;
    }
}
