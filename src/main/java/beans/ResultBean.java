package beans;

import checking.Check;
import entities.Entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@ManagedBean(name = "resultBean", eager = true)
//@ApplicationScoped
public class ResultBean implements Serializable {
    private static final long  serialVersionUID = 1L;
    private Entry entry = new Entry();
    public List<Entry> resultEntry = new ArrayList<Entry>();

    public ResultBean() { }

    public Entry getEntry() {
        return entry;
    }

    public void addResult() {
        Check.isHit(entry);
        resultEntry.add(entry);
        entry = new Entry();
    }

    public List<Entry> getResultEntry() {
        return resultEntry;
    }

    public void setResultEntry(List<Entry> resultEntry) {
        this.resultEntry = resultEntry;
    }
}
