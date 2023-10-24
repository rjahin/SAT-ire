//import statements 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*The QuestionDatabase class reads the questions.txt file to create a database of questions for the quiz.
The class has a constructor that takes the text file as a parameter. The file is parsed and the lines are 
split into 3 parts: the question text, the answer choices, and the index of the correct answer. The single
method getQuesstions() returns an ArrayList of Question objects.*/
public class QuestionDatabase {
    // instance variable
    private ArrayList<Question> questions;
    
    // constructor
    public QuestionDatabase(String fileName) {
        questions = new ArrayList<Question>(); //creates collection of questions 
        
        try {
            File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) { //parsing file line by line
            String line = scanner.nextLine();
            String[] parts = line.split(","); //detects question txt by finding first comma in the line
            
            String questionText = parts[0]; 
            String[] answerChoices = parts[1].split(";"); //detetcts answer choices by finding semicolons
            int correctAnswerIndex = Integer.parseInt(parts[2]); //detects correct answer index at end of line 
            
            Question question = new Question(questionText, answerChoices, correctAnswerIndex); //parts of question object 
            questions.add(question); //add parts to collection 
            }
            
            scanner.close();
        } catch (FileNotFoundException e) { //error exception 
            System.out.println("File not found: " + fileName);
        }
    }
    
    
    // methods
    public ArrayList<Question> getQuestions() { //returns ArrayList of questions to be used in the quiz
        // return the collection of questions
        return questions;
    }
}
