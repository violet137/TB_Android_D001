package vn.edu.httpgreenacademy.vuivc.Draw;

public class PickModel {
    int duongdanhinh;
    String tenhinh;

    public String getTenhinh() {
        return tenhinh;
    }

    public void setTenhinh(String tenhinh) {
        this.tenhinh = tenhinh;
    }

    public PickModel(int duongdanhinh, String tenhinh) {
        this.duongdanhinh = duongdanhinh;
        this.tenhinh = tenhinh;
    }

    public int getDuongdanhinh() {
        return duongdanhinh;
    }

    public void setDuongdanhinh(int duongdanhinh) {
        this.duongdanhinh = duongdanhinh;
    }
}
