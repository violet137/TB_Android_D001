package vn.edu.httpgreenacademy.vuivc.Model;

public class NotificationModel {

    String Title, Content;
    String ImageUrl;

    public NotificationModel(String title, String content, String imageUrl) {
        Title = title;
        Content = content;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
