package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="results")
public class ResultsEntityManager {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false, insertable=false, updatable=false)
    private long id;

    @Column(name="sessionId", nullable = false, insertable=true, updatable=true)
    private String sessionId;

    @Column(name="date", nullable = false, insertable=true, updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="x", nullable = false, insertable=true, updatable=true)
    private double x;

    @Column(name="y", nullable = false, insertable=true, updatable=true)
    private double y;
    @Column(name="r", nullable = false, insertable=true, updatable=true)
    private double r;

    @Column(name="time", nullable = false, insertable=true, updatable=true)
    private long time;

    @Column(name="hit", nullable=false, insertable=true, updatable=true)
    private String hit;

    public long getId() { return id; }
    public String getSessionId() { return sessionId; }
    public Date getDate() { return date; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getR() { return r; }
    public long getTime() { return time; }
    public String getHit() { return hit; }

    public void setId(long id) { this.id = id; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public void setDate(Date date) { this.date = date; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setR(double r) { this.r = r; }
    public void setTime(long time) { this.time = time; }
    public void setHit(String hit) { this.hit = hit; }

    public ResultsEntityManager() {}


}
