package Demo.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class maxHashMapValue {

    public static void main(String[] args){
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(0,"Apple");
        hm.put(0,"Boy");
        hm.put(2,"cat");
        hm.put(2,"elephant");
        hm.put(3,"horse");
        hm.put(3,"rock");
        hm.put(4,"buffalo");
        hm.put(5,"peacock");
        hm.put(6,"rabbit");
        Map.Entry<Integer, List<String>> maplist ;
        Map<Integer, List<String>> finalresult ;
              // List<Integer> list =  hm.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getKey));


    }
}
