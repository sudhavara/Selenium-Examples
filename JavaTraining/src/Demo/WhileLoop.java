package Demo;

public class WhileLoop {

    public static void main(String[] args) {
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
        System.out.println("now i value is " + i);
        while (i > 0) {
            System.out.println(i);
            i--;
        }
        int j=20;
        do{
            System.out.println(j);
            j++;
        }while(j<=30);
        System.out.println("value of j in while loop");
            System.out.println(j);




    }
}
