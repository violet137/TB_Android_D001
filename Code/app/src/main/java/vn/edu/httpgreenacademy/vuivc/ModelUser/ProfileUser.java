package vn.edu.httpgreenacademy.vuivc.ModelUser;


import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import vn.edu.httpgreenacademy.vuivc.Enum.UserTypeEnum;

public class ProfileUser implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("numVideo")
    @Expose
    private int numVideo;

    @SerializedName("numFollower")
    @Expose
    private int numFollower;

    @SerializedName("numFollowing")
    @Expose
    private int numFollowing;

    @SerializedName("sex")
    @Expose
    private boolean sex;

    @SerializedName("nameUser")
    @Expose
    private String nameUser;

    @SerializedName("ngaySinh")
    @Expose
    private String ngaySinh;

    @SerializedName("photo")
    @Expose
    private Bitmap photo;

    @SerializedName("userType")
    @Expose
    private UserTypeEnum userType;

    public ProfileUser() {
    }

    public ProfileUser(Bitmap photo, int id, int numVideo, int numFollower, int numFollowing, boolean sex, String nameUser, String ngaySinh, UserTypeEnum userType) {
        this.photo = photo;
        Id = id;
        this.numVideo = numVideo;
        this.numFollower = numFollower;
        this.numFollowing = numFollowing;
        this.sex = sex;
        this.nameUser = nameUser;
        this.ngaySinh = ngaySinh;
        this.userType = userType;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public int getNumVideo() {
        return numVideo;
    }

    public void setNumVideo(int numVideo) {
        this.numVideo = numVideo;
    }
    public int getNumFollower() {
        return numFollower;
    }

    public void setNumFollower(int numFollower) {
        this.numFollower = numFollower;
    }
    public int getNumFollowing() {
        return numFollowing;
    }

    public void setNumFollowing(int numFollowing) {
        this.numFollowing = numFollowing;
    }
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
}
