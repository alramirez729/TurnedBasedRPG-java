import javax.swing.*;

public class TextRPGGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text RPG Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // print welcome message with ASCII art
        // print welcome message with ASCII art
        // no ASCII ART
        JTextArea textArea = new JTextArea();

        textArea.append("Welcome to Text Battle!\n\n");

        JOptionPane.showMessageDialog(frame, textArea, "Text RPG Game", JOptionPane.PLAIN_MESSAGE);

        String input = "";
        while (!input.equals("exit")) {
            input = JOptionPane.showInputDialog(frame, "Enter a command:");
        }

        frame.dispose();
    }
}
