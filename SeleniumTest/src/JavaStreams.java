import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreams {

    private static Object Arrays;

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Venkata Sitaram");
        names.add("Sudha");
        names.add("Sri");
        names.add("Pilaka");
        names.add("rani");
        names.add("Srivatsa");
        names.add("Shashank");
        names.add("sri");
        long c = names.stream().filter(s -> s.startsWith("S")).count();
        System.out.println("names strat with s count" + c);

        //find the names whose length >4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println("final names list are " + s));
        //find the names of length>1 and print only 1 name in final list
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println("only one name in the list" + s));
        //to change final names list to upper case
        names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println("ends with a and uppercase names are" + s));
        //sorted names with filter of strats with s
        names.stream().filter(s -> s.startsWith("S")).sorted().map(s -> s.toUpperCase()).sorted()
                .forEach(s -> System.out.println("sorted names starts with a are" + s));

        //any match method on names list
        boolean bflag = names.stream().anyMatch(s -> s.contains("Venkat"));
        Assert.assertTrue(bflag);

      String[] firstarray =  {"Ram","Sam","Dam","Tom","ananya","balu","chetan","doug"};
      String[] secondarray = {"Venkat","Sudha","Shashank","Srivatsa"};

        List<String>firstarraylist = java.util.Arrays.asList(firstarray);




        List<String>secondarraylist=java.util.Arrays.asList(secondarray);
        Function<String,String> f= (i)-> {
            if (i.contains("am")) {
                return i;
            } else{
                return "";
        }
//        return "";
        };

                System.out.println(firstarraylist.stream().collect(Collectors.groupingBy(f,Collectors.toList())));
//                forEach((s1,s2)-> System.out.println(s1+":"+s2));
//        groupedlist.get(0);












    }
}


