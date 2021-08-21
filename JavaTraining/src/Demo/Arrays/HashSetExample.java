package Demo.Arrays;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Apple");
        hs.add("california");
        hs.add("Ball");
        hs.add("cucumber");
        hs.add("Antelope");
        hs.add("Ballooon");
        hs.add("India");
        hs.add("USA");
        hs.add("India");
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
        Iterator<String> it = hs.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        while(it.hasNext()){
            System.out.println(it.next());

        }




    }
}
