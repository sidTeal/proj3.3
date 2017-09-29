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

public class SellPaintingFrame extends JFrame{
    JLabel sellLabel;
    static JComboBox paintingList;
    
    public SellPaintingFrame(ArrayList<Painting> paintings) {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Sell Painting");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        
        ArrayList<Painting> currentPaintings = paintings;
        String[] paintingTitles = new String[currentPaintings.size() + 1];
        paintingTitles[0] = "";

        for (int i = 0; i < currentPaintings.size(); i++) {
            paintingTitles[i + 1] = currentPaintings.get(i).getTitle();
        }

        sellLabel = new JLabel("   Sell: ");
        paintingList = new JComboBox(paintingTitles);       
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        paintingList.addActionListener(lForComboBox);


        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, paintingList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(300, 400);
        this.setResizable(true);
    }
    
    public class ComboBoxActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String item = paintingList.getSelectedItem().toString();
            for (int i = 0; i <= InventoryGUI.paintings.size(); i++) {
                if (InventoryGUI.paintings.get(i).getTitle() == item){
                    InventoryGUI.paintings.get(i).remove();
                    InventoryGUI.paintings.remove(i);
                    paintingList.setSelectedItem("");
                    
                    JFrame frame;
                    frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Painting sold.");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }   
            }            

        }
    }
}
