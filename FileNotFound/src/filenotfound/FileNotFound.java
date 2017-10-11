package filenotfound;

import java.io.*;

public class FileNotFound {

    public static FileNotFound f1(String fileName) throws FileNotFoundException {
        FileNotFound fis = new FileNotFound(fileName);
        System.out.println("f1: File input stream created");
        return fis;
    }
    
    public static FileNotFound f2(String fileName) {
        FileNotFound fis = null;
        try {
            fis = new FileNotFound(fileName);
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
