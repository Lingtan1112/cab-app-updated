package com.lingtan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Reusable {
	static Scanner input = new Scanner(System.in);
	public static String getDetails() {
		String output = "";
		System.out.println("Enter the Mobile Number");
		Long number = input.nextLong();
		System.out.println("Enter the password");
		String password = input.next();
		boolean result =Reusable.loginCheck(number , password);
		if(result==true) {
			output = "The userName and Password are valid";
		}
		else {
			output = "The Credentials are incorrect";			
		}
		return output;			
	}
	
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

	public static int cabType() {
		System.out.println("1.Micro - 10Rs/km"+"\n"+"2.Macro - 15Rs/km"+"\n"+"3.Prime - 20Rs/km");
		System.out.println("Enter your cab choice");
		int choice = input.nextInt();
		return choice;
	}
	
	public static int km() {

		int distance = input.nextInt();
		return distance;
	}

	public static int calculate(int rate, int distance) {

		int multiplication = rate * distance;
		return multiplication;			
	}
	
	public static double gst(double price){
		double percentage = (price * 7)/100;
		double gst = percentage + price;
		return gst;		
	}

	public static boolean dateCheck(String date) {
		boolean dateResult =false;
		LocalDate parsedDate = LocalDate.parse(date);
		if(parsedDate.isBefore(LocalDate.now())) {
			dateResult=true;
			
		}
		return dateResult;
	}
	
	public static boolean timeCheck(String time) {
		boolean timeCheck =false;
		LocalTime parsedDate = LocalTime.parse(time);
		int onlyHour = parsedDate.getHour();
		if(onlyHour>5 && onlyHour<7) {
			timeCheck = true;	
		}
		return timeCheck;


	}

	public static double peakPrice(int distance, double gst) {
		double peakprice = (distance * 0.0125)+gst;
		return peakprice;	
	}

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
