public class QuizCustomization { //private variables that store the # of questions and the time limit for the app
    private int numQuestions; //stores # of questions
    private int timeLimit; //stores time limit

    public QuizCustomization(int numQuestions, int timeLimit) { //constructor initializing the following variables
        //theese values are set based on the arguments passed by the user upon running the app
        this.numQuestions = numQuestions;
        this.timeLimit = timeLimit;
    }
//'getter and setter' methods
    public int getNumQuestions() { //getter for 'numQuestions'
        return numQuestions; //returns the value for 'numQuestions'
    }

    public void setNumQuestions(int numQuestions) { //setter for 'numQuestions'
        this.numQuestions = numQuestions; //sets # of questions based on user input
    }

    public int getTimeLimit() { //getter for timelimit variable
        return timeLimit; //returns the time limit 
    }

    public void setTimeLimit(int timeLimit) { //setter for the timeLimit variable
        this.timeLimit = timeLimit; // sets the time limit based on user input
    }
}
