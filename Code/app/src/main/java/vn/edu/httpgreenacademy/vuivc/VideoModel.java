package vn.edu.httpgreenacademy.vuivc;

public class VideoModel {
    String VideoName;
    String VideoUrl;
    VideoTypeEnum videoType;

    public VideoModel(String videoName, String videoUrl, VideoTypeEnum videoType) {
        VideoName = videoName;
        VideoUrl = videoUrl;
        this.videoType = videoType;
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
}
