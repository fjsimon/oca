package com.oca.exam.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class ArrayExamplesTest {

    @Test
    public void creatingArrayTest() {
        int[] arr = new int[3];
        int[] arr2 = new int[]{ 42, 55, 99};
        int[] arr3 = { 42, 55, 99};

        String [] bugs = {"cricket", "beetle", "ladybug"};
        String [] alias = bugs;

        assertThat(bugs.equals(alias), is(true));
        assertThat(bugs == alias , is(true));
        assertThat(bugs.toString().contains("[Ljava.lang.String;"), is(true));
        assertThat(Arrays.toString(bugs), is("[cricket, beetle, ladybug]"));

        assertThat(arr2.equals(arr3), is(false));
        assertThat(arr2 == arr3, is(false));
        assertThat(Arrays.equals(arr2, arr3), is(true));

        System.out.println(bugs.equals(alias));
        System.out.println(bugs.toString());
        System.out.println(Arrays.toString(bugs));
    }

    @Test()
    public void castingTest() {

        String [] strings = { "stringValue" };
        Object [] objects = strings;
        String [] againStrings = (String[]) objects;

//      againStrings[0] = new StringBuilder(); //NO COMPILE

        try {
            objects[0] = new StringBuilder(); // Throws Exception at runtime
        }catch (ArrayStoreException e){
            return;
        }
        fail();
    }

    @Test
    public void usingArray() {
        String [] mammals = {"monkey", "chimp", "donkey"};
        Assert.assertThat("length", mammals.length, is(3));

        Assert.assertThat("mammals[0]", mammals[0], is("monkey"));
        Assert.assertThat("mammals[1]", mammals[1], is("chimp"));
        Assert.assertThat("mammals[2]", mammals[2], is("donkey"));


        int [] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 5;
        }

        for(int i = 0; i < numbers.length; i++) {
            Assert.assertThat("Numbers ", numbers[i], is(i+5));
        }

        // Multi dimensional
        int [][] differentSize = {{1, 4}, {3}, {9, 8, 7}};
        Assert.assertThat("Multi-dimensional array ", differentSize.length, is(3));
        Assert.assertThat("Multi-dimensional array[0] ", differentSize[0].length, is(2));
        Assert.assertThat("Multi-dimensional array[1] ", differentSize[1].length, is(1));
        Assert.assertThat("Multi-dimensional array[2] ", differentSize[2].length, is(3));


    }

    @Test
    public void sorting() {
        int [] numbers = {6, 9, 1};
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
            int j = i;
            if(j++ < numbers.length-1) {
                assertThat(numbers[i] < numbers[j], is(true));
            }
        }
    }

    @Test
    public void binarySearch_ordered() {
        int [] ordered = {2, 4, 6, 8}; // Ordered
        assertThat(Arrays.binarySearch(ordered, 2), is(0));
        assertThat(Arrays.binarySearch(ordered, 4), is(1));
        assertThat(Arrays.binarySearch(ordered, 1), is(-1));
        assertThat(Arrays.binarySearch(ordered, 3), is(-2));
        assertThat(Arrays.binarySearch(ordered, 9), is(-5));
    }

    @Test
    public void binarySearch_unordered() {
        int [] ordered = {6, 4, 10, 8}; // un ordered
        assertThat(Arrays.binarySearch(ordered, 2), is(-1));
        assertThat(Arrays.binarySearch(ordered, 4), is(1));
        assertThat(Arrays.binarySearch(ordered, 1), is(-1));
        assertThat(Arrays.binarySearch(ordered, 3), is(-1));
        assertThat(Arrays.binarySearch(ordered, 9), is(-3));
    }

    @Test
    public void test02_Q25() {
        String[] sa = {"a", "b", "c"};
        for(String s :  sa){
            if("b".equals(s)) {
                System.out.println("continue");
                continue;
            }
            System.out.println(s);
            if("b".equals(s)) {
                System.out.println("break");
                break;
            }
            System.out.println(s+" again");
        }
    }

    @Test
    public void test03_Q07() {
        int i = 4;
        int ia[][][] = new int[i][i = 3][i];
        System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
        assertThat(ia.length, is(4));
        assertThat(ia[0].length, is(3));
        assertThat(ia[0][0].length, is(3));

    }

    @Test
    public void test05_Q16() {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 2, 3, 1, 0 };
        System.out.println( a [ (a = b)[3] ] );
    }

    @Test(expected = NullPointerException.class)
    public void test05_Q57() {
        int ia[][] = { {1, 2}, null };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);
    }
}
