package SeleniumInterviewPreparation;

import java.util.Scanner;

public class PrimenumberCheck {
    public static void main(String[] args){
        int i, number, flag = 0;
        System.out.println("Enter any number to check prime or not ::  ");
            Scanner s = new Scanner(System.in);
            number = s.nextInt();

        System.out.println("number is "+number);
        for(i=2;i<number;i++) {
            if (number % 2 != 0) {
                flag++;

            }
        }
            if(flag>0){
                System.out.println("given number " +i +" is a prime number");
            }else{
                System.out.println("given number " +i +" is not a prime number");
            }




    }
}
