package Demo.NestedLoops;

public class TraingleStar {

    public static void main(String[] args){
        TraingleStar tr = new TraingleStar();
       // tr.rightTraingle();
        tr.leftTraingle();

}

public void leftTraingle(){

    for(int i=1;i<5;i++){

        for(int k=3+i;k>1;k--){
            System.out.print(" ");

        }
        for(int j=0;j<=i;j++){

            //System.out.println("\t");
            System.out.print("*");
        }
        System.out.println("");

    }




}

public void rightTraingle(){
        /*
         *
         *	*
         *	*	*
         *	*	*	*
         *	*	*	*	*

         */

        for(int i=1;i<6;i++){

            for(int j=1;j<=i;j++){
                System.out.print("*");
                System.out.print("\t");
            }
            System.out.println("");

        }

    }


    }

