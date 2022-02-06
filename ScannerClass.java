package SeleniumInterviewPreparation;//scan line by line of a file

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerClass {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\SeleniumUdemy\\InterviewPreparation\\solutions.txt");
        Scanner scanner = new Scanner(fis);
        while(scanner.hasNextLine()){
            //System.out.println("next line is "+scanner.hasNextLine());
            System.out.println("Line is "+scanner.nextLine());

        }
        scanner.close();

    }


}
