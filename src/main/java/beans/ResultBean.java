package beans;


import checking.Check;
import entities.ResultsEntityManager;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class ResultBean {
    private ResultsEntityManager resultsEntityManager = new ResultsEntityManager();

    public ResultsEntityManager getResultsEntityManager() {
        return resultsEntityManager;
    }

//    public String addResult(ResultBean newResult) {
//        long start = new Date().getTime();
//        // -- checking point hit --
////        boolean hit = Check.isHit(newResult);
////        String hitView = hit? "yes" : "no";
//        // -- checking point hit --
//        long finish = new Date().getTime();
//        // get instance of application faces context
//        FacesContext fctx = FacesContext.getCurrentInstance();
//        // get session for session identificator
//        HttpSession session = (HttpSession) fctx.getExternalContext().getSession(true);
//
//        // -- building bean
//        newResult.setDate(new Date());
////        newResult.setHit(hit);
//        newResult.setTime(finish - start);
//        newResult.setSessionId(session.getId());
//        // -- building bean
//        return DBOperator.createNewResults(newResult.getDate(), newResult.getSessionId(), newResult.getX(), newResult.getY(), newResult.getR(), hitView, newResult.getTime());
//    }


    public String addResult() {
        long start = new Date().getTime();

        Check.isHit(resultsEntityManager);
        if (Check.isHit(resultsEntityManager)) {
            resultsEntityManager.setHit("Yes");
        }else {
            resultsEntityManager.setHit("No");
        }

        long finish = new Date().getTime();

        FacesContext fctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fctx.getExternalContext().getSession(true);

        resultsEntityManager.setDate(new Date());
        resultsEntityManager.setTime(finish - start);
        resultsEntityManager.setSessionId(session.getId());

        ResultsEntityManager copyResultsEntityManager = resultsEntityManager;

        resultsEntityManager = new ResultsEntityManager();

        return DBOperator.createNewResults(copyResultsEntityManager);
    }


    public List<ResultsEntityManager> resultListFromDb(HttpSession session) {
        return DBOperator.getUserResultsDetails(session.getId());
    }
}
