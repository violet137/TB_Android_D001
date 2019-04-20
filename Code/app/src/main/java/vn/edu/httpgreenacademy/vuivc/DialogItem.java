package vn.edu.httpgreenacademy.vuivc;

public class DialogItem {
    String namePng;
    String nameTxt;

    public DialogItem(String namePng, String nameTxt) {
        this.namePng = namePng;
        this.nameTxt = nameTxt;
    }

    public String getNamePng() {
        return namePng;
    }

    public void setNamePng(String namePng) {
        this.namePng = namePng;
    }

    public String getNameTxt() {
        return nameTxt;
    }

    public void setNameTxt(String nameTxt) {
        this.nameTxt = nameTxt;
    }
}
