import java.util.*;
public class ProjectDriver {
	private static Scanner keyboard=new Scanner(System.in);
	
	public static void main(String[] args) {
		int input;
		do {
			input=display();
			switch(input) {
			case 1: 
				Algorithms.fcfsAlgorithm();
				break;
			case 2: 
				Algorithms.sjfAlgorithm();
				break;
			case 3:
				Algorithms.priorityAlgorithm();
				break;
			case 4:
				Algorithms.roundRobinAlgorithm();
				break;
			case 5:
				Algorithms.priorityAlgorithm2();
				break;
			case 6:
				Algorithms.roundRobinAlgorithm2();
				break;
			case 7:
				System.out.println();
				break;
			case 8:
				System.out.println();
				break;
			case 9:
				System.out.println();
				break;
			case 10:
				break;
			default:
				System.out.println("Invalid input. Try again.");
				break;
			}
			System.out.println();
		}while(input!=10);
		System.exit(0);
	}
	private static int display() {
		System.out.println("------------------MAIN MENU------------------");
		System.out.println("1. First Come First Serve Algorithm");
		System.out.println("2. Shortest Job First Algorithm");
		System.out.println("3. Priority Schedule Algorithm");
		System.out.println("4. Round Robin Algorithm");
		System.out.println("5. Priority Schedule Algorithm Two");
		System.out.println("6. Undefined");
		System.out.println("7. Undefined");
		System.out.println("8. Undefined");
		System.out.println("9. Undefined");
		System.out.println("10. Exit Program");
		System.out.println();
		System.out.print("Enter option number: ");
		return verify();
	}
	
	private static int verify(){
		int number=-1;
		boolean isValid = false;
		do {
			try {
				number=keyboard.nextInt();
				keyboard.nextLine();
				isValid=true;
			}
			catch(InputMismatchException e) {
				System.out.print("Invalid Input. Please enter an integer: ");
				keyboard.nextLine();
			}
		}while(!isValid);
		return number;
	}

}
