import java.util.InputMismatchException;
import java.util.Scanner;
public class Algorithms {
	private static Scanner keyboard=new Scanner(System.in);
	
	public static void fcfsAlgorithm(){
		int np;
		System.out.println("First Come First Served Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		int np2=np*2;
		double[] bp= new double[np];//Burst Time
		double[] wtp = new double[np];//Wait Time
		String[] output1 = new String[np2];
		double twt = 0.0, awt; //Total Wait Time, Average Wait Time
		int num;
		for(int i=0; i<np;i++) {
			System.out.print("Enter Burst time for Process "+i+": ");
			bp[i]=verify();
		}
		for(int i=0; i<np;i++) {
			if(i==0)
				wtp[i]=0;
			else {
				wtp[i]=wtp[i-1]+bp[i-1];
			}
			System.out.println("Waiting time for Process "+i+": "+wtp[i]);
		}
		for(int i=0; i<np;i++) {
			twt+=(double)wtp[i];
		}
		System.out.println("Total Wait Time: "+twt);
		awt=twt/(double)np;
		System.out.println("Average Wait Time: "+awt);
	}
	
	public static void sjfAlgorithm() {
		int np;
		System.out.println("Shortest Job First Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		int np2=np*2;
		double[] bp= new double[np];//Burst Time
		double[] wtp = new double[np];//Wait Time
		double[] p= new double[np];//Process Order
		double twt = 0.0, awt; //Total Wait Time, Average Wait Time
		double temp=0.0;
		boolean found=false;
		for(int i=0; i<np;i++) {
			System.out.print("Enter Burst time for Process "+i+": ");
			bp[i]=verify();
		}
		for(int i=0; i<np;i++) {
			p[i]=bp[i];
		}
		//Sort by shortest
		for(int i=0; i<np-1;i++) {
			for(int j=0; j<np-1;j++) {
				if(p[j]>p[j+1]){
					temp=p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
				}
			}
		}
	    for (int i=0;i<np;i++){//num
	    	if (i== 0){
	    		for(int j=0; j<np; j++){//x
	    			if (p[i]==bp[j]&&found==false){
	    				wtp[i]=0;
	                    System.out.println("Waiting time for Process "+j+ ": "+ wtp[i]);
	                    bp[j]=0;
	                    found=true;
	                }
	            }
	            found = false;
	        }
	        else{
	        	for (int j = 0; j<np; j++){ //x
	                if (p[i]==bp[j]&&found==false){
	                	wtp[i] = wtp[i-1]+p[i-1];
	                	System.out.println("Waiting time for Process " +j+ ": " + wtp[i]);
	                	bp[j]=0;
	                    found=true;
	                }
	            }
	            found = false;
	        }
	    }
	    for(int i=0; i<np;i++){
			twt+=(double)wtp[i];
		}
		System.out.println("Total Wait Time: "+twt);
		awt=twt/(double)np;
		System.out.println("Average Wait Time: "+awt);
	}
	
	private static int verify(){
		int input=-10;
		boolean isValid=false;
		do {
			try {
				input=keyboard.nextInt();
				keyboard.nextLine();
				
				isValid=true;
			}
			catch(InputMismatchException e) {
				System.out.print("Invalid input. Please type an integer: ");
				keyboard.nextLine();
			}
		}while(!isValid); //loop until is valid
		return input;
	}
}
