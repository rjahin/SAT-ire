
public class Question { //class named question - representing a multiple choice question in the app
    //properties of the question
    private String questionText;  //the text
    private String[] answerChoices; //the choices of answers in an array
    private int correctAnswerIndex; //this is the index of the correct answer located in the array


 //constructor for the question class 
    public Question(String questionText, String[] answerChoices, int correctAnswerIndex) { //sets the properties of the question
        this.questionText = questionText;  
        this.answerChoices = answerChoices; 
        this.correctAnswerIndex = correctAnswerIndex;
    }
//'getter and setter' methods
    public String getQuestionText() { //gets the text and returns the text as a string
        return questionText;
    }
  

    public void setQuestionText(String questionText) { //sets the text and sets the text in a new value
        this.questionText = questionText;
    }

    public String[] getAnswerChoices() { //returns an array of strings that are the answerchoices 
        return answerChoices;
    }

    public void setAnswerChoices(String[] answerChoices) { //sets answer choices to a new array of strings
        this.answerChoices = answerChoices;
    }

    public int getCorrectAnswerIndex() { //returns an int of the index for the correct answer in 'answerChoices' array
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) { //sets the index for the correct answer to a new value
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
