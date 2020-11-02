package beans;

import entities.ResultsEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class DBOperator {
    private static final String PERSISTENCE_UNIT_NAME = "ResultsManagement";
    private static final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static final EntityTransaction transaction = entityMgrObj.getTransaction();

    // fetching user point hit results details from the db
    @SuppressWarnings("unchecked")
    public static List<ResultsEntityManager> getUserResultsDetails(String sessionId) {
        Query queryObj = entityMgrObj.createQuery("SELECT result FROM ResultsEntityManager result WHERE result.sessionId LIKE :sessionId");
        queryObj.setParameter("sessionId", sessionId);
        List<ResultsEntityManager> resultsList = queryObj.getResultList();
        if (resultsList != null && resultsList.size() > 0) {
            return resultsList;
        } else {
            return null;
        }
    }

    // adding (creating) new results
    public static String createNewResults(Date date, String sessionId, double x, double y, double r, String hitting, long checkingTime) {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        ResultsEntityManager newResultObj = new ResultsEntityManager();
        newResultObj.setSessionId(sessionId);
        newResultObj.setDate(date);
        newResultObj.setX(x);
        newResultObj.setY(y);
        newResultObj.setR(r);
        newResultObj.setHit(hitting);
        newResultObj.setTime(checkingTime);
        entityMgrObj.persist(newResultObj);
        transaction.commit();
        return "main.xhtml?faces-redirect=true";
    }

    public DBOperator() {    }
}
