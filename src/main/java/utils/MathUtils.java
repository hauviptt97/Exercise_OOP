package utils;

public class MathUtils {

    @SafeVarargs
    public static <T extends Comparable<T>> T max(T... ts) {
        T max = ts[0];

        for (T t : ts) {
            if (t.compareTo(max) > 0)
                max = t;
        }

        return max;
    }

}