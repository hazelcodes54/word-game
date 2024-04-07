import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project1 extends JFrame {

    private static final int MIN_WORD_LENGTH = 5;
    private String puzzleLetters;
    private UnsortedWordList solutions;
    private SortedWordList guessedWords;
    private JTextArea foundWordsArea;
    private JLabel scoreLabel;
    private int score = 0;

    public Project1(String fileName) throws FileNotFoundException {
        super("Spelling Beehive");
        solutions = new UnsortedWordList();
        guessedWords = new SortedWordList();
        readInput(fileName);
        createGUI();
        scoreLabel.setText("Score: 0");
    }

    private void readInput(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        puzzleLetters = scanner.nextLine().toUpperCase();
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().toUpperCase();
            solutions.add(new Word(word)); // Assume Word is your class wrapping string.
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
                break; // Exit the loop if cancel is clicked
            }

            if (!isValidWord(guess)) {
                continue; // Skip the rest of the loop and ask for another guess.
            }

            if (solutions.contains(new Word(guess))) {
                solutions.remove(new Word(guess)); // Remove from solutions list.
                guessedWords.add(new Word(guess)); // Add to guessed words list.
                
                int points = guess.containsAllLetters(puzzleLetters) ? 3 : 1; // Custom method to check if all letters are contained.
                score += points;
                
                scoreLabel.setText("Score: " + score);
                updateFoundWordsArea();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid guess or word already guessed!");
            }
        }
    }

    private void updateFoundWordsArea() {
        foundWordsArea.setText(""); 
        for (Word word : guessedWords) { 
            foundWordsArea.append(word.getWord() + "\n"); // Display guessed words.
        }
    }

    private boolean isValidWord(String guess) {
        if (guess.length() < MIN_WORD_LENGTH) {
            JOptionPane.showMessageDialog(this, "Word must be at least 5 letters long!");
            return false;
        }
        if (!guess.startsWith(String.valueOf(puzzleLetters.charAt(0)))) {
            JOptionPane.showMessageDialog(this, "Word must start with the specified letter!");
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
