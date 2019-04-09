package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

public class Hashtag_Model {
    String duongdanvideo;
    int duongdanhinh;

    public String getDuongdanvideo() {
        return duongdanvideo;
    }

    public void setDuongdanvideo(String duongdanvideo) {
        this.duongdanvideo = duongdanvideo;
    }

    public int getDuongdanhinh() {
        return duongdanhinh;
    }

    public void setDuongdanhinh(int duongdanhinh) {
        this.duongdanhinh = duongdanhinh;
    }

    public Hashtag_Model(String duongdanvideo, int duongdanhinh) {
        this.duongdanvideo = duongdanvideo;
        this.duongdanhinh = duongdanhinh;
    }
}
