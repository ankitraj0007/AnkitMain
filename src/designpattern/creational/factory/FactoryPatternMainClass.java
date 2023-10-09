package designpattern.creational.factory;

public class FactoryPatternMainClass {

    public static void main(String[] args) {

        Profession profession = ProfessionFactory.getProfession(ProfessionType.DOCTOR);
        profession.print();

    }

}
