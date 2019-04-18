package vn.edu.httpgreenacademy.vuivc;

public class VideoModel {
    String VideoName;
    String VideoUrl;
    VideoTypeEnum videoType;
    int NumberOfLike, NumberOfShare, NumberOfComment;

    public VideoModel(String videoName, String videoUrl, VideoTypeEnum videoType, int numberOfLike, int numberOfShare, int numberOfComment) {
        VideoName = videoName;
        VideoUrl = videoUrl;
        this.videoType = videoType;
        NumberOfLike = numberOfLike;
        NumberOfShare = numberOfShare;
        NumberOfComment = numberOfComment;
    }

    public String getVideoName() {
        return VideoName;
    }

    public void setVideoName(String videoName) {
        VideoName = videoName;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public VideoTypeEnum getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoTypeEnum videoType) {
        this.videoType = videoType;
    }

    public int getNumberOfLike() {
        return NumberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        NumberOfLike = numberOfLike;
    }

    public int getNumberOfShare() {
        return NumberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        NumberOfShare = numberOfShare;
    }

    public int getNumberOfComment() {
        return NumberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        NumberOfComment = numberOfComment;
    }
}
