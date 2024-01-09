package banking_using_exceptional_handling;
import java.util.*;
public class BankingUsingExceptionalHandling {
	public static String username = "chaitanya", password = "chaitanya@123";
	static double balance = 100000.00;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int invalidCount = 0;
		boolean flag = true;
		while(invalidCount++ < 3) {
			System.out.print("Please enter username: ");
			String uname = sc.next();
			System.out.print("Please enter password: ");
			String pword = sc.next();
			if(uname.equals(username) && pword.equals(password)) {
				while(flag) {
					System.out.println("Please enter the options:");
					System.out.println("1.Withdraw\n2.Deposite\n3.Balance\n4.Exit");
					int c = sc.nextInt();
					switch(c) {
					case 1: 
//						try {
							System.out.println("withdraw amount: ");
							withdraw(sc.nextDouble());
//						}
//						catch(CustomException e) {
//							System.out.println(e.getMessage());
//						}
						break;
					case 2:
						try {
							System.out.println("Deposite amount: ");
							deposite(sc.nextDouble());
						}
						catch(CustomException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3: System.out.println(balance);break;
					case 4: flag = false;break;
					default: System.out.println("Please enter the valid option");
					}
				}
				break;
			}
			else {
				System.out.println("Invalid login details");						
			}
		}
		try {
			if(flag) {
				throw new CustomException("Many attempts! Please try later");
			}
		}
		catch(CustomException e) {
			System.out.println(e.getMessage());							
		}
	}
	public static void withdraw(double a) {
		try {
			if(balance - a > 0) {
				balance -= a;
				System.out.println("Amount Withdraw successful");
			}
			else {
				throw new CustomException("Insufficent Balance!");
			}			
		}
		catch(CustomException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void deposite(double a) throws CustomException{
		if(a<500) {
			throw new CustomException("Minimum deposite amount is 500");
		}
		else {
			balance +=a;
			System.out.println("Amount Deposited successful");
		}
	}
}
class CustomException extends Exception {
	CustomException(String s){
		super(s);
	}
}