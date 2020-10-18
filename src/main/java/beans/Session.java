package beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Session {

    public Session() {}

    public List<Entry> getSessionEntryList() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
//        ArrayList<Entry> entryList = (ArrayList<Entry>) facesContext.getExternalContext().getSessionMap().get("entryList");
        List<Entry> entryList = (ArrayList)httpSession.getAttribute("entryList");
        if(entryList == null) {
            entryList = new ArrayList<Entry>();
        }
        return entryList;
    }

    public void saveSessionEntryList(List<Entry> entryList) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.setAttribute("entryList", entryList);
    }

    public String getSessionId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        return httpSession.getId();
    }
}
