package com.linkedin.javacodechallenges;

import java.lang.Integer;
import java.lang.String;
import java.util.Scanner;

public class App 
{
    // function determines whether or not the current year is a leap year
    public static boolean isLeapYear(int year){
        if (year % 4 == 0){ // all leap years are divisible by four
            if (year % 100 == 0 && year % 400 != 0){ // the beginning of a century that is not divisible by 400 is NOT a leap year
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // Create function to calculate the date that's 
    // 100 days from now DDMMYYYY
    public static String oneHundredDaysFromNow(String date){
        // get numerical values from the string argument
        int numericalDate = Integer.valueOf(date);
        int day = numericalDate / 1000000;
        int month = (numericalDate / 10000) % 100;
        int year = numericalDate % 10000;

        // how many days are in each month of the year (leap years are different)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInMonthLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // iterate 100 times, stepping 1 day forward each time
        for (int daysPassed = 1; daysPassed <= 100; daysPassed++){
            if (isLeapYear(year) && day == daysInMonthLeapYear[month - 1]){ // end of the month in a leap year
                day = 1;
                if (month == 12){ // end of the year, need to jump to January
                    month = 1;
                    year++;
                } else { // otherwise increment the month
                    month++;
                }
            } else if (!isLeapYear(year) && day == daysInMonth[month - 1]) { // end of the month in a regular year
                day = 1;
                if (month == 12) { // end of the year, need to jump to January
                    month = 1;
                    year++;
                } else { // otherwise increment the month
                    month++;
                }
            } else {
                day++; // otherwise increment the day
            }
        }

        String strDay, strMonth, strYear = String.valueOf(year);
        if (day < 10){ // convert day integer to string in DD format
            strDay = "0" + String.valueOf(day);
        } else {
            strDay = String.valueOf(day);
        }
        if (month < 10){ // convert month integer to string in MM format
            strMonth = "0" + String.valueOf(month);
        } else {
            strMonth = String.valueOf(month);
        }

        return strDay + strMonth + strYear; // return DDMMYYYY
    }

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter todays date in the format DDMMYYYY:");
        String todaysDate = scanner.nextLine();

        System.out.println("100 days from now will be " + oneHundredDaysFromNow(todaysDate));
        
    }
}
