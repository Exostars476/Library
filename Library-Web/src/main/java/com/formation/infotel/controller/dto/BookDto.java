package com.formation.infotel.controller.dto;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookDto {

    private int bookId;
    private String bookTitle;
    private String description;
    private float price;
    private List<Integer> authorsId;
    private int categoryId;
    private int editorId;
    private String pubDate;
    private boolean popular;
    private String imagePath;

    public BookDto() {
    }

    public BookDto(int bookId, String bookTitle, String description, float price, List<Integer> authorsId, int categoryId, int editorId, Date pubDate, boolean popular, String imagePath) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.description = description;
        this.price = price;
        this.authorsId = authorsId;
        this.categoryId = categoryId;
        this.editorId = editorId;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.pubDate = formatter.format(pubDate);
        this.popular = popular;
        this.imagePath = imagePath;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Integer> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(List<Integer> authorsId) {
        this.authorsId = authorsId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public boolean getPopular() {/*  getPopular permet a la parti json de detecté l'ajout*/
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
