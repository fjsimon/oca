package com.design.pattern.structural.Decorator;

public class BasicCar implements Car {

    @Override
    public void assemble() {

        System.out.print("Basic Car.");
    }
}