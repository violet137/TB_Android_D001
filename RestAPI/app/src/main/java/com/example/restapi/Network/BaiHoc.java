package com.example.restapi.Network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHoc {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NameTrans")
    @Expose
    private String nameTrans;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("ColorCode")
    @Expose
    private String colorCode;
    @SerializedName("LessionIndex")
    @Expose
    private Integer lessionIndex;
    @SerializedName("UserProcess")
    @Expose
    private Double userProcess;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTrans() {
        return nameTrans;
    }

    public void setNameTrans(String nameTrans) {
        this.nameTrans = nameTrans;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Integer getLessionIndex() {
        return lessionIndex;
    }

    public void setLessionIndex(Integer lessionIndex) {
        this.lessionIndex = lessionIndex;
    }

    public Double getUserProcess() {
        return userProcess;
    }

    public void setUserProcess(Double userProcess) {
        this.userProcess = userProcess;
    }
}
