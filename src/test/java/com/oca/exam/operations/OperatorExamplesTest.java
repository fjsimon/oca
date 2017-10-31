package com.oca.exam.operations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperatorExamplesTest {

    @Test
    public void getArithmeticOperatorsOperation() {

        assertThat(OperatorExamples.getArithmeticOperatorsOperation(), is(3));
    }

    @Test
    public void getUnaryOperatorsOperation() {

        assertThat(OperatorExamples.getUnaryOperatorsOperation(), is(-1));
    }

    @Test
    public void getPrePostOperations() {

        Map<String, Integer> map = OperatorExamples.getPrePostOperations();
        assertThat(map.get("0 i"), is(3));
        assertThat(map.get("1 i"), is(4));
        assertThat(map.get("2 i"), is(5));
        assertThat(map.get("3 i"), is(5));
        assertThat(map.get("4 ++i"), is(6));
        assertThat(map.get("5 i++"), is(6));
        assertThat(map.get("6 i"), is(7));
    }

    @Test
    public void getEqualityRelationalOperators() {

        Map<String, Boolean> map = OperatorExamples.getEqualityRelationalOperators();
        assertThat(map.get("value1 == value2"), is(false));
        assertThat(map.get("value1 != value2"), is(true));
        assertThat(map.get("value1 > value2"), is(false));
        assertThat(map.get("value1 < value2"), is(true));
        assertThat(map.get("value1 <= value2"), is(true));
    }

    @Test
    public void getConditionalOperators() {

        Map<String, Boolean> map = OperatorExamples.getConditionalOperators();
        assertThat(map.get("value1 is 1 AND value2 is 2"), is(true));
        assertThat(map.get("value1 is 1 OR value2 is 1"), is(true));
    }

    @Test
    public void getTernaryOperation() {

        assertThat(OperatorExamples.getTernaryOperation(), is(1));
    }

    @Test
    public void getTypeComparisonOperator() {

        Map<String, Boolean> map = OperatorExamples.getTypeComparisonOperator();
        assertThat(map.get("obj1 instanceof Parent"), is(true));
        assertThat(map.get("obj1 instanceof Child"), is(false));
        assertThat(map.get("obj1 instanceof MyInterface"), is(false));
        assertThat(map.get("obj2 instanceof Parent"), is(true));
        assertThat(map.get("obj2 instanceof Child"), is(true));
        assertThat(map.get("obj2 instanceof MyInterface"), is(true));
    }

    @Test
    public void getBitwiseBitShiftOperators() {

        assertThat(OperatorExamples.getBitwiseBitShiftOperators(), is(2));
    }

    @Test
    public void getBitShiftOperators() {

        Map<String, Byte> map = OperatorExamples.getBitShiftOperators();
        assertThat(map.get("initial byte value"), is((byte) 2));
        assertThat(map.get("~byte"), is((byte) -3));
        assertThat(map.get("a bitwise AND b"), is((byte) 0));
        assertThat(map.get("a bitwise OR b"), is((byte) 6));
        assertThat(map.get("a XOR b"), is((byte) 6));
    }

    @Test
    public void getBooleanStringTest() {

        assertThat(OperatorExamples.getBooleanString(), is("true, 20, false"));
    }

    class JustLooping {
        private int j;

        void showJ() {
            while (j <= 5) {
                for (int j = 1; j <= 5; ) {
                    System.out.print(j + " ");
                    j++;
                }
                j++;
            }
        }
    }

    @Test
    public void testQ02() {

        new JustLooping().showJ();
    }

    @Test
    public void test03_Q22() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        if (obj1.equals(obj2)) System.out.println("true");
        else System.out.println("false");
    }

    @Test
    public void test03_Q70() {
        int sum = 0;
        for (int i = 0, j = 10; sum > 20; ++i, --j)      // 1
        {
            sum = sum + i + j;
        }
        System.out.println("Sum = " + sum);
    }

    @Test
    public void test04_Q31() {
        int i = 0;
        int j = 1;
        if ((i++ == 0) & (j++ == 2)) {
            i = 12;
        }
        System.out.println(i + " " + j);
    }

    @Test
    public void test04_Q44() {

        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);
        System.out.println(4 + 1.0f);
        System.out.println(5 / 4);
        System.out.println('a' + 1);
    }

    @Test
    public void test04_Q52() {
        int i = 1;
        int j = i++;
        if ((i == ++j) | (i++ == j)) {
            i += j;
        }
        System.out.println(i);
    }

    @Test
    public void test04_Q64() {
        int k = 1;
        int[] a = {1};
        k += (k = 4) * (k + 2);
        a[0] += (a[0] = 4) * (a[0] + 2);
        System.out.println(k + " , " + a[0]);
    }

    @Test
    public void test04_Q65() {
        int i = 0, j = 5;
        lab1:
        for (; ; i++) {
            for (; ; --j)
                if (i > j)
                    break lab1;
        }
        System.out.println(" i = " + i + ", j = " + j);
    }



    public static int operators() {

        int x1 = -4;
        // x2 is (x1)-- => x2 is first assigned the value of x1 i.e. -4 and then x1 in decremented by 1 to become -5
        int x2 = x1--;
        // x3  is ++(x2) => x2 becomes -3 first and  then its value i.e. -3 is assigned to x3
        int x3 = ++x2;
        // x2>x3 is false so x1++  => x1 becomes -4
        if (x2 > x3) {
            --x3;
        } else {
            x1++;
        }
        //therefore -4 + -3 + -3 => -10
        return x1 + x2 + x3;
    }

    @Test
    public void test04_Q16() {
        assertThat(operators(), is(-10));
    }

    @Test
    public void test04_Q17() {

        ArrayList<Double> al = new ArrayList<>();
//        al.add(111); //Compile error
        System.out.println(al.indexOf(1.0));
        System.out.println(al.contains("string"));
//        Double d = al.get(al.length); //Compile error

    }
}

class ChangeTestQ29 {

    private int myValue = 0;

    public void showOne(int myValue) {
        myValue = myValue;
    }

    public void showTwo(int myValue) {
        this.myValue = myValue;
    }

    public static void main(String[] args) {

        ChangeTestQ29 ct = new ChangeTestQ29();
        ct.showOne(100);
        System.out.println(ct.myValue);
        ct.showTwo(200);
        System.out.println(ct.myValue);
    }
}