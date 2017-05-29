package ittengfei.com.googlestore.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017-05-29.
 */

public class TitleValueBean implements Parcelable {

        private String url;
        private String title;
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

    @Override
    public String toString() {
        return "TitleValueBean{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
    }

    public TitleValueBean() {
    }

    protected TitleValueBean(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<TitleValueBean> CREATOR = new Parcelable.Creator<TitleValueBean>() {
        @Override
        public TitleValueBean createFromParcel(Parcel source) {
            return new TitleValueBean(source);
        }

        @Override
        public TitleValueBean[] newArray(int size) {
            return new TitleValueBean[size];
        }
    };


}
