package designpattern.creational.factory;

public class ProfessionFactory {

    public static Profession getProfession(ProfessionType typeOfProfession) {
        if (typeOfProfession == null) {
            return null;
        }
        if (typeOfProfession == ProfessionType.DOCTOR) {
            return new Doctor();

        } else if (typeOfProfession == ProfessionType.ENGINEER) {
            return new Engineer();

        } else if (typeOfProfession == ProfessionType.TEACHER) {
            return new Teacher();
        }

        return null;
    }

}
