public class ProcessUrl {

    public String getUrl(String url){
        if(url==null){
            return "me";
        }
        String ut=url.substring(1,5);
        System.out.println(ut);
        return ut;
    }


}
