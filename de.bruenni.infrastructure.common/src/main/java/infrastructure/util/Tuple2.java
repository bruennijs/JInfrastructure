package infrastructure.util;

/**
 * Created by bruenni on 04.10.16.
 */

public class Tuple2<T1, T2> {
    private T1 t1;
    private T2 t2;

    public Tuple2(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * Gets object 1
     * @return
     */
    public T1 getT1() {
        return t1;
    }

    /**
     * Gets object 2
     * @return
     */
    public T2 getT2() {
        return t2;
    }
}

