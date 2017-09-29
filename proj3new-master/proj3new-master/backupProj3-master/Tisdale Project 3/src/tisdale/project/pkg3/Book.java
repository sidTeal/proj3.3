/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.util.Date;

/**
 *
 * @author student
 */
public class Book extends StoreItem {

    private static int bookCount = 0;
    private String author;
    private String genre;

    Book(String title, Date dateAcquired, int purchasePrice, int askingPrice, String author, String genre) {
        super(title, dateAcquired, purchasePrice, askingPrice);
        setAuthor(author);
        setGenre(genre);
        bookCount++;
    }

    public static int getCount() {
        return bookCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.length() > 1) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author must be a string of at least two characters .");
        }
    }

    public void setGenre(String genre) {
        if (genre.length() > 1) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Genre must be a string of at least two characters .");
        }
        
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void remove() {
        bookCount--;
        super.remove();
    }

    public String printableString() {
        String bookInfo = "Title: " + this.getTitle() + "\nDate Acquired: "
                + this.getDateAcquired() + "\nPurchase Price: " + this.getPurchasePrice()
                + "\nAsking Price: " + this.getAskingPrice() + "\nAuthor: " + this.getAuthor()
                + "\nGenre: " + this.getGenre();

        return bookInfo;
    }
}
