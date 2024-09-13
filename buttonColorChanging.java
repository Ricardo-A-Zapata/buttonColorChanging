/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author ricardozapata
 */
public class buttonColorChanging {
    
/**
 * @param args the command line arguments
 */

private static int numberOfButtons = 8;    // Here is a variable that can be changed for ease of scalability
private static JButton[] buttons = new JButton[numberOfButtons];

// Making a function to generate a random color for button initalization and after button press
private static Color randomColor(){
    Random randomDecider = new Random();
    Color randomColor = new Color(randomDecider.nextInt(256), randomDecider.nextInt(256),
    randomDecider.nextInt(256));
    return randomColor;
}

public static void main(String[] args) {

    JFrame jf = new JFrame("Button Color Changing Application"); // Making window for buttons
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500,500);

    JPanel background = new JPanel();

    background.setLayout(new GridLayout(numberOfButtons/2,2, 25, 25)); // Setting layout of buttons

    // Making a shared action listener for all buttons so all buttons know when one is pressed
    ButtonActionListener actionListener = new ButtonActionListener();

    for (int i = 0; i < numberOfButtons; i++) {
        JButton button = new JButton(Integer.toString(i + 1));
        button.addActionListener(actionListener);
        button.setOpaque(true);
        buttons[i] = button;
        button.setBackground(randomColor());
        background.add(button);
    }

    jf.add(background);
    jf.setVisible(true);
}

static class ButtonActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();
        for(JButton button :  buttons){
            if(button != clicked){
                button.setBackground(randomColor());
            }
        }
    }
}

}



