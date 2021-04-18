package com.lingtan;
import java.util.Scanner;

public class MainClass {		//MainClass where the program starts its equation
		static Scanner input = new Scanner(System.in);  	//Object for scanner class is and used for getting input from user
		public static void main(String[] args) {
		
		String valid = Reusable.getDetails();		//get details method is called to get the login credential details from the user
		System.out.println(valid);			//To print the value returned by the getDetails method
		int cabChoice = Reusable.cabType();  //cabType method is called just to select the car type from and the return the choice from the user(1,2 or 3)
		cabDetails(cabChoice);// Passes the choice of car (1,2 or 3) to the method cabDetails which displays and calls several other methods
	}
	/**
	 * This method is used to select the cab first and then based on the selection this method calls other methods 
	 * to get the distance of travel, fare for the travel, and the fare price for the travel including gst and call a method to get the journey date details
	 * @param cabChoice
	 */
	public static void cabDetails(int cabChoice) {
		switch(cabChoice) {	//This case structure is used to select the car type selected by the user and execute the case called by user
		case 1:
			String type1 = "Micro";
			int rate1=10;
			System.out.println("The cab selected is "+  type1);
			System.out.println("Please Enter the distance of travel:");
			int distance1 = Reusable.km();//This method gets the distance of travel and returns the value 
			double price1 = Reusable.calculate(rate1,distance1);// This method calculates the fare for the travel distance exclusive of GST and returns the fare price
			double gst1 = Reusable.gst(price1); //This Method calculates the total fare price inclusive of the 7% GST and returns the value
			System.out.println("The Actual price without GST is "+price1+" and the price inclusive of GST is "+gst1);
			journeyDetails(distance1,gst1); //This method is called to get the input from the user which are the journey details(the date and time of journey)
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
	/**This method is used to get the journey details from the user, The journey details are the Journey Date and Journey Time and there is condition used to check 
	 * whether the journey date is future date or not if the date is a past date the user needs to enter a valid date of travel, and another condition is checked if the time of 
	 * travel falls on the peak hour or not, if it is a peak hour the fair price increases by 1.25%/km else the same price is retained
	 * 
	 * @param distance
	 * @param gst
	 */
	public static void journeyDetails(int distance, double gst) { 
		System.out.println("Enter the Date of Journey in YYYY-MM-DD");
		String date = input.next();
		boolean dateCheck = Reusable.dateCheck(date);	// This methods checks whether the entered date is valid or not, Entered Date should be >= Present date
		if(dateCheck == true) {
			System.out.println("The Entered date is invalid, The date should be a future date");
			journeyDetails(distance, gst); // if Entered Date is invalid this method is called again to fetch the date and time from the user
		}
		else {
			System.out.println("Enter the Time of Journey in HH:MM:SS");
			String time = input.next();
			boolean timeCheck = Reusable.timeCheck(time); //This method checks whether the user entered input falls in the peak time of 5-7PM 
			if(timeCheck==true) { // If the Entered time is a peak time then the if block is executed
				double peakPrice = Reusable.peakPrice(distance,gst);//This method is used to find the peakprice using the fare price including gst	
				System.out.println("Your Journey on starts on " + date +" at " + time +" Since 5pm to 7pm is a peak hours thus the fair price is "+ peakPrice);
				System.out.println("Enter your Date of Birth to avail 50% discount if you are a senior citizen");
				String age = input.next();
				boolean seniorCheck = Reusable.seniorCitizen(age, peakPrice); //This method is used to find whether the person registering is a senior citizen or not
				String seniorResult = Reusable.seniorOutput(seniorCheck,peakPrice); //This method gives the altered fare prize or the retaining prize based whether the person is senior citizen or not
				System.out.println(seniorResult);
			}
			else {		//This else block is executed when the user entered time does not fall on the peak time i.e) not between 5-7PM 
				System.out.println("Your Journey on starts on " + date +" at " + time +" and you fair price is"+gst);
				System.out.println("Enter your Date of Birth to avail 50% discount if you are a senior citizen");
				String age = input.next();
				boolean seniorCheck = Reusable.seniorCitizen(age, gst); //This method is used to find whether the person registering is a senior citizen or not 
				String seniorResult = Reusable.seniorOutput(seniorCheck, gst);//If the user is not a citizen then the fare price is retained and returned as string
				System.out.println(seniorResult);
			}
		}			
	}


}
