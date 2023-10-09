package com.trabalhoapigrupo05.trabalhoapi.swagger.infrastructure.entities;

public class Base64FileRequest {

    private String imageUrl;
    private String fileName;

    // Getters e setters

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
