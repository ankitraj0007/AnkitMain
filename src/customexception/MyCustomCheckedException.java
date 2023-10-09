package customexception;

public class MyCustomCheckedException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1525200828503130769L;

    public MyCustomCheckedException(String message) {
        super(message);
    }

    //Mandatory to handle or throw it by calling method

}
