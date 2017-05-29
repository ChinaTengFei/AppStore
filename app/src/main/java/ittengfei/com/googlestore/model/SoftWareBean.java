package ittengfei.com.googlestore.model;

/**
 * Created by Administrator on 2017-05-28.
 */

public class SoftWareBean {
    private String title;
    private String bitmapUrl;
    private String describe;

    public SoftWareBean(String title, String bitmapUrl, String describe) {
        this.title = title;
        this.bitmapUrl = bitmapUrl;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "SoftWareBean{" +
                "title='" + title + '\'' +
                ", bitmapUrl='" + bitmapUrl + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBitmapUrl() {
        return bitmapUrl;
    }

    public void setBitmapUrl(String bitmapUrl) {
        this.bitmapUrl = bitmapUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
