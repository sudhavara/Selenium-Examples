package SeleniumInterviewPreparation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderClass {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\SeleniumUdemy\\InterviewPreparation\\solutions.txt");
        FileReader fileread = new FileReader(file);

        BufferedReader buffreader = new BufferedReader(fileread);
        StringBuffer stringBuffer = new StringBuffer();
        String line ;

        while((line=buffreader.readLine())!=null){
            stringBuffer.append(line);
            stringBuffer.append("\n");

        }
        fileread.close();
        System.out.println("line is "+stringBuffer.toString());



    }
}
