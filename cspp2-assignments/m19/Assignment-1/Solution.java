import java.util.Scanner;

/**
 * Solution class for code-eval.
 */

class Quiz {

	private String question;
	private String[] choices;
	private int correctanswer;
	private int maxmarks;
	private int penalty;
	private String userScoreAwarded;


    Quiz(String question, String[] choices,
     int correctanswer, int maxmarks, int penalty) {
     	this.question = question;
     	this.choices = choices;
     	this.correctanswer = correctanswer;
     	this.maxmarks = maxmarks;
     	this.penalty = penalty;
     	// this.userScoreAwarded = userScoreAwarded;

    }


    public String getQuestion() {
    	return this.question;
    }

    public String[] getChoices() {
    	return this.choices;
    }

    public int getCorrectanswer() {
    	return this.correctanswer;
    }

    public int getMaxmarks() {
    	return this.maxmarks;
    }

    public int getPenalty() {
    	return this.penalty;
    }

    public void setUserScore(final String score) {
    	this.userScoreAwarded = score;
    }

    public String getUserScore() {
    	return this.userScoreAwarded;
    }
}


public final class Solution {
     /**
     * Constructs the object.
     */

    private int userScore = 0;
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        // Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore();
                break;
                default:
                break;
            }
        }
    }

    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        //
        for (int i = 0; i < questionCount; i++) {
        	String[] questionInfo = s.nextLine().split(":");
        	Quiz quiz = new Quiz(questionInfo[0], questionInfo[1].split(","),
        			 Integer.parseInt(questionInfo[2]),
        			  Integer.parseInt(questionInfo[3]),
        			   Integer.parseInt(questionInfo[4]));
            }
            System.out.println(questionCount + "are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object

        for (int j = 0; j < answerCount; j++) {
        	for (Quiz que : quiz) {
        		System.out.println(que.getQuestion() + "(" + que.getMaxmarks() + ")");
        		System.out.println(que.getChoices().toString());
        	    String[] userchoice = s.nextLine().split(" ");
        	    int userchoicenum = Integer.parseInt(userchoice[1]);
        	    if (userchoicenum == que.getCorrectanswer()) {
        	    	userScore += que.getMaxmarks();
        	    	que.setUserScore(" Correct Answer! - Marks Awarded:" + que.getMaxmarks());

        	    } else {
        	    	userScore += que.getPenalty();
        	    	que.setUserScore(" Wrong Answer! - Penalty:" + que.getPenalty());

        	    }
        	}


        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore() {
        // write your code here to display the score report
        for (Quiz que : quiz) {
        	System.out.println(que.getQuestion());
        	System.out.println(que.getUserScore());
        }
        System.out.println("Total Score:" + userScore);
    }

}
