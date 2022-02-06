package SeleniumInterviewPreparation;

public class FibonacciClass {

    public static void main(String[] args){

        int a=0,b=1,nextnum,i,count=10;
        System.out.print(a+" "+b);//printing 0 and 1

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            nextnum=a+b;
            System.out.print(" "+nextnum);
            a=b;
            b=nextnum;
        }

    }
}
