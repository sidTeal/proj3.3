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

public class SellBookFrame extends JFrame {

    JLabel sellLabel;
    static JComboBox bookList;

    //public SellBookFrame(ArrayList<Book> books) {
        public SellBookFrame() {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Sell Book");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        //ArrayList<Book> currentBooks = books;
        String[] bookTitles = new String[InventoryGUI.books.size()+1];
        bookTitles[0] = "";

        for (int i = 0; i < InventoryGUI.books.size(); i++) {
            bookTitles[i+1] = InventoryGUI.books.get(i).getTitle();
        }
        
        sellLabel = new JLabel("   Sell: ");
        
        bookList = new JComboBox(bookTitles);       
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        bookList.addActionListener(lForComboBox);


        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, bookList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(300, 400);
        this.setResizable(true);
    }
    
    public class ComboBoxActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String item = bookList.getSelectedItem().toString();
            for (int i = 0; i <= InventoryGUI.books.size(); i++) {
                if (InventoryGUI.books.get(i).getTitle() == item){
                    InventoryGUI.books.get(i).remove();
                    InventoryGUI.books.remove(i);
                    bookList.setSelectedItem("");
                    
                    JFrame frame;
                    frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Book sold.");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }   
            }            

        }
    }

}
