package vn.edu.httpgreenacademy.vuivc.Fragment.Comment;

public class UserModel {

    String userName;
    String userComment;
    int userAvatar;

    public UserModel(String userName, String userComment, int userAvatar) {
        this.userName = userName;
        this.userComment = userComment;
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }
}
