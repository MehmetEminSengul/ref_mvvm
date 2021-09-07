package com.example.ref_mvvm.model.login.responseModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("IsOK")
    @Expose
    private Boolean isOk;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("Value")
    @Expose
    private Boolean value;
    @SerializedName("TotalPage")
    @Expose
    private Integer totalPage;
    @SerializedName("TotalValue")
    @Expose
    private Integer totalValue;

    public Boolean getOk() {
        return isOk;
    }

    public Boolean getValue() {
        return value;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}