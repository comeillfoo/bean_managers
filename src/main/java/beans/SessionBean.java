package beans;

import entities.Entry;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SessionBean {
    private List<Entry> entryList;

    public SessionBean() {}

    public List<Entry> getEntryList() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext();
        entryList = (ArrayList)httpSession.getAttribute("entryList");
        if(entryList == null) {
            entryList = new ArrayList<Entry>();
        }
        return entryList;
    }
}
