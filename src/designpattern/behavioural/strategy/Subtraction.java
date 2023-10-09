package designpattern.behavioural.strategy;

public class Subtraction implements Calculator {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
