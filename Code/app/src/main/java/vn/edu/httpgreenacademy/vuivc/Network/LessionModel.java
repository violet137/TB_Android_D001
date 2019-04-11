package vn.edu.httpgreenacademy.vuivc.Network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LessionModel {
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Data")
    @Expose
    private String data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
