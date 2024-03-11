import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Project1 extends JFrame {

    private static final int MIN_WORD_LENGTH = 5;
    private String puzzleLetters;
    private ArrayList<String> solutions;
    private JTextArea foundWordsArea;
    private JLabel scoreLabel;

    public Project1(String fileName) throws FileNotFoundException {
        super("Spelling Beehive");
        this.solutions = new ArrayList<>();
        this.readInput(fileName);
        this.createGUI();
        this.scoreLabel.setText("Score: 0");
    }

    private void readInput(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        this.puzzleLetters = scanner.nextLine().toUpperCase();
        while (scanner.hasNextLine()) {
            solutions.add(scanner.nextLine().toUpperCase());
        }
        scanner.close();
    }

    private void createGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(1, 2));

        JLabel letterLabel = new JLabel("Puzzle Letters: " + puzzleLetters);
        foundWordsArea = new JTextArea();
        foundWordsArea.setEditable(false);
        scoreLabel = new JLabel();

        panel.add(letterLabel);
        panel.add(foundWordsArea);

        this.add(panel);
        this.setSize(400, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void playGame() {
        while (true) {
            String guess = JOptionPane.showInputDialog(this, "Enter a word (at least 5 letters):").toUpperCase();
            if (guess == null) {
                break;
            }

            if (!isValidWord(guess)) {
                continue;
            }

            if (solutions.contains(guess)) {
                foundWordsArea.append(guess + "\n");
                solutions.remove(guess);
                scoreLabel.setText("Score: " + foundWordsArea.getLineCount());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid guess!");
            }
        }
    }

    private boolean isValidWord(String guess) {
        if (guess.length() < MIN_WORD_LENGTH) {
            JOptionPane.showMessageDialog(this, "Word must be at least 5 letters long!");
            return false;
        }
        for (char letter : guess.toCharArray()) {
            if (!puzzleLetters.contains(String.valueOf(letter))) {
                JOptionPane.showMessageDialog(this, "Word contains invalid letters!");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Project1 <input_file>");
            System.exit(1);
        }
        try {
            Project1 game = new Project1(args[0]);
            game.playGame();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found!");
            e.printStackTrace();
        }
    }
}