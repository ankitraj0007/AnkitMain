package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.factory.AbstractFactory;
import designpattern.creational.abstract_factory.factory.ProfessionalFactory;
import designpattern.creational.abstract_factory.factory.TraineeFactory;

// this is factory of factory , gives u factory instance which will in turn give u required class object
public class AbstractFactoryProducer {

    public static AbstractFactory getProfession(String factory) {
        if (factory.equals("trainee")) {
            return new TraineeFactory();
        } else {
            return new ProfessionalFactory();
        }
    }

}
