package designpattern.behavioural.strategy;

public class Main {

    public static void main(String[] args) {
        CalculatorManager manager = new CalculatorManager(new Addition()); //strategy manager with addition strategy
        System.out.println(manager.execute(4,5)); // execute strategy

        CalculatorManager manager1 = new CalculatorManager(); //strategy manager
        manager1.setCalculator(new Multiplication()); // set strategy
        System.out.println(manager1.execute(4,5)); // execute strategy

        manager1.setCalculator(new Subtraction());
        System.out.println(manager1.execute(4,5));
    }
}
