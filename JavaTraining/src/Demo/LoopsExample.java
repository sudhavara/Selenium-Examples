package Demo;

public class LoopsExample {


    public static void main(String[] args) {

   /*
        3
        6 9
        12 15 18
        */
    int i=1,j=1,k=1;
    for(i=1;i<=3;i++){
        for(j=1;j<=i;j++){
            System.out.print(3*k);
            System.out.print("\t");
            k++;

        }
        System.out.println("");

    }




    }

    public void pattern1(){

          /*
        1
        1 2
        1 2 3
        1 2 3 4 */

        int k=1;
        for (int i = 1; i < 5; i++) {
            for(int j=1; j<=i;j++) {
                System.out.print(j);
                System.out.print("\t");

            }
            System.out.println("");
        }
    }
}
