import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {
        // create a new QuestionDatabase object by passing in the file name
        QuestionDatabase questionDB = new QuestionDatabase("data/questions.txt");

        // get the list of questions from the QuestionDatabase object
        ArrayList<Question> questions = questionDB.getQuestions();

        // create the dialog for quiz customization
        JDialog quizCustomizationDialog = new JDialog();
        quizCustomizationDialog.setLayout(new GridLayout(3, 2)); // set layout to grid with 3 rows and 2 columns
        JLabel numQuestionsLabel = new JLabel("Number of questions:"); // create label for number of questions field
        JTextField numQuestionsField = new JTextField(); // create text field for number of questions
        JLabel timeLimitLabel = new JLabel("Time limit (minutes):"); // create label for time limit field
        JTextField timeLimitField = new JTextField(); // create text field for time limit


       // create the submit button and listener
        JButton submitButton = new JButton("Submit"); // create submit button with label "Submit"
        submitButton.addActionListener(new ActionListener() { // add action listener to button to listen for click events
            public void actionPerformed(ActionEvent e) { // perform this method when button is clicked
                int numQuestions = Integer.parseInt(numQuestionsField.getText()); // get number of questions from input field
                int timeLimit = Integer.parseInt(timeLimitField.getText()); // get time limit from input field
                QuizCustomization quizCustomization = new QuizCustomization(numQuestions, timeLimit); // create new QuizCustomization object with user inputs

                // create a new QuizLogic object
                QuizLogic quizLogic = new QuizLogic();

                // create and start the quiz
                Quiz quiz = quizLogic.loadQuiz(quizCustomization, questionDB);

                quizCustomizationDialog.dispose(); // close the dialog after user inputs are collected

                QuizUI quizUI = new QuizUI(quiz); // create a new QuizUI object with the quiz
                quizUI.displayNextQuestion(); // display the first question in the quiz
                quizUI.setVisible(true); // make the quiz UI visible
                System.out.println("Quiz started"); // debug line to indicate quiz has started
            }
        });

        // add components to the dialog
        quizCustomizationDialog.add(numQuestionsLabel); // add the number of questions label to the dialog
        quizCustomizationDialog.add(numQuestionsField); // add the number of questions text field to the dialog
        quizCustomizationDialog.add(timeLimitLabel); // add the time limit label to the dialog
        quizCustomizationDialog.add(timeLimitField); // add the time limit text field to the dialog
        quizCustomizationDialog.add(submitButton); // add the submit button to the dialog

        // set dialog properties
        quizCustomizationDialog.setTitle("Quiz Customization"); // set the title of the dialog
        quizCustomizationDialog.setModal(true); // set the dialog as modal
        quizCustomizationDialog.setSize(300, 150); // set the size of the dialog
        quizCustomizationDialog.setResizable(false); // disable resizing of the dialog
        quizCustomizationDialog.setLocationRelativeTo(null); // set the location of the dialog to the center of the screen
        quizCustomizationDialog.setVisible(true); // make the dialog visible
    }
}
