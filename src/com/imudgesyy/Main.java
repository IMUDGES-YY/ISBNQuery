package com.imudgesyy;


import com.imudgesyy.ISBNQuery.ISBNQuery;
import com.imudgesyy.bean.Book;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ISBNQuery isbnQuery = new ISBNQuery();
        Book book = isbnQuery.ISBNQuery("9787101003048");
        System.err.println(book.getAuthor().get(0));
        System.err.println(book.getTitle());
        System.err.println(book.getPages());
        System.err.println(book.getBinding());
        System.err.println(book.getImages());
        System.err.println(book.getISBN());
        System.err.println(book.getPrice());
        System.err.println(book.getPubdate());
        System.err.println(book.getPublisher());
    }
}
