package com.example.profileuser.Model;

public class Profile_User {
    int photo,ID;
    boolean sex;
    String nameuser,ngaysinh;

    public Profile_User(int photo) {
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
