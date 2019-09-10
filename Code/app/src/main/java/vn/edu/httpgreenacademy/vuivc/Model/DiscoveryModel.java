package vn.edu.httpgreenacademy.vuivc.Model;

import java.util.ArrayList;

public class DiscoveryModel {

    String Title, Hashtag;
    ArrayList<String> listImageUrl;
    ArrayList<String> listVideoUrl;

    public DiscoveryModel(String title, String hashtag, ArrayList<String> listImageUrl, ArrayList<String> listVideoUrl) {
        Title = title;
        Hashtag = hashtag;
        this.listImageUrl = listImageUrl;
        this.listVideoUrl = listVideoUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHashtag() {
        return Hashtag;
    }

    public void setHashtag(String hashtag) {
        Hashtag = hashtag;
    }

    public ArrayList<String> getListImageUrl() {
        return listImageUrl;
    }

    public void setListImageUrl(ArrayList<String> listImageUrl) {
        this.listImageUrl = listImageUrl;
    }

    public ArrayList<String> getListVideoUrl() {
        return listVideoUrl;
    }

    public void setListVideoUrl(ArrayList<String> listVideoUrl) {
        this.listVideoUrl = listVideoUrl;
    }
}
