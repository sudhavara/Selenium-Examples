package Demo.Arrays;

import java.util.Arrays;


   /*
        2 4 5
        3 4 7
        1 2 9*/

public class CiscoInterview {
    int a[][]={{2,4,5},{3,4,7},{1,2,0}};
    int rownumber =0;
    int columnindex =0;


    public static void main(String[] args){

        CiscoInterview object = new CiscoInterview();
        int row = object.minNumber();
        object.mxNumber(row, object.columnindex);

    }

    public int mxNumber(int rowindex,int columnindex){

        System.out.println("entered in to max method");
        int maxnumber=0;
        maxnumber=a[0][columnindex];
        //either you can use for loop or while loop to increment i value from 0 to 3 because only row should increase columnindex will be same
        for(int i=0;i<3;i++)
        {
            if(a[i][columnindex]>maxnumber)
            {
                maxnumber=a[i][columnindex];
            }

        }

        System.out.println(maxnumber);
        return maxnumber ;
    }








    public int minNumber(){

        int minnumber = a[0][0];
        int number2 =0;

        int j=0;

        for(int i=0;i<a.length;i++){
            //System.out.println("row value is "+i);
            for( j=0;j<a[0].length;j++){

                number2 = a[i][j];
               // System.out.println("number2 is "+number2);
                if(minnumber<number2){
                    minnumber = minnumber;
                }else{
                    minnumber = number2;
                    System.out.println("column value is "+j);
                    columnindex=j;
                    System.out.println("column index is "+columnindex);
                    rownumber = i;

                }
            }


            //System.out.println("min value present in the row "+i+ "for the column "+ columnindex +" and value is "+minnumber);


        }
        System.out.println("row index is"+rownumber);
        System.out.println("Final Minimum value present in the row "+rownumber +" and column number "+ columnindex+" min value is "+minnumber);
        return rownumber;

    }
}
