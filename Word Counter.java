

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JLabel countLabel;
    
    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        // Add listener to count as you type
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                countWords();
            }
        });
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        // Counter display
        countLabel = new JLabel("Words: 0 | Characters: 0", JLabel.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(countLabel, BorderLayout.SOUTH);
    }
    
    private void countWords() {
        String text = textArea.getText().trim();
        
        int charCount = text.length();
        int wordCount = 0;
        
        if(!text.isEmpty()) {
            String[] words = text.split("\\s+");
            wordCount = words.length;
        }
        
        countLabel.setText("Words: " + wordCount + " | Characters: " + charCount);
    }
    
    public static void main(String[] args) {
        new WordCounter().setVisible(true);
    }


}
