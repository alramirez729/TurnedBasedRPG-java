package com.rpgbattle;

import java.awt. *;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.io.*;

public class GameGUI extends JFrame {

    private JTextArea textArea;
    private JTextField inputField;

    public GameGUI() {
        super("RPG FIGHT GAME");
        setSize(600, 400); //resolution of popout Window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK); //sets the color of the popout "terminal" to black
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        inputField = new JTextField();
        inputField.setBounds(20, 450, 450, 30);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                // Use the user input in the game
            }
        });
        add(inputField);

        panel.add(scrollPane, BorderLayout.SOUTH);
        getContentPane().add(scrollPane);

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);

        setVisible(true);
    }

    public JTextArea getTextArea(){
        return textArea;
    }

    public static void main(String[] args) {
        GameGUI window = new GameGUI();

        // Run your RPG code here
        System.out.println("\t\tHello Player! \n \t Welcome, to RPGFightGame! ");
    }

    public static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;
        private long delay = 30; // delay in milliseconds

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        public void write(int b) throws IOException {
            // Redirect output from System.out to the text area
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());

            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
