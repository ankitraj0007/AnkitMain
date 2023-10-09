package designpattern.creational.abstract_factory.trainee;

import designpattern.creational.abstract_factory.professional.Profession;

public class TraineeTeacher implements Profession {

    @Override
    public void print() {
        System.out.println("In Print of Trainee Teacher class");

    }

}
