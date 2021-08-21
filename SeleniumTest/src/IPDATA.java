public class IPDATA {

    private String url;
    private String time;
    private String ip;
    private String loc;
    private String blog;


    public IPDATA(String ip, String blog,String url,String time,String loc) {
        this.ip = ip;
       this.blog = blog;
       this.url = url;
       this.time = time;
       this.loc = loc;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTime(){
        return time;
    }
    public void setTime(){
        this.time = time;
    }
    public String getBlog(){
        return blog;
    }
    public void setBlog(){
        this.blog = blog;
    }

    public String getLoc(){
        return loc;
    }
    public void setLoc(){
        this.loc = loc;
    }

    public String toString()
    {
        return getLoc();
    }








    }
