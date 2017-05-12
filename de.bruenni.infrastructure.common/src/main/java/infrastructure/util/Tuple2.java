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

    @Override
    public String toString() {
        return "Tuple2{" +
            "t1=" + t1 +
            ", t2=" + t2 +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;

        if (!t1.equals(tuple2.t1)) return false;
        return t2.equals(tuple2.t2);
    }

    @Override
    public int hashCode() {
        int result = t1.hashCode();
        result = 31 * result + t2.hashCode();
        return result;
    }
}

