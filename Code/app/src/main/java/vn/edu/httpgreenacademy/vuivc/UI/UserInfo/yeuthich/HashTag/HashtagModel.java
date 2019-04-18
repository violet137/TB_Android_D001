package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

public class HashtagModel {
    int duongdanvideo;
    int duongdanhinh;

    public int getDuongdanvideo() {
        return duongdanvideo;
    }

    public void setDuongdanvideo(int duongdanvideo) {
        this.duongdanvideo = duongdanvideo;
    }

    public int getDuongdanhinh() {
        return duongdanhinh;
    }

    public void setDuongdanhinh(int duongdanhinh) {
        this.duongdanhinh = duongdanhinh;
    }

    public HashtagModel(int duongdanvideo, int duongdanhinh) {
        this.duongdanvideo = duongdanvideo;
        this.duongdanhinh = duongdanhinh;
    }
}
