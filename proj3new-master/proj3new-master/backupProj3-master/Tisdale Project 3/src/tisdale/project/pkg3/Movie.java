/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author student
 */
public class Movie extends StoreItem{
    private static int movieCount = 0;
    private String director;
    private String[] actors;
    private String[] actresses;
    
    Movie(String title, Date dateAcquired, int purchasePrice, int askingPrice, 
            String director, String[] actors, String[] actresses) {       
        super(title, dateAcquired, purchasePrice, askingPrice);
        setDirector(director);
        setActors(actors);
        setActresses(actresses);
        movieCount++;
    }
    
    public static int getCount() {
        return movieCount;
    }
    
    public void setDirector(String director) {
        if (director.length() > 1) {
            this.director = director;
        } else {
            throw new IllegalArgumentException("Author must be a string of at least two characters .");
        }
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setActors(String[] actors) {
        this.actors = actors;
    }
    
    public String[] getActors() {
        return actors;
    }
    
    public void setActresses(String[] actresses) {
        this.actresses = actresses;
    }
    
    public String[] getActresses() {
        return actresses;
    }
    
    @Override
    public void remove() {
        movieCount--;
        super.remove();
    }
    
    public String printableString(){
        String movieInfo = "Title: " + this.getTitle() + "\nDate Acquired: " + this.getDateAcquired() + 
                "\nPurchase Price: " + this.getPurchasePrice() + "\nAsking Price: " + this.getAskingPrice() + 
                "\nDirector: " + this.getDirector() + "\nActors: " + Arrays.toString(this.getActors()) + 
                "\nActresses: " + Arrays.toString(this.getActresses());
        
        return movieInfo;
    }
}
