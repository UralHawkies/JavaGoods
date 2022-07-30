package ru.netology.domain;

public class Book extends Product {
    public String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(Product good, String search) {
        if (super.matches(good,search)) {
            return true;
        }
        return getAuthor().contains(search);
    }
}
