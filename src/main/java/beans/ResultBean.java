package beans;

import checking.Check;
import entities.Entry;

import java.io.Serializable;
import java.util.List;

//@ManagedBean(name = "resultBean", eager = true)
//@ApplicationScoped
public class ResultBean implements Serializable {
    private static final long  serialVersionUID = 1L;
    private SessionBean sessionBean = new SessionBean();
    private Entry entry = new Entry();
//    public List<Entry> resultEntry = new ArrayList<Entry>();

    public ResultBean() {
    }

    public Entry getEntry() {
        return entry;
    }

    public List<Entry> getResultEntry() {
        return sessionBean.getSessionEntryList();
    }


    public void addResult() {
        Check.isHit(entry);
        List<Entry> entryList = sessionBean.getSessionEntryList();
        entryList.add(entry);
        sessionBean.saveSessionEntryList(entryList);
//        resultEntry.add(entry);
        entry = new Entry();
    }

}
