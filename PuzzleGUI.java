import javax.swing.*;
import java.awt.*;

public class PuzzleGUI {

    private JFrame frame;
    private JTextArea foundWordsArea;
    private JLabel scoreLabel;
    private JLabel letterLabel;

    public PuzzleGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Spelling Beehive");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        letterLabel = new JLabel("Puzzle Letters: ");
        topPanel.add(letterLabel);

        scoreLabel = new JLabel("Score: 0");
        topPanel.add(scoreLabel);

        frame.add(topPanel, BorderLayout.NORTH);

        foundWordsArea = new JTextArea();
        foundWordsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(foundWordsArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center on screen
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public void setPuzzleLetters(String puzzleLetters) {
        letterLabel.setText("Puzzle Letters: " + puzzleLetters);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void appendFoundWord(String word) {
        foundWordsArea.append(word + "\n");
    }

    public String promptForWordGuess() {
        return JOptionPane.showInputDialog(frame, "Enter a word (at least 5 letters):").toUpperCase();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
