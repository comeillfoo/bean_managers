package checking;

import entities.Entry;

public abstract class Check {

    public static boolean isHit(Entry entry) {
        Double x = entry.getX();
        Double y = entry.getY();
        Double r = entry.getR();

        if (x == null || y == null || r == null) {
            entry.setHit(false);
            throw new NullPointerException("Parameters shouldn't be null");
        }
        if (x >= 0 && y <= 0 && (x - r <= y)) {
            entry.setHit(true);
            return true;
        }
        if (x <= 0 && y <= 0 && x >= r/2 && y >= r) {
            entry.setHit(true);
            return true;
        }else if (x <= 0 && y >= 0 && (Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(r, 2)) {
            entry.setHit(true);
            return true;
        }else {
            entry.setHit(false);
            return false;
        }
    }
}
