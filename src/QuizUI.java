import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizUI extends JFrame {
     // instance variables
    private Quiz quiz;                   // stores the Quiz object
    private JPanel questionPanel;        // panel for displaying the question
    private JButton submitButton;        // button for submitting answers
    private ButtonGroup answerGroup;     // group for the radio buttons representing answer choices
    private JLabel questionLabel;        // label for displaying the question text
    private JRadioButton[] answerButtons;// array of radio buttons representing answer choices



    /**
     * Constructor for QuizUI class that takes a Quiz object
     *  Quiz object for the UI to display
     */
    public QuizUI(Quiz quiz) {
        this.quiz = quiz;
        initComponents(); // initialize components and display first question
        displayNextQuestion();
    }

     /**
      Method to initialize UI components
     */
    private void initComponents() {
        setTitle("SAT-tire, get ready!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create separate panels for the question and answers sections
        questionPanel = new JPanel(new BorderLayout());
        JPanel answersPanel = new JPanel(new GridLayout(2, 2));

        // Set the preferred size for questionPanel and answersPanel
        questionPanel.setPreferredSize(new Dimension(600, 100));
        answersPanel.setPreferredSize(new Dimension(600, 200));

        add(questionPanel, BorderLayout.NORTH);
        add(answersPanel, BorderLayout.CENTER);
        
        // Create and add a submit button to the bottom of the UI
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedAnswer = getSelectedAnswerIndex();
                quiz.submitAnswer(selectedAnswer);
                displayNextQuestion();
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        // Create a label for the question and add it to the questionPanel
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Create radio buttons for each answer choice and add them to the answersPanel
        answerButtons = new JRadioButton[4];
        answerGroup = new ButtonGroup();
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JRadioButton();
            answerGroup.add(answerButtons[i]);
            answersPanel.add(answerButtons[i]);
        }

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Method to display the next question in the quiz
     */     
    public void displayNextQuestion() {
        // Check if the quiz is finished
        if (quiz.isFinished()) {
            // If so, display the final score and exit the program
            int score = quiz.getScore();
            int totalQuestions = quiz.getNumQuestions();
            double percentage = ((double) score / (double) totalQuestions) * 100;
            JOptionPane.showMessageDialog(this, "Quiz Completed! You have answered " + score + " out of " + totalQuestions + ". Your score: " + percentage + "%");
            System.exit(0);
        } else {
            // Otherwise, display the current question and answer choices
            Question question = quiz.getCurrentQuestion();
            System.out.println("Displaying questions: " + question.getQuestionText());
            questionLabel.setText(question.getQuestionText());
            String[] choices = question.getAnswerChoices();
            for (int i = 0; i < choices.length; i++) {
                answerButtons[i].setText(choices[i]);
            }
        }
    }

    /**
     * Helper method to get the index of the selected answer choice
     * return Index of the selected answer choice, or -1 if no answer choice is selected
     */
    private int getSelectedAnswerIndex() {
        for (int i = 0; i < answerButtons.length; i++) {
            if (answerButtons[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }
}
