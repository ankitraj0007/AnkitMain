package designpattern.creational.abstract_factory;

import designpattern.creational.abstract_factory.factory.AbstractFactory;
import designpattern.creational.abstract_factory.factory.AbstractFactoryProducer;
import designpattern.creational.abstract_factory.professional.Profession;

public class Main {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession("trainee");
        Profession profession = abstractFactory.getProfession("Engineer");
        profession.print();
    }
}
