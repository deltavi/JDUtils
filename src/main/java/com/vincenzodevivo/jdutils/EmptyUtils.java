package com.vincenzodevivo.jdutils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by vdevivo on 26/01/2017.
 */
public class EmptyUtils {
    private EmptyUtils() {
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isEmpty(final Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final short[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final boolean[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(final Map map) {
        return map == null || map.isEmpty();
    }
}
