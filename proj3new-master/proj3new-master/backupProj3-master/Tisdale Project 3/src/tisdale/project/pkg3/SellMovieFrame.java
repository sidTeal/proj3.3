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

public class SellMovieFrame extends JFrame {

    JLabel sellLabel;
    static JComboBox movieList;


    public SellMovieFrame(ArrayList<Movie> movies) {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Sell Movie");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        ArrayList<Movie> currentMovies = movies;
        String[] movieTitles = new String[currentMovies.size() + 1];
        movieTitles[0] = "";

        for (int i = 0; i < currentMovies.size(); i++) {
            movieTitles[i + 1] = currentMovies.get(i).getTitle();
        }

        sellLabel = new JLabel("   Sell: ");
        movieList = new JComboBox(movieTitles);   
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        movieList.addActionListener(lForComboBox);

        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, movieList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(300, 400);
        this.setResizable(true);
    }
    
    public class ComboBoxActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String item = movieList.getSelectedItem().toString();
            for (int i = 0; i <= InventoryGUI.movies.size(); i++) {
                if (InventoryGUI.movies.get(i).getTitle() == item){
                    InventoryGUI.movies.get(i).remove();
                    InventoryGUI.movies.remove(i);
                    movieList.setSelectedItem("");
                    
                    JFrame frame;
                    frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Movie sold.");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }   
            }            

        }
    }
}
