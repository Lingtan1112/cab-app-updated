package com.lingtan;
import java.util.Scanner;

public class MainClass {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		String valid = Reusable.getDetails();
		System.out.println(valid);
		int cabChoice = Reusable.cabType();
		cabDetails(cabChoice);
		
		

	}
	
	public static void cabDetails(int cabChoice) {
		switch(cabChoice) {
		case 1:
			String type1 = "Micro";
			int rate1=10;
			System.out.println("The cab selected is "+  type1);
			System.out.println("Please Enter the distance of travel:");
			int distance1 = Reusable.km();
			double price1 = Reusable.calculate(rate1,distance1);
			double gst1 = Reusable.gst(price1);
			System.out.println("The Actual price without GST is "+price1+" and the price inclusive of GST is "+gst1);
			journeyDetails(distance1,gst1);
			break;
		
		case 2:
			String type2 = "Micro";
			int rate2 = 15;
			System.out.println("The cab selected is "+  type2);
			System.out.println("Please Enter the distance of travel:");
			int distance2 = Reusable.km();
			double price2 = Reusable.calculate(rate2,distance2);
			double gst2 = Reusable.gst(price2);
			System.out.println("The Actual price without GST is "+price2+" and the price inclusive of GST is "+gst2);
			journeyDetails(distance2,gst2);
			break;
		
		case 3:
			String type3 = "Micro";
			int rate3 = 20;
			System.out.println("The cab selected is "+  type3);
			System.out.println("Please Enter the distance of travel:");
			int distance3 = Reusable.km();
			double price3 = Reusable.calculate(rate3,distance3);
			double gst3 = Reusable.gst(price3);
			System.out.println("The Actual price without GST is "+price3+" and the price inclusive of GST is "+gst3);
			journeyDetails(distance3,gst3);
			break;
		default:
			System.out.println("Please Enter a valid choice");
			//Reusable.cabType();
			
		}
		
		
	}
	
	public static void journeyDetails(int distance, double gst) {
		System.out.println("Enter the Date of Journey in YYYY-MM-DD");
		String date = input.next();
		boolean dateCheck = Reusable.dateCheck(date);
		if(dateCheck == true) {
			System.out.println("The Entered date is invalid, The date should be a future date");
			journeyDetails(distance, gst);
		}
		else {
			System.out.println("Enter the Time of Journey in HH:MM:SS");
			String time = input.next();
			boolean timeCheck = Reusable.timeCheck(time);
			if(timeCheck==true) {
				double peakPrice = Reusable.peakPrice(distance,gst);		
				System.out.println("Your Journey on starts on " + date +" at " + time +" Since 5pm to 7pm is a peak hours thus the fair price is "+ peakPrice);
				System.out.println("Enter your Date of Birth to avail 50% discount if you are a senior citizen");
				String age = input.next();
				boolean seniorCheck = Reusable.seniorCitizen(age, peakPrice);
				String seniorResult = Reusable.seniorOutput(seniorCheck,peakPrice);
				System.out.println(seniorResult);
			}
			else {
				System.out.println("Your Journey on starts on " + date +" at " + time +" and you fair price is"+gst);
				System.out.println("Enter your Date of Birth to avail 50% discount if you are a senior citizen");
				String age = input.next();
				boolean seniorCheck = Reusable.seniorCitizen(age, gst);
				String seniorResult = Reusable.seniorOutput(seniorCheck, gst);
				System.out.println(seniorResult);
			}
		}			
	}

	





}
