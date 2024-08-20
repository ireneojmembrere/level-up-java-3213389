package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        double gallonsInCCF = 748;
        double minGallonsCharged = gallonsInCCF * 2;
        double minBill = 18.84;
        double costPerCCF = 3.90;

        if (gallonsUsage <= minGallonsCharged){
            return minBill;
        } else{
            return minBill + costPerCCF*java.lang.Math.ceil((gallonsUsage - minGallonsCharged)/ gallonsInCCF);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
