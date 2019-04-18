package vn.edu.httpgreenacademy.vuivc.ModelUser;


import android.graphics.Bitmap;

import java.io.Serializable;

public class ProfileUser implements Serializable {
    int Id,numVideo,numFollower,numFollowing;
    boolean sex;
    String nameUser,ngaySinh;
    Bitmap photo;
    public ProfileUser() {
    }

    public ProfileUser(Bitmap photo, int id, int numVideo, int numFollower, int numFollowing, boolean sex, String nameUser, String ngaySinh) {
        this.photo = photo;
        Id = id;
        this.numVideo = numVideo;
        this.numFollower = numFollower;
        this.numFollowing = numFollowing;
        this.sex = sex;
        this.nameUser = nameUser;
        this.ngaySinh = ngaySinh;
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
}
