package ittengfei.com.googlestore.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AppBean implements Parcelable {
        private int id;

        private String name;

        private String packageName;

        private String iconUrl;

        private float stars;

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
        public float getStars(){
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.packageName);
            dest.writeString(this.iconUrl);
            dest.writeFloat(this.stars);
            dest.writeInt(this.size);
            dest.writeString(this.downloadUrl);
            dest.writeString(this.des);
        }

        public AppBean() {
        }

        protected AppBean(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.packageName = in.readString();
            this.iconUrl = in.readString();
            this.stars = in.readFloat();
            this.size = in.readInt();
            this.downloadUrl = in.readString();
            this.des = in.readString();
        }

        public static final Parcelable.Creator<AppBean> CREATOR = new Parcelable.Creator<AppBean>() {
            @Override
            public AppBean createFromParcel(Parcel source) {
                return new AppBean(source);
            }

            @Override
            public AppBean[] newArray(int size) {
                return new AppBean[size];
            }
        };
    }