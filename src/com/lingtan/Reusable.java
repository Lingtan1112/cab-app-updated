package com.lingtan;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Reusable {
	static Scanner input = new Scanner(System.in);
	
	public static String getDetails() { //This method fetches the credentials from the user and then sends the mobileNumber and password to a method to check its authenticity
		String output = "";
		System.out.println("Enter the Mobile Number");
		Long number = input.nextLong();
		System.out.println("Enter the password");
		String password = input.next();
		boolean result =Reusable.loginCheck(number , password); //This method is called with two parameter where the MobileNumber and password are passed and this method returns true if the credentials are true else returns false
		if(result==true) {
			output = "The userName and Password are valid";
		}
		else {
			output = "The Credentials are incorrect";			
		}
		return output;			
	}
	/**
	 * This method verifies whether the user entered mobile number and password matches stored credential values and returns true if the credential matches else returns false
	 * @param number
	 * @param password
	 * @return
	 */
	public static boolean loginCheck(Long number, String password){
		boolean valid = false;
		if(number== 9600923846l) {
			if(password.equals("Lingtan")) {
				valid = true;	
			}
			else {
				System.out.println("Retry again");
				getDetails();	
				}
		
	}
		return valid;
		

	
	
}
	/**
	 * This function displays different cab options for the user to select and the selected value is returned to the called function 
	 * @return
	 */
	public static int cabType() {
		System.out.println("1.Micro - 10Rs/km"+"\n"+"2.Macro - 15Rs/km"+"\n"+"3.Prime - 20Rs/km");
		System.out.println("Enter your cab choice");
		int choice = input.nextInt();
		return choice;
	}
	/**
	 * This Method asks the user the distance he needs to travel and that value is returned to the called function
	 * @return
	 */
	public static int km() {

		int distance = input.nextInt();
		return distance;
	}
	/**
	 * This Methods gets the rate/km for the selected cab and the distance he wants to travel and these two values are multiplied and returned 
	 * @param rate
	 * @param distance
	 * @return
	 */
	public static int calculate(int rate, int distance) {

		int multiplication = rate * distance;
		return multiplication;			
	}
	/**
	 * This Method return the fare price after after including a 7% GST to fair price returned from the calculate() method
	 * @param price
	 * @return
	 */
	public static double gst(double price){
		double percentage = (price * 7)/100;
		double gst = percentage + price;
		return gst;		
	}
	/**
	 * This Method is used to check whether the user entered date is valid or whether i.e.) The entered date should be greater or equal to the current date 
	 * @param date
	 * @return
	 */
	public static boolean dateCheck(String date) {
		boolean dateResult =false;
		LocalDate parsedDate = LocalDate.parse(date);
		if(parsedDate.isBefore(LocalDate.now())) {
			dateResult=true;
			
		}
		return dateResult;
	}
	/**
	 * This Method checks whether the user entered time is falling between the peak time of 5PM-7PM, if the time falls between peak it returns true else false 
	 * @param time
	 * @return
	 */
	public static boolean timeCheck(String time) {
		boolean timeCheck =false;
		LocalTime parsedDate = LocalTime.parse(time);
		int onlyHour = parsedDate.getHour();
		if(onlyHour>5 && onlyHour<7) {
			timeCheck = true;	
		}
		return timeCheck;


	}
	/**
	 * This Method is executed only when the entered time is a peak and returns a fare price for the peak price using two parameter i.e) The GST price and distance
	 * @param distance
	 * @param gst
	 * @return
	 */
	public static double peakPrice(int distance, double gst) {
		double peakprice = (distance * 0.0125)+gst;
		return peakprice;	
	}
	/**
	 * This Method returns true if the user is a senior citizen else returns false
	 * @param age
	 * @param price
	 * @return
	 */
	public static boolean seniorCitizen(String age, double price) {
		boolean ageCheck = false;
		LocalDate parsedAge = LocalDate.parse(age);
		LocalDate cdate = LocalDate.now();
		int onlyYearofPerson = parsedAge.getYear();
		int TodayYear = cdate.getYear();
		int ageResult = TodayYear - onlyYearofPerson;
		if(ageResult >= 60) {
			ageCheck = true;				
		
	}
		return ageCheck;



}
	/**
	 * This Method gets the age result and fare price and based on the age entered the user can avail a senior citizen discount or not and if he is senior citizen the discounted price is displayed else the same price is retained and displayed
	 * @param seniorCheck
	 * @param peakPrice
	 * @return
	 */
	public static String seniorOutput(boolean seniorCheck,double peakPrice) {
		String output ="";
		if(seniorCheck==true) {
			double discount = peakPrice/2;
			output = "You are eligible for 50% discount so the total fair is "+discount;	
		}
		else {
			output = "You are not eligible for 50% discount so the total cost is "+peakPrice;
		}
		return output;	
	}
	

}
