package com.itsol.model;

public class Book_Management{

    private Reader reader;

    private Book[] book;

    private int totalMajor;

    private int totalBook;

    public Book_Management(){

    }

    public Book_Management(Reader reader, Book[] book, int totalMajor, int totalBook) {
        this.reader = reader;
        this.book = book;
        this.totalMajor = totalMajor;
        this.totalBook = totalBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getMajorBook() {
            String majorBook = "";
            for (int i = 0; i < book.length - 1; i++) {
                majorBook += book[i].getMajor() + ", ";
            }
            majorBook += book[book.length - 1].getMajor();
            return majorBook;

    }

    public int getTotalMajor() {
        return totalMajor;
    }

    public void setTotalMajor(int totalMajor) {
        this.totalMajor = totalMajor;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    @Override
    public String toString() {
        return "Book_Management{" +
                "reader=" + reader +
                ", book=" + "Book{chuyenNganh='" + getMajorBook() + "'" +
                ", quantity=" + totalMajor +
                ", totalBook=" + totalBook +
                '}';
    }
}
