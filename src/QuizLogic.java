import java.util.ArrayList;

public class QuizLogic {
    // This method is used to submit an answer to the quiz.
    public void submitAnswer(Quiz quiz, int answer) {
        quiz.submitAnswer(answer);
    }

    // This method is used to check if the quiz has been finished.
    public boolean isFinished(Quiz quiz) {
        return quiz.isFinished();
    }
    // This method is used to load a quiz with a specified number of questions from a question database.
    public Quiz loadQuiz(QuizCustomization quizCustomization, QuestionDatabase questionDB) {
        // Get all questions from the database.
        ArrayList<Question> allQuestions = questionDB.getQuestions();
        // Determine the number of questions to include in the quiz based on the customization options.
        int numQuestions = quizCustomization.getNumQuestions();
        // If the requested number of questions is greater than the total number of available questions,
        // then limit the number of questions to the total number of available questions.
        if (numQuestions > allQuestions.size()) {
            numQuestions = allQuestions.size();
        }
         // Create an ArrayList to hold the selected questions for the quiz.
        ArrayList<Question> questions = new ArrayList<Question>();
        // Loop through the questions and add the requested number of questions to the quiz.
        for (int i = 0; i < numQuestions; i++) {
            questions.add(allQuestions.get(i));
        }
        // Create a new quiz with the selected questions.
        return new Quiz(questions);
    }
    
    
}
