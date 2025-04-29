import java.util.InputMismatchException;
import java.util.Scanner;
public class Algorithms {
	private static Scanner keyboard=new Scanner(System.in);
	
	public static void fcfsAlgorithm(){
		int np;
		System.out.println("First Come First Served Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		double[] bp= new double[np];//Burst Time
		double[] wtp = new double[np];//Wait Time
		double twt = 0.0, awt; //Total Wait Time, Average Wait Time
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
	
    public static void priorityAlgorithm(){
    	int np;
		System.out.println("Priority Schedule Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		double[] bp = new double[np];
		double[] wtp = new double[np + 1];
		int[] p = new int[np];
		int[] sp = new int[np];
		int x, num;
		double twt = 0.0;
		double awt;
		int temp = 0;
		boolean found = false;
		for(int i=0; i<np;i++) {
			System.out.print("Enter Burst time for Process "+i+": ");
			bp[i]=verify();
		}
		for(int i=0; i<np;i++) {
			System.out.print("Enter Priority for Process "+i+": ");
			p[i]=verify();
		}
		for(num = 0; num <= np - 1; num++){
			sp[num] = p[num];
		}
		for(x = 0; x <= np - 2; x++){
			for (num = 0; num <= np - 2; num++){
				if (sp[num] > sp[num + 1]){
					temp = sp[num];
					sp[num] = sp[num + 1];
					sp[num + 1] = temp;
				}
			}
		}
		for(num = 0; num <= np - 1; num++){
			if (num == 0){
				for (x = 0; x <= np - 1; x++){
					if (sp[num] == p[x] && found == false){
						wtp[num] = 0;
						System.out.println("Waiting time for Process " + (x + 1) + " = " + wtp[num]);
						temp = x;
						p[x] = 0;
						found = true;
					}
				}
				found = false;
			}
			else{
				for (x = 0; x <= np - 1; x++){
					if (sp[num] == p[x] && found == false){
						wtp[num] = wtp[num - 1] + bp[temp];
						System.out.println("Waiting time for Process " + (x + 1) + " = " + wtp[num]);
						temp = x;
						p[x] = 0;
						found = true;
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
    
    public static void priorityAlgorithm2(){
    	int np;
		System.out.println("Priority Schedule Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		double[] bp = new double[np]; //Burst Time
		double[] wtp = new double[np + 1]; //Wait time process
		int[] p = new int[np]; //Priority evaluation
		int[] sp = new int[np]; //Sort priority
		double twt = 0.0; //Total Wait Time
		double awt; //Average Wait Time
		int temp = 0; //Temporal
		boolean found = false;
		for(int i=0; i<np;i++) {
			System.out.print("Enter Burst time for Process "+(i+1)+": ");
			bp[i]=verify();
			System.out.print("Enter Priority for Process "+(i+1)+": ");
			p[i]=verify();
		}
		for(int i= 0; i < np; i++){
			sp[i] = p[i];
		}
		for(int i=0; i < np - 1; i++){
			for (int j = 0; j < np - 1; j++){
				if (sp[j] > sp[j + 1]){
					temp = sp[j];
					sp[j] = sp[j + 1];
					sp[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < np; i++){
			if (i == 0){
				for (int j = 0; j < np; j++){
					if (sp[i] == p[j] && found == false){
						wtp[i] = 0;
						System.out.println("Waiting time for Process " + (j + 1) + " = " + wtp[i]);
						temp = j;
						p[j] = 0;
						found = true;
					}
				}
				found = false;
			}
			else{
				for (int j = 0; j < np; j++){//x
					if (sp[i] == p[j] && found == false){
						wtp[i] = wtp[i - 1] + bp[temp];
						System.out.println("Waiting time for Process " + (j + 1) + " = " + wtp[i]);
						temp = j;
						p[j] = 0;
						found = true;
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
    
    public static void roundRobinAlgorithm(){
    	int np;
		System.out.println("Round Robin Algorithm");
		System.out.print("Enter number of processes: ");
		np=verify();
		int i, counter = 0;
		double total = 0.0;
		double timeQuantum;
		double waitTime = 0, turnaroundTime = 0;
		double averageWaitTime, averageTurnaroundTime;
		double[] arrivalTime = new double[10];
		double[] burstTime = new double[10];
		double[] temp = new double[10];
		int x = np;
		for (i = 0; i < np; i++){
			System.out.print("Enter Arrival time for Process "+(i+1)+": ");
			arrivalTime[i] = verify();
			System.out.print("Enter Burst time for Process "+(i+1)+": ");
			burstTime[i] = verify();
			temp[i] = burstTime[i];
		}
		System.out.print("Enter Time Quantum: ");
		timeQuantum= verify();
		for (total = 0, i = 0; x != 0;){
			if (temp[i] <= timeQuantum && temp[i] > 0){
				total = total + temp[i];
				temp[i] = 0;
				counter = 1;
			}
			else if (temp[i] > 0){
				temp[i] = temp[i] - timeQuantum;
				total = total + timeQuantum;
			}
			if (temp[i] == 0 && counter == 1){
				x--;
				System.out.println("Turnaround time for Process " + (i + 1) + " : " + (total - arrivalTime[i]));
				System.out.println("Wait time for Process " + (i + 1) + " : " + (total - arrivalTime[i] - burstTime[i]));
				turnaroundTime = (turnaroundTime + total - arrivalTime[i]);
				waitTime = (waitTime + total - arrivalTime[i] - burstTime[i]);
				counter = 0;
			}
			if (i == np - 1){
				i = 0;
			}
			else if (arrivalTime[i + 1] <= total){
				i++;
			}
			else{
				i = 0;
			}
		}
		averageWaitTime = (int)(waitTime * 1.0 / np);
		averageTurnaroundTime = (int)(turnaroundTime * 1.0 / np);
		System.out.println("Average wait time for " + np + " processes: " + averageWaitTime + " sec(s)");
		System.out.println("Average turnaround time for " + np + " processes: " + averageTurnaroundTime + " sec(s)");
	}
    
    public static void roundRobinAlgorithm2(){
    	int np;
		System.out.println("Round Robin Algorithm, Version 2");
		System.out.print("Enter number of processes: ");
		np=verify();
		int i, counter = 0;
		double total = 0.0;
		double timeQuantum;
		double waitTime = 0, turnaroundTime = 0;
		double averageWaitTime, averageTurnaroundTime;
		double[] arrivalTime = new double[10];
		double[] burstTime = new double[10];
		double[] temp = new double[10];
		int x = np;
		Queue order=new Queue();
		for (i = 0; i < np; i++){
			System.out.print("Enter Burst time for Process "+(i+1)+": ");
			burstTime[i] = verify();
			System.out.print("Enter Arrival time for Process "+(i+1)+": ");
			arrivalTime[i] = verify();
			temp[i] = burstTime[i];
			System.out.println("Temp["+i+"] is "+temp[i]);
		}
		System.out.print("Enter Time Quantum: ");
		timeQuantum= verify();
		for(int j=0;j<np;j++) {
			if(arrivalTime[j]==total)
				order.queue(j);
		}
		for (total = 0, i = 0; x != 0;){
			if (temp[i] > 0){
				if (temp[i] <= timeQuantum){
					total = total + temp[i];
					System.out.println("Total is: "+total);
					temp[i] = 0;
					counter = 1;
					System.out.println("Temp["+i+"] is "+temp[i]);
					System.out.println("counter is: "+counter);
				}
				else {
					temp[i] = temp[i] - timeQuantum;
					total = total + timeQuantum;
					System.out.println("Temp["+i+"] is "+temp[i]);
					System.out.println("Total is: "+total);
				}
			}
			if (temp[i] == 0 && counter == 1){
				x--;
				//order.dequeue();
				System.out.println("X is: "+x);
				System.out.println("Turnaround time for Process " + (i + 1) + " : " + (total - arrivalTime[i]));
				System.out.println("Wait time for Process " + (i + 1) + " : " + (total - arrivalTime[i] - burstTime[i]));
				turnaroundTime = (turnaroundTime + total - arrivalTime[i]);
				waitTime = (waitTime + total - arrivalTime[i] - burstTime[i]);
				counter = 0;
				System.out.println("Counter is: "+counter);
			}
			if (i == np - 1){
				System.out.print("i moves from "+i);
				i = 0;
				System.out.println(" to "+i);
			}
			else if (arrivalTime[i + 1] <= total){
				System.out.print("i moves from "+i);
				i++;
				System.out.println(" to "+i);
			}
			else{
				System.out.print("i moves from "+i);
				i = 0;
				System.out.println(" to "+i);
			}
			/*
			if (arrivalTime[i + 1] <= total){
				//if(temp[i]!=0)
					//order.requeue();
				//order.queue(i+1);
				System.out.println("Arrival "+(i+1)+" is "+arrivalTime[i+1]);
				i++;
				System.out.println("i is: "+i);
			}
			if (i == np - 1){
				i = 0;
				System.out.println("i is: "+i);
			}
			
			
			else{
				i = 0;
				System.out.println("i is: "+i);
			}
			else if (arrivalTime[i + 1] <= total){
				System.out.println("Arrival "+(i+1)+" is "+arrivalTime[i+1]);
				i++;
				System.out.println("i is: "+i);
			}
			*/
		}
		averageWaitTime = (int)(waitTime * 1.0 / np);
		averageTurnaroundTime = (int)(turnaroundTime * 1.0 / np);
		System.out.println("Average wait time for " + np + " processes: " + averageWaitTime + " sec(s)");
		System.out.println("Average turnaround time for " + np + " processes: " + averageTurnaroundTime + " sec(s)");
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
