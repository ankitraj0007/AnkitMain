package io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        console();
        copyTextFile();
        copyBinaryFile();
    }

    public static void console(){
        Console console = System.console();
        String name = console.readLine("name:%s","name");
        console.format("hello %s%n", name);
        console.printf("welcome");
        console.writer().println();

        char[] pass = console.readPassword("enter password: ");
    }
    public static void copyTextFile(){
        File sourceFile = new File("C:\\Projects\\AnkitMain\\src\\io\\sourceFile.txt");
        File destinationFile = new File("C:\\Projects\\AnkitMain\\src\\io\\destinationFile.txt");


        try(var rdr = new BufferedReader(new FileReader(sourceFile));
            var wrt = new BufferedWriter(new FileWriter(destinationFile));) {

            //with buffer
            String str = null;
            while ((str = rdr.readLine()) != null){ //buffer reads a line at a time i.e buffers many byte at a time
                wrt.write(str);
                wrt.newLine();
            }

            //without buffer reads byte stream
//            int b;
//            while ((b = rdr.read()) != -1){
//                wrt.write(b);
//            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyBinaryFile(){
        File input = new File("./src/io/Student.class");
        File output = new File("./src/io/StudentOut.class");

        try(var rdr = new BufferedInputStream(new FileInputStream(input));
            var wtr = new BufferedOutputStream(new FileOutputStream(output))) {

            //using buffer
//            var buffer = new byte[1024];
//            int numByteRead;
//            while ((numByteRead = rdr.read(buffer)) > 0){
//                wtr.write(buffer, 0, numByteRead);
//                wtr.flush();
//            }

            ///without buffer
            int b;
            while ((b = rdr.read()) != -1){
                wtr.write(b);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
