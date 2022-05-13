package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	  
    public static void main(String[] args) throws IOException {
//    	Path path = Paths.get("archivobinario.dat");
//        byte[] bytes = {110,110,101,0,0,0,111,100,111};
//        for (int i = 0; i < bytes.length; i++) {
//			System.out.println(bytes[i]);
//		}
//        try {
//            Files.write(path, bytes);    // Java 7+ only
//            System.out.println("Successfully written data to the file");
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    	
    	 FileInputStream fis = new FileInputStream(new File("archivobinario.dat"));
    	 BufferedInputStream reader = new BufferedInputStream(fis);
    	 int ch;
    	 while ((ch = reader.read()) != -1) {
    	    System.out.print(ch);
    	 }
    	 
    }
    
}