package designpattern.behavioural.strategy;


//Strategy manager
public class CalculatorManager {

    private Calculator calculator;

    public CalculatorManager(){

    }

    public CalculatorManager(Calculator strategy) {
        this.calculator = strategy;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int execute(int num1, int num2){
        return calculator.calculate(num1,num2);
    }
}
