package emailApp;

import java.util.*;
import java.io.*;

public class Email {

	// GLOBAL SCANNER OBJ
	public Scanner sc = new Scanner(System.in);

	// SETTING VARIABLES
	private String firstname;
	private String lastname;
	private String department;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alter_email;

	// CONTRUCTOR TO RECIEVE FNAME AND LNAME

	public Email(String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
		System.out.println("New employee record created: " + firstname + " " + lastname);
		
		//CALLING METHODS
		this.department = this.setDepartment();
		this.password = this.generate_password(8); //DEFAULT password length = 8
		this.email = this.generateEmail();
	}

	// MAIN GENERATING METHOD
	private String generateEmail() {
		String email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase()
				+ ".company.com";
		return email;
	}

	// GET DEPARTMENT
	private String setDepartment() {
		System.out.println("Department codes: \n[1] Sales \n[2] Development \n[3] Accounting \n[4]None");
		boolean flag = false;
		do {
			System.out.println("Enter department Code");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				return "sales";
			case 2:
				return "development";
			case 3:
				return "accounting";
			case 4:
				return "";
			default:
				System.out.println("Invalid choice, try again!!");
			}
		} while (!flag);
		return null;
	}

	// GENERATE RANDOM PASSWORD
	private String generate_password(int length) {
		Random random = new Random();
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*?";
		String values = Capital_chars + Small_chars + numbers + symbols;
		String password = "";
		for (int i = 0; i < length; i++) {
			password = password + values.charAt(random.nextInt(values.length()));
		}
		
		return password;
	}
	
	//CHANGE PASSWORD METHOD
	public void setPassword() {
		boolean flag = false;
		do {
			System.out.println("Do you want to change your password? [Y/N] ");
			char choice = sc.next().charAt(0);
			if(choice == 'Y' || choice == 'y') {
				flag = true;
				System.out.println("Enter current password: ");
				String temp = sc.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password = sc.next();
					System.out.println("Password changed successfully!");
				}
				else {
					System.out.println("Incorrent password!");
				}
			}
			else if(choice == 'N' || choice == 'n') {
				flag = true;
				System.out.println("Password change option cancelled");
			}
			else {
				System.out.println("Enter valid choice!!");
			}
		} while(!flag);
	}
	
	//SET MAILBOX CAPACITY METHOD
	public void setMailCapacity() {
		System.out.println("Current capacity = " + this.mailCapacity + " mb");
		System.out.println("Enter new mailbox capacity: ");
		this.mailCapacity = sc.nextInt();
		System.out.println("Mailbox capacity is successfully changed to " + this.mailCapacity + " mb");
	}
	
	//SET ALTERNATE EMAIL
	public void alternateEmail() {
		System.out.println("Enter new alternate email: ");
		this.alter_email = sc.next();
		System.out.println("Alternate email is successfully set");
	}
	
	//DISPLAY USER INFO
	public void getInfo() {
		System.out.println("Name: " + this.firstname + " " + this.lastname);
		System.out.println("Department: " + this.department);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);
		System.out.println("Mailbox capacity: " + this.mailCapacity + " mb");
		System.out.println("Alternate email: " + this.alter_email);
	}

}







