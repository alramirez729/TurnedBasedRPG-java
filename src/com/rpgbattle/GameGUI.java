package com.rpgbattle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class GameGUI extends JFrame {

    private final JTextArea textArea;

    public GameGUI() {
        super("RPG FIGHT GAME");
        setSize(1280, 720); //resolution of popout Window

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent the default close operation


        // Add a window listener to handle window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmClose();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK); //sets the color of the popout "terminal" to black
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Set custom font here
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.SOUTH);
        getContentPane().add(scrollPane);

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);

        setVisible(true);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public static int getUserInputAsInt(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        if (input != null && !input.isEmpty()) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Handle invalid input here (e.g., display an error message)
                e.printStackTrace();
            }
        } else {
            confirmClose(); // Display the confirmation dialog when the user cancels
        }
        return 0; // Default value if user cancels or enters invalid input
    }

    private static void confirmClose() {
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to close the game?\nAll progress will be lost.",
                "Confirm Close", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the program
        }
    }

    public static class CustomOutputStream extends OutputStream {
        private final JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        public void write(int b) throws IOException {
            // Redirect output from System.out to the text area
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
            try {
                // delay in milliseconds
                long delay = 25;
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
