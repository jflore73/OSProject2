import java.util.*;
public class ProjectDriver {
	private static Scanner keyboard=new Scanner(System.in);

	public static void main(String[] args) {
		int input;
		System.out.print("Enter an integer: ");
		input=verify();
		System.out.println(input);
		Algorithms.fcfsAlgorithm();

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
