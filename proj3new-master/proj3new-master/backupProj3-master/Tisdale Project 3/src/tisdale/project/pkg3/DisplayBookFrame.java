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

public class DisplayBookFrame extends JFrame {

    JLabel displayLabel;
    static JComboBox bookList;
    JTextArea displayTextArea;

    public DisplayBookFrame(ArrayList<Book> books) {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Display Book");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        ArrayList<Book> currentBooks = books;
        String[] bookTitles = new String[currentBooks.size() + 1];
        bookTitles[0] = "";

        for (int i = 0; i < currentBooks.size(); i++) {
            bookTitles[i + 1] = currentBooks.get(i).getTitle();
        }

        displayLabel = new JLabel("   Display: ");       
        
        bookList = new JComboBox(bookTitles);
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        bookList.addActionListener(lForComboBox);
        
        
        displayTextArea = new JTextArea(10, 40);
        displayTextArea.setLineWrap(true);
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(displayTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        GUIBuilder.addComponent(mainPanel, displayLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, bookList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, scrollBar, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(550, 400);
        this.setResizable(true);
    }

    public class ComboBoxActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            displayTextArea.setText("");
            String item = bookList.getSelectedItem().toString();
            for (Book book : InventoryGUI.books) {
                if (book.getTitle() == item) {
                    displayTextArea.setText(book.printableString());
                }
            }

        }
    }
}
