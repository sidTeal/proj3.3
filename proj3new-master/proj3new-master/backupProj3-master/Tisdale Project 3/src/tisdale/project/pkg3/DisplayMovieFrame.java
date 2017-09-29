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

public class DisplayMovieFrame extends JFrame{
    JLabel displayLabel;
    static JComboBox movieList;
    JTextArea displayTextArea;
    
    public DisplayMovieFrame(ArrayList<Movie> movies) {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Display Movie");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        ArrayList<Movie> currentMovies = movies;
        String[] movieTitles = new String[currentMovies.size()+1];
        movieTitles[0] = "";

        for (int i = 0; i < currentMovies.size(); i++) {
            movieTitles[i+1] = currentMovies.get(i).getTitle();
        }
        
        displayLabel = new JLabel("   Display: ");
        movieList = new JComboBox(movieTitles);
        
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        movieList.addActionListener(lForComboBox);
        
        displayTextArea = new JTextArea(10, 40);
        displayTextArea.setLineWrap(true);
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(displayTextArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 
        GUIBuilder.addComponent(mainPanel, displayLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, movieList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
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
            String item = movieList.getSelectedItem().toString();
            for (Movie movie : InventoryGUI.movies) {
                if (movie.getTitle() == item) {
                    displayTextArea.setText(movie.printableString());
                }
            }

        }
    }
}
