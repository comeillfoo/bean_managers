package beanClasses;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="results")
public class ResultsEntityManager {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private long id;

    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="x")
    private double x;

    @Column(name="y")
    private double y;
    @Column(name="r")
    private double r;

    @Column(name="time", insertable = true)
    private long time;

    @Column(name="hit")
    private String hit;

    public long getId() { return id; }
    public Date getDate() { return date; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getR() { return r; }
    public long getTime() { return time; }
    public String getHit() { return hit; }

    public void setId(long id) { this.id = id; }
    public void setDate(Date date) { this.date = date; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setR(double r) { this.r = r; }
    public void setTime(long time) { this.time = time; }
    public void setHit(String hit) { this.hit = hit; }

    public ResultsEntityManager() {}


}
