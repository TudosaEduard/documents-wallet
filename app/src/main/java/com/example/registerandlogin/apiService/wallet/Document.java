package com.example.registerandlogin.apiService.wallet;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Document {
    private Long id;
    private String data;
    private Long owner;
    private String name;
    private String type;
    private String userFileName;

    private final Base64.Decoder decoder = Base64.getDecoder();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] decodeFile() {
        return decoder.decode(this.data);
    }

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
