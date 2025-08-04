package enumexample;

public class EnumMain {
    public static void main(String[] args) {
        Enum1 e1 = Enum1.Ankit;

        switch (e1) {
            case Ankit:
                System.out.println("male");
                break;
            case Aparna:
                System.out.println("female");
            default:
                System.out.println("human");
        }

        Enum2 e2 = Enum2.Aparna;

        switch (e2.getCode()) {
            case 1:
                System.out.println("male");
                break;
            case 2:
                System.out.println("female");
                break;
            default:
                System.out.println("human");
        }

        Enum3 e3 = Enum3.baby;
        System.out.println(e3.gender());

        for( Enum1 enum1 : Enum1.values()){
            System.out.println(enum1);
        }

        variablArgumnt("variable argumnt example", 1, 2, 3);
    }

    public static void variablArgumnt(String s, int... i) {
        System.out.println(s);
        for (int j : i) {
            System.out.print(j + ",");
        }
    }
}
