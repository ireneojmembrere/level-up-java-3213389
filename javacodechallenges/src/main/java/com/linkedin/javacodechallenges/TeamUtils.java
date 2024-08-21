package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    if (!teams.isEmpty()){
      // calculate final score results
      int[] finalScores = new int[teams.size()];
      for (int i = 0; i < teams.size(); i++){
        finalScores[i] = teams.get(i).sumTotalScore();
      }

      // sort final scores
      Arrays.sort(finalScores);

      // announce winner
      System.out.println();

      // announce runners up in descending order
      for (int i = teams.size() - 2; i >= 0; i--){
        //WAIT WE NEED TO KNOW THE ORIGINAL ORDER OF TEAMS
      }
    } else{
      System.out.println("No teams participated, so there is no winner.");
    }
  }
}