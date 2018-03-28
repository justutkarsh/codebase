package companies.grabtaxi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CountWords {

  Set<String> dictionary = new HashSet<>();

  {
    dictionary.add("cdf");
    dictionary.add("cd");
    dictionary.add("f");
    dictionary.add("d");
    dictionary.add("c");
  }

  int ways = 0;

  public void countways(char[] input, int start) {

    if (start == input.length) {
      ways++;
    }

    for (int i = start + 1; i < input.length + 1; i++) {
      if (dictionary.contains(String.valueOf(input, start, i - start)
      )) {
        countways(input, i);
      }
    }

  }


  public int countNewways(char[] input, int start) {
    int newways = 0;
    if (start == input.length) {
      return 1;
    }

    for (int i = start + 1; i < input.length + 1; i++) {
      if (dictionary.contains(String.valueOf(input, start, i - start)
      )) {
        newways += countNewways(input, i);
      }
    }
    return newways;

  }


  public List<String> trackWays(char[] input, int start, String buffer) {
    int newways = 0;
    List<String> result = new ArrayList<>();
    if (start == input.length) {
      result.add(buffer);
    }

    for (int i = start + 1; i < input.length + 1; i++) {
      String temp = String.valueOf(input, start, i - start);
      if (dictionary.contains(temp)) {
        buffer = temp + " ";
        result.add(buffer);
        List<String> remaining = trackWays(input, i, buffer);
        result.addAll(remaining);
      }
    }
    return result;

  }

  public List<String> trackWays2(char[] input, int start) {
    List<String> result = new ArrayList<>();
    if (start == input.length) {
      result.add("");
      return result;
    }

    for (int i = start + 1; i < input.length + 1; i++) {
      String temp = String.valueOf(input, start, i - start);
      if (dictionary.contains(temp)) {
        List<String> remaining = trackWays2(input, i);
        for(String str : remaining) {
          result.add(temp + " " + str);
        }
      }
    }
    return result;

  }

  public static void main(String[] args) {
    CountWords cw = new CountWords();
    cw.countways("cdf".toCharArray(), 0);
    System.out.println(cw.ways);
    System.out.println(cw.countNewways("cdf".toCharArray(), 0));

//    cw.trackWays("cdf".toCharArray(),0,"").stream().forEach(s -> System.out.println(s));
    cw.trackWays2("cdf".toCharArray(),0).stream().forEach(s -> System.out.println(s));


  }
}
