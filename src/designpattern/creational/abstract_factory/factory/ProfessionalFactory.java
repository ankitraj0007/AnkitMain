package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.professional.Profession;
import designpattern.creational.abstract_factory.professional.Engineer;
import designpattern.creational.abstract_factory.professional.Teacher;

public class ProfessionalFactory implements AbstractFactory {

    @Override
    public Profession getProfession(String typeOfProfession) {

        if (typeOfProfession == null) {
            return null;
        } else if (typeOfProfession.equalsIgnoreCase("Engineer")) {
            return new Engineer();

        } else if (typeOfProfession.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        }

        return null;
    }

}
