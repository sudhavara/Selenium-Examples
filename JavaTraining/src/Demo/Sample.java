package Demo;

public class Sample {

    int a=5;

    public void getData(){
        System.out.println("I am a method");
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        Sample s = new Sample();
        s.getData();
        System.out.println("int value"+s.a);


    }
}
