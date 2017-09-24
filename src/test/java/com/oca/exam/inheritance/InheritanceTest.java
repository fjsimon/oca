package com.oca.exam.inheritance;

import org.junit.Test;

public class InheritanceTest {

    @Test
    public void test3Q01() {
        B c = new C();
        System.out.println(c.max(10, 20));
    }

    @Test
    public void test04_Q36() {

        new TestClass();
    }

    @Test
    public void test04_Q46() {

        AQ46 a = new BQ46();
        System.out.println(a.i);
        a.m1();
        a.m2();
    }

    @Test
    public void test05_Q02() {

        Child b = new Child();
        b.fi = 20;
        System.out.println(b.fi);
        System.out.println(  (  (Parent) b  ).fi  );
    }
}

class A {
    int max(int x, int y)  { if (x>y) return x; else return y; }
}
class B extends A {
    int max(int x, int y)  {  return 2 * super.max(x, y) ; }
}
class C extends B {
    int max(int x, int y)  {  return super.max( 2*x, 2*y); }
}

class TestClass {
    static int si = 10;
    public TestClass(){
        System.out.println(this);
    }
    public String toString(){
        return "TestClass.si = "+this.si;
    }
}

class AQ46 {
    int i = 10;

    public static void m1() {
        System.out.println("A m1");
    }

    public void m2() {
        System.out.println("A m2");
    }
}

class BQ46 extends AQ46 {
    int i = 20;

    public static void m1() {
        System.out.println("B m1");
    }

    public void m2() {
        System.out.println("B m2");
    }
}

class Parent {
    final int fi = 10;
}

class Child extends Parent {
    int fi = 15;
}


//interface Account{
//    public default String getId(){
//        return "0000";
//    }
//}
//interface PremiumAccount extends Account{
//    public String getId();
//}
//public class BankAccount implements PremiumAccount{
//    public static void main(String[] args) {
//        Account acct = new BankAccount();
//        System.out.println(acct.getId());
//    }
//}