import java.util.ArrayList;

public class Quiz {
    // instance variables
    private ArrayList<Question> questions; // The list of questions in the quiz
    private int currentQuestionIndex; // The index of the current question being asked
    private int score; // The number of questions answered correctly so far
    private int numQuestions; // The total number of questions in the quiz
    
    // constructor
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions; // Initialize the list of questions
        this.currentQuestionIndex = 0; // Start at the first question
        this.score = 0; // No questions answered correctly yet
        this.numQuestions = questions.size(); // Set the total number of questions
    }
    

    // Get the current question being asked
    public Question getQuestion() {
        return questions.get(currentQuestionIndex);
    }
    

    // Submit an answer to the current question
    public void submitAnswer(int answer) {
        // If the answer is correct, increment the score
        if (answer == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
        // Move on to the next question, regardless of whether the answer was correct or not
        currentQuestionIndex++;
    }



    // Check if the quiz has finished
    public boolean isFinished() {
        return currentQuestionIndex >= questions.size();
    }

    // Get the total number of questions in the quiz
    public int getNumQuestions() {
        return numQuestions;
    }

    // Move on to the next question
    public void nextQuestion(){
        currentQuestionIndex++;
    }

    // Get the current question being asked
    public Question getCurrentQuestion(){
        return questions.get(currentQuestionIndex);
    }
    
    // Get the current score
    public int getScore() {
        return score;
    }
    
    
}
