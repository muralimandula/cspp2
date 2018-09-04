import java.util.Scanner;
/**
 * Class for student.
 */
final class Student {
	/**
	* Creating array of marks.
	*/
	private float[] marks;
	/**
	 * Creating name of the student.
	 */
	private String sname;
	/**
	 * Creating id of the student.
	 */
	private String id;
	/**
	 * Constructing the object Student and its attributes.
	 *
	 * @param      studentname  The student name.
	 * @param      identity     The identity.
	 * @param      score     The score.
	 */
	Student(final String studentname, final String identity, final float[] score) {
	    this.sname = studentname;
	    this.id = identity;
	    this.marks = score;  
	}
	/**
	 * Calculates the gpa.
	 * @return     The gpa in float.
	 */
	public float calculateGpa() {
	    float sum = 0;
	    final int three = 3;
	    for (int i = 0; i < three; i++) {
	        sum += marks[i];
	    }
	    float gpa = sum / three;
	    return gpa;
	}

	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
	    Scanner s = new Scanner(System.in);
	    String sname = s.nextLine();
	    String id = s.nextLine();
	    final int three = 3;
	    float[] marks = new float[three];  //an array of marks, of type float.
	    for (int i = 0; i < three; i++) {
	        marks[i] = s.nextFloat();
	    }
	    Student studentObj = new Student(sname, id, marks);  // creating an object studentObj in the class "Student".
	                                                         // with attributes, sname, id, marks.
	    System.out.println("ID\t" + id + " \n" + "Name\t" + sname + 
	    	"\n" + "GPA\t" + studentObj.calculateGpa());
    }
}
