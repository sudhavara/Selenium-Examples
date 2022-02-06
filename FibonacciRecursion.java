package SeleniumInterviewPreparation;

public class FibonacciRecursion {

static int a=0, b=1, nextnum=0;


    public static void main(String[] args){

    int count =10;
        System.out.println(a+" "+b);
        printFibonaci(count-2);

    }

    public static void printFibonaci(int count){

        if(count>0){
            nextnum =a+b;
            a=b;
            b=nextnum;
            System.out.println(" "+nextnum);

            printFibonaci(count-1);
        }

    }

}
