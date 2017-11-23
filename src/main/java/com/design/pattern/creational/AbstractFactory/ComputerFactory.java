package com.design.pattern.creational.AbstractFactory;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory){

        return factory.createComputer();
    }
}