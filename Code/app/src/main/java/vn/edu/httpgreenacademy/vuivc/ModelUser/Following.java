package vn.edu.httpgreenacademy.vuivc.ModelUser;

public class Following {
    int ID,image;
    String ten;

    public Following(int ID, int image, String ten) {
        this.ID = ID;
        this.image = image;
        this.ten = ten;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
