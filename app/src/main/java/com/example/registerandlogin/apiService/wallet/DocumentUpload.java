package com.example.registerandlogin.apiService.wallet;

import java.io.Serializable;

import okhttp3.MultipartBody;

public class DocumentUpload implements Serializable {
    private MultipartBody.Part file;
    private Long ownerid;
    private String userFileName;

    public DocumentUpload(MultipartBody.Part file, Long ownerid) {
        this.file = file;
        this.ownerid = ownerid;
    }

    public MultipartBody.Part getFile() {
        return file;
    }

    public void setFile(MultipartBody.Part file) {
        this.file = file;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }
}
