package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by utkarsh on 19/03/18.
 */
public class Top3Horses {
  public static Random random = new Random();


  public static Integer [] race( Integer [] horses5){
    Arrays.sort(horses5, Collections.reverseOrder());
    return horses5;
  }

  public static void main1(String[] args) {

    Integer [][] horses = new Integer[5][5];
    Random random = new Random();

    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    {

      horses[i][j] = random.nextInt(50);
    }

    for(int row =0 ;row<5;row++)
      for(int col=0;col<5;col++){
        race(horses[row]);


    }






  }

  static class HorseRace{
    public int horseSpeed;
    public int raceNumber;
    public int getHorseSpeed(){
      return horseSpeed;
    }

    public int getRaceNumber() {
      return raceNumber;
    }

    public HorseRace(int horseSpeed, int raceNumber){
      this.horseSpeed = horseSpeed;
      this.raceNumber = raceNumber;
    }
  }


  public static void main(String[] args) {
    List<PriorityQueue<HorseRace>> initialRaces = new ArrayList<>();

    for(int i = 0 ; i < 5; i++) {
      PriorityQueue<HorseRace> horseRaces = new PriorityQueue<>(Comparator.comparing(HorseRace::getHorseSpeed).reversed());

      for( int j = 0 ; j < 5 ; j++) {
        horseRaces.add(new HorseRace(generateHorse(), i));
      }
      initialRaces.add(horseRaces);
    }

    PriorityQueue<HorseRace> finalRace = new PriorityQueue<>(Comparator.comparing(HorseRace::getHorseSpeed).reversed());

    for( int i = 0 ; i < 5 ; i++){
      finalRace.add(initialRaces.get(i).remove());
    }

    HorseRace winner = finalRace.remove();
    HorseRace tempSecond = finalRace.remove();
    HorseRace tempThird = finalRace.remove();

    PriorityQueue<HorseRace> semisRace = new PriorityQueue<>(Comparator.comparing(HorseRace::getHorseSpeed).reversed());

    semisRace.add(tempSecond);
    semisRace.add(tempThird);
    semisRace.add(initialRaces.get(winner.getRaceNumber()).remove());
    semisRace.add(initialRaces.get(winner.getRaceNumber()).remove());

    semisRace.add(initialRaces.get(tempSecond.getRaceNumber()).remove());

    HorseRace second = semisRace.remove();
    HorseRace third = semisRace.remove();

    System.out.println("1st : " + winner.getHorseSpeed() + " 2nd : " + second.getHorseSpeed() + " 3rd : " + third.getHorseSpeed());

  }

  private static int generateHorse() {
    int i = random.nextInt(50);
    System.out.println("generated new horse with speed : " + i);
    return i;
  }

}
