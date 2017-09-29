package tisdale.project.pkg3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class TisdaleProject3 {

    /**
     * add, sell, and display inventory
     */
    public static void main(String[] args) {

        
        ArrayList<Book> initBooks = new ArrayList<>();
        ArrayList<Movie> initMovies = new ArrayList<>();
        ArrayList<Painting> initPaintings = new ArrayList<>();
        
        initBooks.add(new Book("The Hobbit", new Date(116, 3, 11), 3, 7, "Tolkien", "Fantasy"));
        
        String actors[] = {"Schwarzenegger", "Biehn"};
        String actresses[] = {"Hamilton", "Motta"};
        initMovies.add(new Movie("The Terminator", new Date(115, 9, 22), 4, 8, "Cameron", actors, actresses));

        initPaintings.add(new Painting("Mountainscape", new Date(116, 4, 5), 33, 66, 24, 12, "Ross", "oil"));

        InventoryGUI GUI = new InventoryGUI(initBooks, initMovies, initPaintings);
        
        
//        GUI.getContentPane().setBackground(Color.white);
//        GUI.setTitle("Inventory");
//        GUI.setVisible(true);
//        GUI.setDefaultCloseOperation(EXIT_ON_CLOSE);

        /*
        System.out.println("Item count: " + StoreItem.getCount());
        System.out.println("Book count: " + Book.getCount());
        System.out.println("Movie count: " + Movie.getCount());
        System.out.println("Painter count: " + Painting.getCount());
        System.out.println((books.get(0)).printableString());
        System.out.println((movies.get(0)).printableString());
        System.out.println((paintings.get(0)).printableString());
        books.get(0).remove();
        books.remove(0);
        System.out.println("Item count: " + StoreItem.getCount());
        System.out.println("Book count: " + Book.getCount());
         */
    }
    
}
