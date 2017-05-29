package ittengfei.com.googlestore.model;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWareBean {
    private int id;

    private String name;

    private String packageName;

    private String iconUrl;

    private int stars;

    private int size;

    private String downloadUrl;

    private String des;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPackageName(String packageName){
        this.packageName = packageName;
    }
    public String getPackageName(){
        return this.packageName;
    }
    public void setIconUrl(String iconUrl){
        this.iconUrl = iconUrl;
    }
    public String getIconUrl(){
        return this.iconUrl;
    }
    public void setStars(int stars){
        this.stars = stars;
    }
    public int getStars(){
        return this.stars;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setDownloadUrl(String downloadUrl){
        this.downloadUrl = downloadUrl;
    }
    public String getDownloadUrl(){
        return this.downloadUrl;
    }
    public void setDes(String des){
        this.des = des;
    }
    public String getDes(){
        return this.des;
    }

}
