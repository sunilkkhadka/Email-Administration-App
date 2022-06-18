package emailApp;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//GETTING USER INFO
		System.out.println("Enter firstname: ");
		String firstname = sc.next();
		
		System.out.println("Enter Lastname: ");
		String lastname = sc.next();
		
		//NEW EMAIL OBJECT
		Email em1 = new Email(firstname, lastname);
		int choice = -1;
		do {
			System.out.println("\n==========\nEnter your choice\n[1] Show Details\n[2] Change password\n[3] Change mailbox capacity\n[4] Set Altername mail\n[5] Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				em1.getInfo();
				break;
				
			case 2:
				em1.setPassword();
				break;
				
			case 3:
				em1.setMailCapacity();
				break;
				
			case 4:
				em1.alternateEmail();
				break;
				
			case 5:
				System.out.println("Shutting down...");
				break;
				
			default:
				System.out.println("Enter a valid choice!!");
			}
		} while(choice != 5);
		
		
	}
}
