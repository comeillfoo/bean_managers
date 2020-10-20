package beanClasses;

import checking.Check;

import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;

public class ResultBean implements Serializable {
    private static final long  serialVersionUID = 1L;

    private ResultsEntityManager resultsEntityManager = new ResultsEntityManager();

    @ManagedProperty(value = "")
    private beanClasses.SessionBean sessionBean = new beanClasses.SessionBean();


    public void setResultsEntityManager(ResultsEntityManager resultsEntityManager) {
        this.resultsEntityManager = resultsEntityManager;
    }

    public ResultsEntityManager getResultsEntityManager() {
        return resultsEntityManager;
    }

    //    private Double x;
//    private Double y;
//    private Double r;
//    private boolean hit = false;
//    private long time;
//
//    public Double getX() { return x; }
//    public Double getY() { return y; }
//    public Double getR() { return r; }
//    public boolean isHit() { return hit; }
//    public long getTime() { return time; }
//
//    public void setX(Double x) { this.x = x; }
//    public void setY(Double y) { this.y = y; }
//    public void setR(Double r) { this.r = r; }
//    public void setHit(boolean hit) { this.hit = hit; }
//    public void setTime(long time) { this.time = time; }

    public ResultBean() { }

    public List<ResultsEntityManager> getResultsListFromDB() {
        return DBOperator.getAllResultsDetails();
    }

    public String addNewResult() {
//        resultsEntityManager.setDate(new Date());
//        resultsEntityManager.setTime(System.currentTimeMillis());
        resultsEntityManager.setHit(Check.isHit(resultsEntityManager) ? "yes" : "no");

        List<beanClasses.ResultsEntityManager> tempResultList = sessionBean.getResultsEntityManagerList();
        tempResultList.add(resultsEntityManager);

        sessionBean.saveSessionEntryList(tempResultList);
        resultsEntityManager = new ResultsEntityManager();
        return "sus";
//        beanClasses.DBOperator.createNewResultFromObj(resultsEntityManager);
//        return DBOperator.createNewResultFromObj(resultsEntityManager);
//        return beanClasses.DBOperator.createNewResults(added.x, added.y, added.r, added.hit ? "yes" : "no", added.time);
    }
}
