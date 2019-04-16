package vn.edu.httpgreenacademy.vuivc.ModelUser;




public class ProfileUser {
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
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
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
