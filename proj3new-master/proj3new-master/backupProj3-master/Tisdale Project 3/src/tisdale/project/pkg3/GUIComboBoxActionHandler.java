/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class GUIComboBoxActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == InventoryGUI.addItemList) {

            String item = (String) InventoryGUI.addItemList.getSelectedItem();

            switch (item) {
                case "Book":
                    AddBookFrame addBookFrame = new AddBookFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                case "Movie":
                    AddMovieFrame addMovieFrame = new AddMovieFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                case "Painting":
                    AddPaintingFrame addPaintingFrame = new AddPaintingFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                default:
                    break;
            }
        } else if (e.getSource() == InventoryGUI.sellItemList) {

            String item = (String) InventoryGUI.sellItemList.getSelectedItem();

            switch (item) {
                case "Book":
                    //SellBookFrame sellBookFrame = new SellBookFrame(InventoryGUI.books);
                    if (Book.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Books to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellBookFrame sellBookFrame = new SellBookFrame();
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                    break;
                case "Movie":
                    if (Movie.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Movies to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellMovieFrame sellMovieFrame = new SellMovieFrame(InventoryGUI.movies);
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                    break;
                case "Painting":
                    if (Painting.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Paintings to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellPaintingFrame sellPaintingFrame = new SellPaintingFrame(InventoryGUI.paintings);
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                default:
                    break;
            }
        } else if (e.getSource() == InventoryGUI.displayItemList) {

            String item = (String) InventoryGUI.displayItemList.getSelectedItem();

            switch (item) {
                case "Book":
                    if (Book.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Books to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayBookFrame displayBookFrame = new DisplayBookFrame(InventoryGUI.books);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                case "Movie":
                    if (Movie.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Movies to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayMovieFrame displayMovieFrame = new DisplayMovieFrame(InventoryGUI.movies);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                case "Painting":
                    if (Painting.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Paintings to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayPaintingFrame displayPaintingFrame = new DisplayPaintingFrame(InventoryGUI.paintings);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
