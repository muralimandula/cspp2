import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;




/**
 * Exception for signaling loading question errors.
 */
class LoadingQuestionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    LoadingQuestionException(final String s) {
        super(s);
    }
}


/**
 * Solution class for code-eval.
 */
class Quiz {

    /**
     * Questioin in String format.
     */
    private String question;

    /**
     * Choices as String array.
     */
    private String[] choices;

    /**
     * Correct answer for question as int, 1st, 2nd, 3rd or 4th.
     */
    private int correctanswer;

    /**
     * maximum marks allotted for that question.
     */
    private int maxmarks;

    /**
     * penalty for question.
     */
    private int penalty;

    /**
     * useScore.
     */
    private String userScoreAwarded;

    /**
     * Constructs the object.
     */
    Quiz() {

    }

    /**
     * Constructs the object.
     *
     * @param      que         The que
     * @param      choice      The choice
     * @param      correctans  The correctans
     * @param      maxmark     The maxmark
     * @param      penlty      The penlty
     */
    Quiz(final String que, final  String[] choice,
     final int correctans, final int maxmark, final int penlty) {
        this.question = que;
        this.choices = choice;
        this.correctanswer = correctans;
        this.maxmarks = maxmark;
        this.penalty = penlty;
    }

    /**
     * Gets the question.
     *
     * @return     The question.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Gets the choices.
     *
     * @return     The choices.
     */
    public String[] getChoices() {
        return this.choices;
    }

    /**
     * Gets the correctanswer.
     *
     * @return     The correctanswer.
     */
    public int getCorrectanswer() {
        return this.correctanswer;
    }

    /**
     * Gets the maxmarks.
     *
     * @return     The maxmarks.
     */
    public int getMaxmarks() {
        return this.maxmarks;
    }

    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }

    /**
     * Sets the user score.
     *
     * @param      score  The score
     */
    public void setUserScore(final String score) {
        this.userScoreAwarded = score;
    }

    /**
     * Gets the user score.
     *
     * @return     The user score.
     */
    public String getUserScore() {
        return this.userScoreAwarded;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return question + " " + Arrays.toString(choices)
         + " " + correctanswer + " " + maxmarks + " " + penalty;

    }
}

/**
 * Class for quiz time.
 */
class QuizTime {

    /**
     * { var_description }.
     */
    private static ArrayList<Quiz> quizquestions;

    /**
     * Constructs the object.
     */
    QuizTime() {
        quizquestions = new ArrayList<>();

    }

    /**
     * Adds a question information.
     *
     * @param      quizpassedtoadd  The quizpassed to add
     */
    public void addQuestionInfo(final Quiz quizpassedtoadd) {
        quizquestions.add(quizpassedtoadd);
    }

    /**
     * Gets the questions.
     *
     * @return     The questions.
     */
    public ArrayList<Quiz> getQuestions() {
        return quizquestions;
    }


}

/**
 * Solution class.
 */
public final class Solution {

    /**
     * quize size, increamented for each question.
     */
    private static int quizsize = 0;

    /**
     * ELiminate magic number 5.
     */
    static final int FIVE = 5;

    /**
     * ELiminate magic number 4.
     */
    static final int FOUR = 4;

    /**
     * ELiminate magic number 3.
     */
    static final int THREE = 3;



    /**
     * userScore, calculates penalty and score.
     */
    private static int userScore = 0;

    /**
     * Constructs the object.
     */
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
        QuizTime q = new QuizTime();
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
                try{
                	loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch(LoadingQuestionException e) {
                	System.out.println(e.getMessage());
                }
                break;


                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;


                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
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
     * @param      q           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
                        final QuizTime q, final int questionCount)
                        				 throws LoadingQuestionException {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            for (int i = 0; i < questionCount; i++) {

                String[] questionInfo = s.nextLine().split(":");

                if (questionInfo.length != FIVE || questionInfo[0].equals("")) {
                    throw new LoadingQuestionException("Error! Malformed question");

                } else  if (questionInfo[1].split(",").length < 2) {
                    throw new LoadingQuestionException(questionInfo[0]
                     + " does not have enough answer choices");

                } else if (Integer.parseInt(questionInfo[2]) > FOUR) {
                    throw new LoadingQuestionException("Error! Correct answer"
                     + " choice number is out of range for question text 1");
                } else if (Integer.parseInt(questionInfo[THREE]) < 1) {
                    throw new LoadingQuestionException("Invalid max marks for "
                                                 + questionInfo[0]);

                } else if (Integer.parseInt(questionInfo[FOUR]) > 0) {
                    throw new LoadingQuestionException("Invalid penalty for "
                                                     + questionInfo[0]);

                } else {
                    // try {
                    q.addQuestionInfo(new Quiz(questionInfo[0],
                                 questionInfo[1].split(","),
                         Integer.parseInt(questionInfo[2]),
                          Integer.parseInt(questionInfo[THREE]),
                           Integer.parseInt(questionInfo[FOUR])));
                    quizsize++;
                    // } catch (IndexOutOfBoundsException e) {
                    // System.out.println("Error! Malformed question");
                    // break;
                 // }
                }
            }
            }
            if (quizsize != 0) {
            System.out.println(questionCount + " are added to the quiz");
            }
        }





    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
                         final QuizTime quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object


      for (Quiz que : quiz.getQuestions()) {

        System.out.println(que.getQuestion() + "(" + que.getMaxmarks() + ")");

        if (que.getChoices().length == FOUR) {
        System.out.println(que.getChoices()[0] + "\t" + que.getChoices()[1]
        + "\t" + que.getChoices()[2] + "\t" + que.getChoices()[THREE] + "\n");
        } else if (que.getChoices().length == 2) {
            System.out.println(que.getChoices()[0]
                             + "\t" + que.getChoices()[1] + "\n");
        }


        String userchoice = s.nextLine();

        if (userchoice.equals(que.getChoices()[que.getCorrectanswer() - 1])) {
            userScore += que.getMaxmarks();
            que.setUserScore(" Correct Answer! - Marks Awarded: "
                                                     + que.getMaxmarks());
        } else {
            userScore += que.getPenalty();
            que.setUserScore(" Wrong Answer! - Penalty: " + que.getPenalty());

                }
            }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final QuizTime quiz) {
        // write your code here to display the score report
        if (quizsize != 0) {
            for (Quiz que : quiz.getQuestions()) {
                System.out.println(que.getQuestion());
                System.out.println(que.getUserScore());
            }
            System.out.println("Total Score: " + userScore);
        }
    }
}


