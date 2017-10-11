package fileinputstreams;

import java.io.*;

public class FileInputStreams {

    public static FileInputStreams f1(String fileName) throws FileNotFoundException {
       FileInputStreams fis = new FileInputStreams(fileName);
       System.out.println("f1: File Input Stream created.");
       return fis;
    }
    
    public static FileInputStreams f2(String fileName) {
        FileInputStreams fis = null;
        
        fis = new FileInputStreams(fileName);
        
        System.out.println("f2: Returning from f2");
        return fis;
    }
    
    public static void main (String args[]) {
        FileInputStreams fis1 = null;
        FileInputStreams fis2 = null;
        String fileName = "psychopass";
        
        System.out.println("main: Starting ... " + FileInputStreams.class.getName() + " with file name " + fileName);
        
        try {
            fis1 = f1(fileName);
        }
        
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        
        catch (Exception ex) {
            System.out.println("General exception caught.");
        }
        
        fis2 = f2(fileName);
        System.out.println("main: " + FileInputStreams.class.getName() + " ended.");
    }

    private FileInputStreams(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
