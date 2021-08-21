import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsComplex {


    public static void main(String[] args) throws IOException {
        List<IPDATA> records = populateData();
        records.stream().collect(Collectors.groupingBy(IPDATA::getLoc, Collectors.mapping(IPDATA::getIp,Collectors.toList()))).forEach((u,v)->{
            System.out.println(u+":"+v);
        });
        //System.out.println("records are"+records);


    }

    static List<IPDATA> populateData() throws IOException {
        final List<IPDATA> ipdataArrayList = new ArrayList<IPDATA>();
        Stream<String> stream = Files.lines(Paths.get("D:\\SeleniumUdemy\\IPsTestData.csv"));
        ArrayList<String> arrayList = stream.skip(1).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("array data with out header is " + arrayList.get(0));
        arrayList.stream().forEach(s -> {
            IPDATA iprecord = new IPDATA(s.split("\\|")[1], s.split("\\|")[2], s.split("\\|")[3], s.split("\\|")[4], s.split("\\|")[5]);
            //System.out.println(s.split("\\|")[1]);
            //System.out.println(iprecord.getIp());
            ipdataArrayList.add(iprecord);


        });

        return ipdataArrayList ;
    }

}









