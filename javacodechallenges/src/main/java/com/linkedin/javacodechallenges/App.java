package com.linkedin.javacodechallenges;

import java.util.List;
import java.lang.Math;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        if (purchases.size() == 0){
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < purchases.size(); i++){
            sum += Math.ceil(purchases.get(i)) - purchases.get(i);
        }
        return sum / purchases.size();
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
