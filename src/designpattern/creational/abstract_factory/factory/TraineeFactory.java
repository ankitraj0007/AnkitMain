package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.professional.Profession;
import designpattern.creational.abstract_factory.trainee.TraineeEngineer;
import designpattern.creational.abstract_factory.trainee.TraineeTeacher;

public class TraineeFactory implements AbstractFactory {

    @Override
    public Profession getProfession(String typeOfProfession) {

        if (typeOfProfession == null) {
            return null;
        } else if (typeOfProfession.equalsIgnoreCase("Engineer")) {
            return new TraineeEngineer();

        } else if (typeOfProfession.equalsIgnoreCase("Teacher")) {
            return new TraineeTeacher();
        }

        return null;
    }

}
