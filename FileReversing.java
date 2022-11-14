/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereversing;

// importing packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner; 

/**
 *
 * @author CyberRide
 */
public class FileReversing {

    public static void main(String args[]) throws FileNotFoundException, IOException  {  
            // WELCOME MESSAGE
            System.out.println("============================================================\nPROJECT NAME:FILE CREATION-REVERSING THE CONTENT-EXTRACTING-REPLACEMENT");
            System.out.println("    CyberRide                \n============================================================"); 
            Scanner sc= new Scanner(System.in);
    //Creating file Javafile.txt
try {
    // creating instance of File 
      File myObj = new File("javaFILE.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
          // Display if file Already Exists
       System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
try {
    try (FileWriter myWriter = new FileWriter("javaFILE.txt")) {
        String text;
        System.out.println("Enter string content: ");
        text=sc.nextLine();
        myWriter.write(text);
        // System.out.println("Successfully wrote to the file.");
    }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
 try{
         // creating instance of file to reverse content in the text file 
  File sourceFile=new File("javaFILE.txt");//input File Path
  File reverseFile=new File("javaREVERSE.txt");//out put file path for reverse
  File extractFile=new File("javaExtract.txt");// output file path for extract
  File bytesFile=new File("javaBYTES.txt");// output file path for bytes

  PrintWriter pwriter;
    try (Scanner content = new Scanner(sourceFile)) {
        while(content.hasNextLine())
        {
            
//reversing javaFILE.txt content
            pwriter = new PrintWriter(reverseFile);
            String s=content.nextLine();
            StringBuffer buffer = new StringBuffer(s);
            buffer=buffer.reverse();
            String reverse=buffer.toString();
            pwriter.println(reverse);
            pwriter.close();
            
            // display java.txt content
            
//            System.out.println(s);
            
            //Extracting java.txt content
            System.out.println("Input to extract string by specifying the position: ");
            int d;
            d=sc.nextInt();
            pwriter = new PrintWriter(extractFile);
            String substring = s.substring(d);
            String extract= substring;
            pwriter.println(extract);
            pwriter.close();
            
            //covert java.txt to byte
            pwriter = new PrintWriter(bytesFile);
            byte[] substrings = s.getBytes();
            byte[] rs=substrings;
            pwriter.println(Arrays.toString(rs));
            pwriter.close();
        } }    
  
  }

  catch(Exception e){
      System.out.println("Something went wrong");
  }

}
}
    

