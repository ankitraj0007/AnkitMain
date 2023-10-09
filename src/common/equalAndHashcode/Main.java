package common.equalAndHashcode;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Contact, String> contactHashMap = new HashMap();

        contactHashMap.put(new Contact("ankit",30),"engineer");
        contactHashMap.put(new Contact("raj",30),"engineer");//save in bucket/index as per hash and checks for equals. for same hash new node will be added if objects are not equal in same bucket
        contactHashMap.put(new Contact("ankit",30),"doctor");//contact is equal to 1st, so will be overridden

        System.out.println(contactHashMap);
    }
}
