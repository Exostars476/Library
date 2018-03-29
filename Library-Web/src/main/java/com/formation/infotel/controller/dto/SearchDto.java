package com.formation.infotel.controller.dto;

public class SearchDto {

    private String bookTitle;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
