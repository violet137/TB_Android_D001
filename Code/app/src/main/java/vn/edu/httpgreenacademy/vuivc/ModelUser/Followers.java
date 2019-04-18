package vn.edu.httpgreenacademy.vuivc.ModelUser;

public class Followers {
    int ID,img;
    String ten;

    public Followers(int ID, int img, String ten) {
        this.ID = ID;
        this.img = img;
        this.ten = ten;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
