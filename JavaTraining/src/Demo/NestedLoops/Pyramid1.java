package Demo.NestedLoops;

public class Pyramid1 {

    public static void main(String[] args){
        Pyramid1 p =new Pyramid1();

        //p.traianglepyramid();
        p.reversePyramid();

    }

    public void traianglepyramid(){
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         */
        int i=0;int j=0;
        for (i=0; i<5; i++)
        {
            for ( j=5-i; j>1; j--)
            {
                // printing spaces
                System.out.print(" ");
            }
            for ( j = 0; j <= i; j++) {
                System.out.print("* ");

            }


            System.out.println(""); //ending line after each row
        }
    }

    public void reversePyramid(){
        //outer for loop for number of rows
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 0; j < i-1; j++)
            {
                System.out.print(" ");
            }
            for(int j=i;j<=6;j++)
            {
                System.out.print(j+" ");

            }
            System.out.println();
        }

    }




}


