import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections; // Correct import for List from java.util
import java.util.List; // Correct import for ArrayList from java.util
import javax.swing.*;

public class QuizGame {
    private JFrame frame;
    private JPanel panel;
    private JTextArea questionArea;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private int currentQuestion = 0;
    private int score = 0;
    private List<Question> questionBank = new ArrayList<>(); // List from java.util
    private List<Integer> questionOrder = new ArrayList<>(); // List from java.util

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizGame().createUI());
    }

    public void createUI() {
        // Prepare the questions
        questionBank.add(new Question("What is Java?", "Programming Language", "Car", "Fruit", "Animal", 0));
        questionBank.add(new Question("Who is the father of Java?", "James Gosling", "Dennis Ritchie",
                "Bjarne Stroustrup", "Linus Torvalds", 0));
        questionBank
                .add(new Question("What is the default value of a boolean variable?", "false", "true", "0", "null", 0));
        questionBank.add(
                new Question("Which company developed Java?", "Sun Microsystems", "Google", "Microsoft", "Apple", 0));
        questionBank.add(
                new Question("What is the size of an int in Java?", "4 bytes", "8 bytes", "2 bytes", "16 bytes", 0));
        questionBank.add(new Question("Which keyword is used to create an object in Java?", "new", "create", "object",
                "class", 0));
        questionBank.add(new Question("Which of these is used to define a constant in Java?", "final", "static",
                "const", "immutable", 0));
        questionBank
                .add(new Question("Which of these is not a primitive type?", "String", "int", "char", "boolean", 0));
        questionBank.add(new Question("What does JVM stand for?", "Java Virtual Machine", "Java Visual Machine",
                "Java Variable Machine", "Java Verified Machine", 0));
        questionBank.add(new Question("What is used to handle exceptions in Java?", "try-catch", "throw", "catch-try",
                "finally", 0));
        // Add at least 10 more questions to reach 20

        // Randomize question order
        questionOrder = new ArrayList<>();
        for (int i = 0; i < questionBank.size(); i++) {
            questionOrder.add(i);
        }
        Collections.shuffle(questionOrder);

        // Set up the frame
        frame = new JFrame("Java Quiz Game");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        panel.add(questionArea, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        panel.add(nextButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        // Display the first question
        showQuestion(currentQuestion);
    }

    public void showQuestion(int questionIndex) {
        Question question = questionBank.get(questionOrder.get(questionIndex));
        questionArea.setText(question.getQuestion());
        for (int i = 0; i < 4; i++) {
            options[i].setText(question.getOption(i));
            options[i].setSelected(false);
        }
    }

    public void checkAnswer() {
        Question question = questionBank.get(questionOrder.get(currentQuestion));
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == question.getCorrectOptionIndex()) {
                score++;
            }
        }
    }

    class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkAnswer();
            currentQuestion++;
            if (currentQuestion < 5) { // Show only 5 questions
                showQuestion(currentQuestion);
            } else {
                JOptionPane.showMessageDialog(frame, "Your final score is: " + score);
                System.exit(0);
            }
        }
    }

    class Question {
        private String question;
        private String[] options;
        private int correctOptionIndex;

        public Question(String question, String option1, String option2, String option3, String option4,
                int correctOptionIndex) {
            this.question = question;
            this.options = new String[] { option1, option2, option3, option4 };
            this.correctOptionIndex = correctOptionIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String getOption(int index) {
            return options[index];
        }

        public int getCorrectOptionIndex() {
            return correctOptionIndex;
        }
    }
}
