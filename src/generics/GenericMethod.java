package generics;

public class GenericMethod {

    public <T> boolean isEqual( T value1, T value2) {
        if( value1 == value2 ) return true;
        else return false;
    }
}
