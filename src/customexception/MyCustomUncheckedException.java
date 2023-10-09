package customexception;

public class MyCustomUncheckedException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 5423316791075075721L;

    public MyCustomUncheckedException(String message) {
        super(message);
    }

    //not Mandatory to handle or throw it by calling method
}
