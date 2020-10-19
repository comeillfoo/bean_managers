package beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Session {

    public Session() {}

    public List<ResultBean> getSessionResultBeanList() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
//        ArrayList<Entry> entryList = (ArrayList<Entry>) facesContext.getExternalContext().getSessionMap().get("entryList");
        List<ResultBean> resultsList = (ArrayList)httpSession.getAttribute("entryList");
        if(resultsList == null) {
            resultsList = new ArrayList<ResultBean>();
        }
        return resultsList;
    }

    public void saveSessionEntryList(List<ResultBean> resultsList) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.setAttribute("resultsList", resultsList);
    }

    public String getSessionId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        return httpSession.getId();
    }
}
