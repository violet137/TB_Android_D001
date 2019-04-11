package com.example.profileuser.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class ProfileUser extends BaseObservable {
    int photo,Id,numVideo,numFollower,numFollowing;
    boolean sex;
    String nameUser,ngaySinh;

    public ProfileUser() {
    }

    public ProfileUser(int photo, int id, int numVideo, int numFollower, int numFollowing, boolean sex, String nameUser, String ngaySinh) {
        this.photo = photo;
        Id = id;
        this.numVideo = numVideo;
        this.numFollower = numFollower;
        this.numFollowing = numFollowing;
        this.sex = sex;
        this.nameUser = nameUser;
        this.ngaySinh = ngaySinh;
    }
    @Bindable
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
        notifyPropertyChanged(BR.photo);
    }
    @Bindable
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public int getNumVideo() {
        return numVideo;
    }

    public void setNumVideo(int numVideo) {
        this.numVideo = numVideo;
        notifyPropertyChanged(BR.numVideo);
    }
    @Bindable
    public int getNumFollower() {
        return numFollower;
    }

    public void setNumFollower(int numFollower) {
        this.numFollower = numFollower;
        notifyPropertyChanged(BR.numFollower);
    }
    @Bindable
    public int getNumFollowing() {
        return numFollowing;
    }

    public void setNumFollowing(int numFollowing) {
        this.numFollowing = numFollowing;
        notifyPropertyChanged(BR.numFollowing);
    }
    @Bindable
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }
    @Bindable
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
        notifyPropertyChanged(BR.nameUser);
    }
    @Bindable
    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
        notifyPropertyChanged(BR.ngaySinh);
    }
}
