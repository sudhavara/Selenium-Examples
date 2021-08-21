public class Basic {

    public static void main(String[] args){

        //main execution of java class
        System.out.println("Main method execution");

        TestCases testcases = new TestCases();//memory allocation in paent calss
        System.out.println(testcases.vaildateHeader());
        System.out.println("Header method called");

    }
}
