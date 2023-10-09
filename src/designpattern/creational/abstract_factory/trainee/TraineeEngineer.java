package designpattern.creational.abstract_factory.trainee;

import designpattern.creational.abstract_factory.professional.Profession;

public class TraineeEngineer implements Profession {

    @Override
    public void print() {
        System.out.println("In Print of Trainee Engineer class");

    }

}
