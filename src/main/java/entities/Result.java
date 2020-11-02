package entities;

import java.util.Date;

/**
 * ModelBean
 */
public class Result extends ResultInfo {
    private long id;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    private String sessionId;

    public String getSessionId() { return sessionId; }

    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Result() {}
}
