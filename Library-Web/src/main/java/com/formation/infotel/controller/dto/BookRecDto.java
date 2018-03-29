package com.formation.infotel.controller.dto;

public class BookRecDto {

    private int bookRecId;
    private String bookTitle;
    private String imagePath;

    public BookRecDto() {
    }

    public BookRecDto(int bookRecId, String bookTitle, String imagePath) {
        this.bookRecId = bookRecId;
        this.bookTitle = bookTitle;
        this.imagePath = imagePath;
    }

    public int getBookRecId() {
        return bookRecId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
