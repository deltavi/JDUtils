package com.vincenzodevivo.jdutils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.vincenzodevivo.jdutils.EmptyUtils.isEmpty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vdevivo on 26/01/2017.
 */
public class EmptyUtilsTest {
    @Test
    public void isEmptyString() throws Exception {
        assertTrue(isEmpty(""));
    }

    @Test
    public void isNotEmptyString() throws Exception {
        assertFalse(isEmpty("value"));
    }

    @Test
    public void isEmptyIntArray() throws Exception {
        assertTrue(isEmpty(new int[]{}));
    }

    @Test
    public void isNotEmptyIntArray() throws Exception {
        assertFalse(isEmpty(new int[]{1}));
    }

    @Test
    public void isEmptyBooleanArray() throws Exception {
        assertTrue(isEmpty(new boolean[]{}));
    }

    @Test
    public void isEmptyLongArray() throws Exception {
        assertTrue(isEmpty(new long[]{}));
    }

    @Test
    public void isEmptyShortArray() throws Exception {
        assertTrue(isEmpty(new short[]{}));
    }

    @Test
    public void isEmptyCharArray() throws Exception {
        assertTrue(isEmpty(new char[]{}));
    }

    @Test
    public void isEmptyByteArray() throws Exception {
        assertTrue(isEmpty(new byte[]{}));
    }

    @Test
    public void isEmptyDoubleArray() throws Exception {
        assertTrue(isEmpty(new double[]{}));
    }

    @Test
    public void isEmptyFloatArray() throws Exception {
        assertTrue(isEmpty(new float[]{}));
    }

    @Test
    public void isEmptyIntegerArray() throws Exception {
        assertTrue(isEmpty(new Integer[]{}));
    }

    @Test
    public void isNotEmptyIntegerArray() throws Exception {
        assertFalse(isEmpty(new Integer[]{1}));
    }

    @Test
    public void isEmptyArrayList() throws Exception {
        assertTrue(isEmpty(new ArrayList()));
    }

    @Test
    public void isNotEmptyArrayList() throws Exception {
        ArrayList collection = new ArrayList();
        collection.add("value");
        assertFalse(isEmpty(collection));
    }

    @Test
    public void isEmptyHashMap() throws Exception {
        assertTrue(isEmpty(new HashMap()));
    }

    @Test
    public void isNotEmptyHashMap() throws Exception {
        HashMap map = new HashMap();
        map.put("key","value");
        assertFalse(isEmpty(map));
    }
}