package beans;

import checking.Check;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "resultBean", eager = true)
@ApplicationScoped
public class ResultBean implements Serializable {
    private static final long  serialVersionUID = 1L;
    private Entry entry = new Entry();
    public List<Entry> resultyEntry = new ArrayList<Entry>();

    public ResultBean() { }

    public Entry getEntry() {
        return entry;
    }
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public boolean isHit() {
        return Check.isHit(entry);
    }
}
