package entities;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "results", schema = "s284733", catalog = "studs")
public class ResultsEntityManager {
    @Id
    @Column(name="id")
    private long id;

    @Basic
    @Column(name = "sessionid")
    private String sessionId;

    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="x")
    private double x;

    @Column(name="y")
    private double y;
    @Column(name="r")
    private double r;

    @Column(name="time")
    private long time;

    @Column(name="hit")
    private String hit;

    public long getId() { return id; }
    public String getSessionId() { return sessionId; }
    public Date getDate() { return date; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getR() { return r; }
    public long getTime() { return time; }
    public String getHit() { return hit; }

    public void setId(long id) {
        this.id = id;
    }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public void setDate(Date date) { this.date = date; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setR(double r) { this.r = r; }
    public void setTime(long time) { this.time = time; }
    public void setHit(String hit) { this.hit = hit; }

    public ResultsEntityManager() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultsEntityManager that = (ResultsEntityManager) o;

        if (id != that.id) return false;
        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.r, r) != 0) return false;
        if (time != that.time) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (hit != null ? !hit.equals(that.hit) : that.hit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(r);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (hit != null ? hit.hashCode() : 0);
        return result;
    }

}
