package com.itsol.service;

import com.itsol.model.Book;
import com.itsol.model.Book_Management;
import com.itsol.model.Reader;
import com.itsol.model.Type_Book;

import java.util.Scanner;

public class Book_Service {

     int countReader;

     int countBook;

     Reader[] readers;

     Book[] books;

     Book_Management[] book_managements;

     String major;

    public void createNewReader(){
        System.out.println("Nhập số lượng bạn đọc muốn thêm: ");
        countReader = new Scanner(System.in).nextInt();
        readers = new Reader[countReader];
        for (int i = 0; i < readers.length; i++) {
            Reader reader = new Reader();
            System.out.println("Nhập thông tin bạn đọc thứ " + (i + 1));
            reader.nhapTT();
            readers[i] = reader;
        }
    }

    public void displayReader(){
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].toString());
        }
    }

    public void createNewBook(){
        System.out.println("Nhập số lượng sách muốn thêm: ");
        countBook = new Scanner(System.in).nextInt();
        books = new Book[countBook];
        for (int i = 0; i < books.length; i++) {
            Book book = new Book();
            System.out.println("Nhập thông tin sách thứ " + (i + 1));
            book.nhapTT();
            books[i] = book;
        }
    }

    public void displayBook(){
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    public void borrowBook(){
        book_managements = new Book_Management[countReader];

        for (int i = 0; i < readers.length; i++) {

            int bookNumber;
            Book[] bookList;

            do {
                System.out.println("Nhập số lượng đầu sách mà bạn " + readers[i].getName() + " mượn: ");
                bookNumber = new Scanner(System.in).nextInt();
                bookList = new Book[bookNumber];
            }while (bookNumber <= 0 || bookNumber > 5);

            int totalMajor = 0;
            int totalBook = 0;

            for (int j = 0; j < bookNumber; j++) {
                System.out.println("Nhập đầu sách thứ " + (j + 1) + " mà bạn " + readers[i].getName() + " mượn: ");
                int choose = new Scanner(System.in).nextInt();

                switch (choose){
                    case 1:
                        major = Type_Book.NATURAL_SCIENCE.getTypeBook();
                        break;
                    case 2:
                        major = Type_Book.ART_LITERATURE.getTypeBook();
                        break;
                    case 3:
                        major = Type_Book.ELECTRONIC_TELECOMMUNICATION.getTypeBook();
                        break;
                    case 4:
                        major = Type_Book.INFORMATION_TECHNOLOGY.getTypeBook();
                        break;
                }

                Book book = searchBook(major);
                int m = 0;

                if (book != null){
                    do {
                        System.out.println("Nhập số lượng sách của đầu sách thứ " + (j + 1) + " mà bạn " + readers[i].getName() + " mượn: ");
                        m = new Scanner(System.in).nextInt();
                    }while (m <= 0 || m > 3);
                }

                bookList[j] = book;
                totalMajor = bookNumber;
                totalBook += m;
            }

            Book_Management book_management = new Book_Management(readers[i], bookList, totalMajor, totalBook);
            book_managements[i] = book_management;
        }

        for (int i = 0; i < book_managements.length; i++) {
            System.out.println(book_managements[i].toString());
        }
    }

    public void sortBorrowListByReaderName(){
        for (int i = 0; i < book_managements.length - 1; i++) {
            for (int j = i + 1; j < book_managements.length; j++) {
                if (book_managements[i].getReader().getName().compareTo(book_managements[j].getReader().getName()) > 0){
                    Book_Management temp = book_managements[i];
                    book_managements[i] = book_managements[j];
                    book_managements[j] = temp;
                }
            }
        }

        for (int i = 0; i < book_managements.length; i++) {
            System.out.println(book_managements[i].getReader());
        }
    }

    public void sortBorrowListByBookAmount(){
        for (int i = 0; i < book_managements.length; i++) {
            for (int j = i + 1; j < book_managements.length; j++) {
                if (book_managements[i].getTotalBook() < book_managements[j].getTotalBook()) {
                    Book_Management temp = book_managements[i];
                    book_managements[i] = book_managements[j];
                    book_managements[j] = temp;
                }
            }
        }

        for (int i = 0; i < book_managements.length; i++) {
            System.out.println(book_managements[i].toString());
        }
    }

    public void searchAndDisplayPerson(){
        System.out.println("Nhập tên bạn đọc muốn tìm kiếm: ");
        String name = new Scanner(System.in).nextLine();

        for (int i = 0; i < book_managements.length; i++) {
            if (book_managements[i].getReader().getName().equals(name)){
                System.out.println(book_managements[i].toString());
            }
        }
    }

    public Book searchBook(String chuyenNganh){
        for (int i = 0; i < books.length; i++) {
            if (books[i].getMajor().equals(chuyenNganh)){
                return books[i];
            }
        }
        return null;
    }
}
