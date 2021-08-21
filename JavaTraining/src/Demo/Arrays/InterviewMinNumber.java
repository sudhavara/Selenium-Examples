package Demo.Arrays;

public class InterviewMinNumber {
    public static void main(String[] args){
        InterviewMinNumber object = new InterviewMinNumber();

        System.out.println(object.minNumber());
        System.out.println(object.maxNumber());


    }

    public int maxNumber(){
          /*
        2 4 5
        3 4 7
        1 2 9*/
        int number1=0;
        int number2=0;
        int maxnumber=0;

        int array[][]={{2,4,5},{3,4,7},{1,2,9}};
        maxnumber= array[0][0];

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){
                number2= array[i][j];

                //System.out.println(number2);
                if(maxnumber> number2){
                    maxnumber = maxnumber;
                    //System.out.println("min number is"+maxnumber);
                }else{
                    maxnumber = number2;
                    // System.out.println("min number is"+maxnumber);
                }

            }


        }
        System.out.println("finally minimum number from the matrix is "+maxnumber);
        return maxnumber;


    }



    public int minNumber(){
         /*
        2 4 5
        3 4 7
        1 2 9*/
        int number1=0;
        int number2=0;
        int minnumber=0;

        int array[][]={{2,4,5},{3,4,7},{1,2,9}};
        minnumber= array[0][0];

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){
                number2= array[i][j];

                //System.out.println(number2);
                if(minnumber< number2){
                    minnumber = minnumber;
                    //System.out.println("min number is"+minnumber);
                }else{
                    minnumber = number2;
                    // System.out.println("min number is"+minnumber);
                }
                //System.out.println("minimum value found column  "+j);

            }


        }
        System.out.println("finally minimum number from the matrix is "+minnumber);
        return minnumber;


    }
}
