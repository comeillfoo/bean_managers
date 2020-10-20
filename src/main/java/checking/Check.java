package checking;

import beanClasses.ResultsEntityManager;

public abstract class Check {

    public static boolean isHit(ResultsEntityManager bean) {
        Double x = bean.getX();
        Double y = bean.getY();
        Double r = bean.getR();

        if (x == null || y == null || r == null) {
            throw new NullPointerException("Parameters shouldn't be null");
        }
        if (x >= 0 && y <= 0 && (x - r <= y)) {
            bean.setHit("yes");
            return true;
        }
        if (x <= 0 && y <= 0 && x >= r/2 && y >= r) {
            bean.setHit("yes");
            return true;
        }else if (x <= 0 && y >= 0 && (Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(r, 2)) {
            bean.setHit("yes");
            return true;
        }else {
            bean.setHit("no");
            return false;
        }
    }
}
