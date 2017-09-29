/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author student
 */
public class InventoryGUI extends JFrame {

    String[] items = {"", "Book", "Movie", "Painting"};
    JLabel addLabel, sellLabel, displayLabel;
    static JComboBox addItemList, sellItemList, displayItemList;

    static ArrayList<Book> books;
    static ArrayList<Movie> movies;
    static  ArrayList<Painting> paintings;
            
    public InventoryGUI(ArrayList<Book> initBooks, ArrayList<Movie> initMovies, ArrayList<Painting> initPaintings) {
        books = initBooks;
        movies = initMovies;
        paintings = initPaintings;

        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Inventory");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());

//        String[] bookTitles = new String[books.size()];
//        for (int i = 0; i < books.size(); i++) {
//            bookTitles[i] = books.get(i).getTitle();
//        }
//        String[] movieTitles = new String[movies.size()];
//        for (int i = 0; i < movies.size(); i++) {
//            movieTitles[i] = movies.get(i).getTitle();
//        }
//        String[] paintingTitles = new String[paintings.size()];
//        for (int i = 0; i < paintings.size(); i++) {
//            paintingTitles[i] = paintings.get(i).getTitle();
//        }
        addLabel = new JLabel("   Add Inventory: ");
        sellLabel = new JLabel("   Sell Inventory: ");
        displayLabel = new JLabel("   Display Inventory: ");
        addItemList = new JComboBox(items);
        sellItemList = new JComboBox(items);
        displayItemList = new JComboBox(items);

        GUIComboBoxActionHandler lForComboBox = new GUIComboBoxActionHandler();
        addItemList.addActionListener(lForComboBox);
        sellItemList.addActionListener(lForComboBox);
        displayItemList.addActionListener(lForComboBox);

        GUIBuilder.addComponent(mainPanel, addLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, displayLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, addItemList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, sellItemList, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, displayItemList, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(250, 400);
        this.setResizable(true);
    }

//    private void addComponent(JPanel panel, JComponent comp, int xPos, int yPos,
//            int compWidth, int compHeight, int place, int stretch) {
//        GridBagConstraints gridConstraints = new GridBagConstraints();
//        gridConstraints.gridx = xPos;
//        gridConstraints.gridy = yPos;
//        gridConstraints.gridwidth = compWidth;
//        gridConstraints.gridheight = compHeight;
//        gridConstraints.weightx = 100;
//        gridConstraints.weighty = 100;
//        gridConstraints.insets = new Insets(5, 5, 5, 5);
//        gridConstraints.anchor = place;
//        gridConstraints.fill = stretch;
//
//        panel.add(comp, gridConstraints);
//    }

//    private class ListenForComboBox implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == addItemList) {
//                //System.out.println("What item u wana add?");
//
//                String item = (String) addItemList.getSelectedItem();
//
//                switch (item) {
//                    case "Book":
//                        AddBookFrame addBookFrame = new AddBookFrame();
//                        System.out.println("adding book");
//                        addItemList.setSelectedItem("");
//                        break;
//                    case "Movie":
//                        System.out.println("adding movie");
//                        addItemList.setSelectedItem("");
//                        break;
//                    case "Painting":
//                        System.out.println("adding painting");
//                        addItemList.setSelectedItem("");
//                        break;
//                    default:
//                        System.out.println("nothing to add");
//                        break;
//                }
//            } else if (e.getSource() == sellItemList) {
//                //System.out.println("What item u wana add?");
//
//                String item = (String) sellItemList.getSelectedItem();
//
//                switch (item) {
//                    case "Book":
//                        System.out.println("selling book");
//                        sellItemList.setSelectedItem("");
//                        break;
//                    case "Movie":
//                        System.out.println("selling movie");
//                        sellItemList.setSelectedItem("");
//                        break;
//                    case "Painting":
//                        System.out.println("selling painting");
//                        sellItemList.setSelectedItem("");
//                        break;
//                    default:
//                        System.out.println("nothing to sell");
//                        break;
//                }
//            } else if (e.getSource() == displayItemList) {
//
//                String item = (String) displayItemList.getSelectedItem();
//
//                switch (item) {
//                    case "Book":
//                        System.out.println("displaying book");
//                        displayItemList.setSelectedItem("");
//                        break;
//                    case "Movie":
//                        System.out.println("displaying movie");
//                        displayItemList.setSelectedItem("");
//                        break;
//                    case "Painting":
//                        System.out.println("displaying painting");
//                        displayItemList.setSelectedItem("");
//                        break;
//                    default:
//                        System.out.println("nothing to display");
//                        break;
//                }
//            }
//        }
//
//    }

}
