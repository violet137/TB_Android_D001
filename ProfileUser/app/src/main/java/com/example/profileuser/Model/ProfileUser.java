package com.example.profileuser.Model;

public class ProfileUser {
    int photo,ID;
    boolean sex;
    String nameuser,ngaysinh;

    public ProfileUser(int photo) {
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
