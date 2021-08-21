package Demo.Arrays;

public class Sample1 {

    public static void main(String[] args){

        int a[][] = new int[3][3];
        a[0][0]=2;a[0][1]=4;a[0][2]=6;
        a[1][0]=8;a[1][1]=10;a[1][2]=12;
        a[2][0]=14;a[2][1]=16;a[2][2]=18;
        int b[][] ={{2,4,6},{8,10,12},{14,16,18}};


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(b[i][j]);

            }
        }

    }
}
