package companies.lithium;

import java.util.Arrays;
import java.util.List;

public class RotatedSearch {

  private List<Integer> rarray = Arrays.asList(11, 12, 1, 2, 3, 5, 7, 8, 9);

  public static void main(String[] args) {
    RotatedSearch rs = new RotatedSearch();
    System.out.println(rs.rotatedSearch(0, rs.rarray.size() - 1, 8));
    System.out.println(rs.rotatedSearch(0, rs.rarray.size() - 1, 9));
    System.out.println(rs.rotatedSearch(0, rs.rarray.size() - 1, 12));
    System.out.println(rs.rotatedSearch(0, rs.rarray.size() - 1, 1));


  }

  private Integer rotatedSearch(int low, int high, Integer element) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (rarray.get(mid).equals(element)) {
      return mid;
    }

    //figuring out which side is sorted
    //case 1: left side is sorted
    if (rarray.get(mid) > rarray.get(low)) {

      if (element >= rarray.get(low) && element < mid) {
        //case 1.1  left half is sorted & element lies in sorted part search here
        return rotatedSearch(low, mid - 1, element);
      }
      // case 1.2 left half is sorted & element is in unsorted half
      else {
        return rotatedSearch(mid + 1, high, element);
      }


    } else {
      //case 2: right side of array is sorted

      if (element <= rarray.get(high) && element > rarray.get(mid)) {
        //case 2.1 right part is sorted &  element lies in sorted half
        return rotatedSearch(mid + 1, high, element);
      } else {
        //case 2.2 right part is sorted & element is in unsorted half
        return rotatedSearch(low, mid - 1, element);
      }


    }
  }

}
