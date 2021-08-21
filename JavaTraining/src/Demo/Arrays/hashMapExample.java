package Demo.Arrays;

import java.util.*;

public class hashMapExample {

    public static void main(String[] args){
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(0,"USA");
        hm.put(1,"Apple");
        hm.put(7,"India");
        hm.put(3,"Baloon");
        hm.put(10,"Rocklin");
        hm.put(5,"Aligator");
        hm.put(3,"Holland");
        Set set = hm.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> map = (Map.Entry<Integer,String>)it.next();
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }



    }
}
