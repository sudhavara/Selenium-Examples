package Demo.Arrays;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class hashMapGrouping {

    public static void main(String[] args){

        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        hm.put("USA",0);
        hm.put("Apple",1);
        hm.put("India",7);
        hm.put("Baloon",1);
        hm.put("Rocklin",10);
        hm.put("Aligator",5);
        hm.put("Hippo",5);
        hm.put("Holland",5);
        hm.put("Horse",3);
        hm.put("Cat",20);
        hm.put("Elephant",20);
        hm.put("Animal",2);


        Map<Integer, List<String>> mapList = new HashMap<Integer, List<String>>();
        Iterator<Map.Entry<String, Integer >> it = hm.entrySet().iterator();
        /*
        while(it.hasNext()){
            Map.Entry<Integer, String> next = it.next();
            if (mapList.get(next.getValue()) != null) {
                List<String> name=new ArrayList<String>();
                name.add(next.getValue());
                mapList.put(next.getKey(), name);
            }else {
                List<String> name = new ArrayList<String>();
                name.add(next.getValue());
                mapList.put(next.getKey(), name);
            }*/

        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            List<String> list = new ArrayList<String>();
            if(result.containsKey(entry.getValue()))
                list = result.get(entry.getValue());
            list.add(entry.getKey());
            result.put(entry.getValue(), list);

            }
        Set<Integer> keys = result.keySet();
        System.out.println("keys are "+keys);

        System.out.println(keys.size());
        List maxvaluelist =null;
        List<String> valuelist =null;
        for(int key=0;key<keys.size();key++){
            valuelist =result.get(key);
           // System.out.println(result.get(key));
            //System.out.println(valuelist);
            if(valuelist!=null) {
                //System.out.println("values size is " + valuelist.size());

                maxvaluelist = result.get(0);


                if (maxvaluelist.size() > valuelist.size()) {
                    maxvaluelist= maxvaluelist;

                }else{
                    maxvaluelist = valuelist;

                }

            }



            }
        System.out.println("maxvaluelist is "+maxvaluelist.toString());
        System.out.println(" max value list size is" + maxvaluelist.size());
        //System.out.println(" maximum value list is "+maxvaluelist + "for the key value"+key);



        //System.out.println("list is with out java8 "+result);

        Map<Integer, List<String>> finalresult =  hm.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println("final result with streaming is "+finalresult);
        //finalresult.forEach((s,k)->s.hashCode(hm.get(finalresult.keySet())));



        }

        //using java8






    }

