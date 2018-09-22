import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


/**
  * write your code below this comment
  */

class Task {

	public String title;
	public String assignedTo;
	public int timeToComplete;
	public boolean important;
	public boolean urgent;
	public String status;

	Task(final String tasktitle, final String taskassignedTo,
	 final int tasktimeToComplete, final boolean taskimportant,
	  final boolean taskurgent, final String taskstatus) throws Exception {

		if (tasktitle.equals("")) {
			throw new Exception("Title not provided");

		} else if (tasktimeToComplete < 0) {
			throw new Exception("Invalid timeToComplete " + tasktimeToComplete);

		} else if (!(taskstatus.equals("todo") || taskstatus.equals("done"))) {
			throw new Exception("Invalid status " + taskstatus);

		} else {
		this.title = tasktitle;
		this.assignedTo = taskassignedTo;
		this.timeToComplete = tasktimeToComplete;
		this.important = taskimportant;
		this.urgent = taskurgent;
		this.status = taskstatus;
		}
	}

	public String getTitle() {
		return this.title;
	}

	public String getAssigniedTo() {
		return this.assignedTo;
	}

	public int getTimeToComplete() {
		return this.timeToComplete;
	}

	public String getImportant() {
		if (this.important == true) {
			return "Important";
		} else {
			return "Not Important";
		}
	}

	public String getUrgent() {
		if (this.urgent == true) {
			return "Urgent";
		} else {
			return "Not Urgent";
		}
	}

	public String getStatus() {
		return this.status;
	}

	public String toString() {
		return this.getTitle() + ", " + this.getAssigniedTo() + ", " +
		 this.getTimeToComplete() + ", " + this.getImportant() + ", " +
		  this.getUrgent() + ", " + this.getStatus();
	}

}

class Todoist {
	public ArrayList<Task> todoarray;


	Todoist() {
		todoarray = new ArrayList<Task>();
	}

	public void addTask(Task passedtask) {
		todoarray.add(passedtask);
	}

	// public String toString(Task t) {
	// 	// for(Task t : todoarray) { //Each Task
	// 		return t.getTitle() + " " + t.getAssigniedTo() +
	// 		 " " + t.getTimeToComplete() + " " + t.getImportant() +
	// 			 " " + t.getUrgent() + " " + t.getStatus();
	// 	// }
	// }

	public void printAll( ) {
		for(Task t : todoarray) { //Each Task
			System.out.println(t.getTitle() + ", " + t.getAssigniedTo() +
			 ", " + t.getTimeToComplete() + ", " + t.getImportant() +
				 ", " + t.getUrgent() + ", " + t.getStatus());
		}
	}

	public Task getNextTask(final String username) {
		for (Task t : todoarray) {
			if ((t.getAssigniedTo().equals(username)) && (t.getStatus().equals("todo"))) {
				if(t.getImportant().equals("Important")) { // && (t.getUrgent().equals("Not Urgent"))) {
					return t;
				}
			}
		}
		return null;
	}

	public Task[] getNextTask(final String username, final int noOfTasks) {

		Task[] temptodo = new Task[noOfTasks];
		 // ArrayList<Task> temptodo = new ArrayList<Task>();
		 int taskCount = 0;

        while(taskCount < noOfTasks) {
			for(Task eachTask : todoarray) {
				String tempuser = eachTask.getAssigniedTo();
				if (getNextTask(tempuser) != null) {
				// temptodo.add(eachTask);
				temptodo[taskCount] = eachTask;

				taskCount++;
				}
			}
		}

		return temptodo;
	}


	public int totalTime4Completion() {

		int total = 0;

		for(Task eachTask : todoarray) {
			if(eachTask.getStatus().equals("todo")) {
				total += eachTask.getTimeToComplete();
			}
		}

		return total;
	}

}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    // System.out.println(todo);
                	todo.printAll();
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
