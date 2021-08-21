package Demo;

public class PyramidTriangle {

    public static void main(String[] args) {
        /*
        1
        2 3
        4 5 6
        7 8 9 10

         */
        int i = 0;
        int j = 1;
        int k = 1;

        for( i=1;i<5;i++){
            for(j=1;j<=i;j++){
                System.out.print(k);
                System.out.print("\t");
                k++;
            }
            System.out.println("");
        }






    }



        public void upsidedown () {
        /*
        1	2	3	4
        5	6	7
        8	9
        10

         */

            int j = 1;
            int i = 1;
            int k = 1;
            for (i = 0; i < 4; i++) {
                // System.out.println(i);
                for (j = 1; j <= 4 - i; j++) {
                    System.out.print(k);
                    System.out.print("\t");
                    k++;
                }
                System.out.println("");
            }
        }



}
