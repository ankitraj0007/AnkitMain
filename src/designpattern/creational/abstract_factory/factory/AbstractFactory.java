package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.professional.Profession;

public interface AbstractFactory {

    public Profession getProfession(String typeOfProfession);

}
