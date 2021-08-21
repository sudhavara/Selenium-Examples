package Demo;

public class PalindromeCheck {

    public static void main(String[] args){
        String name = "SUDHA";
        String reversename ="";
        System.out.println("length is "+name.length());
        for(int i=name.length()-1;i>=0;i--){
            System.out.println(name.charAt(i));
            reversename = reversename+name.charAt(i);

        }
        System.out.println("reversename is "+reversename);
        if(reversename.equals(name)){
            System.out.println("given string "+name+" is a Palindrome");
        }else{
            System.out.println("given string "+name+" is not a Palindrome");
        }
    }
}
