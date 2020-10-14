package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "resultBean", eager = true)
@ApplicationScoped
public class ResultBean implements Serializable {
    private static final long  serialVersionUID = 1L;

    private Double x;
    private Double y;
    private Double r;
    private boolean isHit = false;

    //empty constructor to follow the specification of java beans
    public ResultBean() {}

    public ResultBean(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


    public Double getX() { return x; }
    public Double getY() { return y; }
    public Double getR() { return r; }

    public void setX(Double x) { this.x = x; }
    public void setY(Double y) { this.y = y; }
    public void setR(Double r) { this.r = r; }

    public boolean getHit() { return isHit; }
    public void setHit(boolean hit) { isHit = hit; }

}
