package parser;

import java.util.ArrayList;
import java.util.List;

public class Copyright {
    public String title;
    public List<String> link;
    public String image;
    public String provider;

    public Copyright(String title,String image,String provider){
       this.image = image;
       this.link = new ArrayList<String>();
       this.title = title;
       this.provider = provider;
    }
}
