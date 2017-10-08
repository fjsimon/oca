package com.oca.exam.methods;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MethodTest {

    public static void printSum(int a, int b) {
        System.out.println("In int " + (a + b));
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println("In Integer " + (a + b));
    }

    public static void printSum(double a, double b) {
        System.out.println("In double " + (a + b));
    }

    @Test
    public void test03_Q06() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printSum(1, 2);
        assertThat("In int 3\n", is(outputStream.toString()));
    }

    public static void processStacks(Stack x1, Stack x2) {

        x1.push(new Integer("100")); //assume that the method push adds the passed object to the stack.
        x2 = x1;
    }

    @Test
    public void test01_stack() {

        Stack s1 = new Stack();
        Stack s2 = new Stack();
        processStacks(s1, s2);
        System.out.println(s1 + "    " + s2);
    }

    class Base {
        public Object getValue() {
            return new Object();
        } //1
    }

    class Base2 extends Base {
        public String getValue() {
            return "hello";
        } //2
    }

    @Test
    public void test01_base() {

        Base b = new Base2();
        assertThat(b.getValue(), is("hello")); //3
    }

    void probe(Integer x) {
        System.out.println("In Integer");
    } //2

    void probe(Object x) {
        System.out.println("In Object");
    } //3

    void probe(Long x) {
        System.out.println("In Long");
    } //4

    @Test
    public void test01_Q18() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String a = "hello";
        probe(a);
        assertThat("In Object\n", is(outputStream.toString()));
    }

    @Test
    public void test02_Q23() {
        System.out.println(new MNOP().x + ", " + new MNOP().y);
    }

    @Test
    public void test02_Q30() {

        ClassQ30 a, b;
        a = new ClassQ30();  //(2)
        assertThat(a.l1, is(0L));
//        b = new ClassQ30(5);  //(3) Compilation error
    }

    class Super {
    }

    class Sub extends Super {
    }

    @Test
    public void test02_Q38() {
        Super s1 = new Super(); //1
        Sub s2 = new Sub();     //2
        s1 = (Super) s2;        //3
        assertThat(s1, instanceOf(Super.class));
        assertThat(s2, instanceOf(Super.class));
    }

    class A {
    }

    class AA extends A {
    }

    @Test
    public void test02_Q40() {
        A a = new A();
        AA aa = new AA();
        a = aa;
        assertThat(a.getClass().toString(), is("class com.oca.exam.methods.MethodTest$AA"));
        assertThat(aa.getClass().toString(), is("class com.oca.exam.methods.MethodTest$AA"));
    }

    class Base3 {
        public short getValue() {
            return 1;
        } //1
    }

    class Base4 extends Base3 {
//    public byte getValue(){ return 2; } //2 Compile error
    }

    @Test
    public void test02_Q45() {
        Base3 b = new Base4();
        assertThat(b.getValue(), is((short) 1)); //3
    }

    @Test(expected = NullPointerException.class)
    public void test04_Q27() {
        final Holder a = new Holder(5);
        Holder b = new Holder(10);
        a.link = b;
        b.link = Holder.setIt(a, b);
        System.out.println(a.link.value + " " + b.link.value);
    }

    @Test
    public void test04_Q39() {

        InitTest it = new InitTest();
    }

    @Test
    public void test05_Q18() {

        new TestClassQ18().m1();
    }

    @Test
    public void test06_Q37() {

        InitClassQ37 obj = new InitClassQ37(5);
    }

    @Test
    public void test06_Q70() {

        TestClassQ70 tc = new TestClassQ70();
        tc.method(null);
    }
}

class ABCD {
    int x = 10;
    static int y = 20;
}

class MNOP extends ABCD {
    int x = 30;
    static int y = 40;
}

class ClassQ30 {
    long l1;

    public void ClassQ30(long pLong) {
        l1 = pLong;
    }//(1)
}

class ClassQ46 {

    void m1() {
        ClassQ46.m2();  // 1
        m4();             // 2
//        ClassQ46.m3();  // 3 Compile error
    }

    static void m2() {
    }  // 4

    void m3() {
        m1();            // 5
        m2();            // 6
//        ClassQ46.m1(); // 7 Compile error
    }

    static void m4() {
    }
}

class Holder {
    int value = 1;
    Holder link;

    public Holder(int val) {

        this.value = val;
    }

    public static Holder setIt(final Holder x, final Holder y) {

        x.link = y.link;
        return x;
    }
}

class InitTest {
    static String s1 = sM1("a");

    {
        s1 = sM1("b");
    }

    static {
        s1 = sM1("c");
    }

    private static String sM1(String s) {
        System.out.println(s);
        return s;
    }
}

class TestClassQ18 {

    char c;

    public void m1() {
        char[] cA = {'a', 'b'};
        m2(c, cA);
        System.out.println(((int) c) + "," + cA[1]);
    }

    public void m2(char c, char[] cA) {
        c = 'b';
        cA[1] = cA[0] = 'm';
    }
}

class InitClassQ37 {

    int m;
    static int i1 = 5;
    static int i2;
    int j = 100;
    int x;

    public InitClassQ37(int m) {
        System.out.println(i1 + "  " + i2 + "   " + x + "  " + j + "  " + m);
    }

    {
        j = 30;
        i2 = 40;
    }  // Instance Initializer

    static {
        i1++;
    }      // Static Initializer
}

class TestClassQ70{

    public void method(Object o){
        System.out.println("Object Version");
    }
    public void method(java.io.FileNotFoundException s){
        System.out.println("java.io.FileNotFoundException Version");
    }
    public void method(java.io.IOException s){
        System.out.println("IOException Version");
    }
}