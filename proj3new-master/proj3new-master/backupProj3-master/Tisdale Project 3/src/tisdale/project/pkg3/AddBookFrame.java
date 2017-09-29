/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author student
 */
public class AddBookFrame extends JFrame {

    JLabel titleLabel, dateAcquiredLabel, purchasePriceLabel, askingPriceLabel, authorLabel, genreLabel;
    JTextField titleTextField, purchasePriceTextField, askingPriceTextField, authorTextField, genreTextField;
    JSpinner dateAcquiredSpin;
    JButton addButton;

    public AddBookFrame() {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Add Book");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());

        Date todaysDate = new Date(); // get todays date

        titleLabel = new JLabel("   Title: ");
        dateAcquiredLabel = new JLabel("   Date Acquired: ");
        purchasePriceLabel = new JLabel("   Purchase Price: ");
        askingPriceLabel = new JLabel("   Asking Price: ");
        authorLabel = new JLabel("   Author: ");
        genreLabel = new JLabel("   Genre: ");

        titleTextField = new JTextField(10);
        dateAcquiredSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateAcquiredSpin, "dd/MM/yy"); // set date editor format
        dateAcquiredSpin.setEditor(dateEditor); // set editor to chosen format
        purchasePriceTextField = new JTextField(10);
        askingPriceTextField = new JTextField(10);
        authorTextField = new JTextField(10);
        genreTextField = new JTextField(10);

        addButton = new JButton("Add");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Book book = new Book(titleTextField.getText(), (Date)dateAcquiredSpin.getValue(),
                            Integer.parseInt(purchasePriceTextField.getText()), Integer.parseInt(askingPriceTextField.getText()),
                            authorTextField.getText(), genreTextField.getText());
                    InventoryGUI.books.add(book);

                    JFrame frame;
                    frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Book added.");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nMissing or invalid entry.\nPlease correct this problem and try again.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nPlease correct this problem and try again.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        GUIBuilder.addComponent(mainPanel, titleLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, dateAcquiredLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, purchasePriceLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, askingPriceLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, authorLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, genreLabel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        GUIBuilder.addComponent(mainPanel, titleTextField, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, dateAcquiredSpin, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, purchasePriceTextField, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, askingPriceTextField, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, authorTextField, 1, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, genreTextField, 1, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        GUIBuilder.addComponent(mainPanel, addButton, 1, 6, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(350, 400);
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
}
