package beanClasses;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SessionBean implements Serializable {
    private static final long  serialVersionUID = 2L;
    private List<ResultsEntityManager> resultsEntityManagerList = new ArrayList<ResultsEntityManager>();

    public SessionBean() { }

    public void setResultsEntityManagerList(List<ResultsEntityManager> resultsEntityManagerList) {
        this.resultsEntityManagerList = resultsEntityManagerList;
    }



    public List<ResultsEntityManager> getResultsEntityManagerList() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        List<ResultsEntityManager> entryList = (ArrayList<ResultsEntityManager>) httpSession.getAttribute("entryList");
        if(entryList == null) {
            entryList = new ArrayList<ResultsEntityManager>();
        }
        return entryList;
    }

    public void saveSessionEntryList(List<ResultsEntityManager> entryList) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        httpSession.setAttribute("entryList", entryList);
    }
}
