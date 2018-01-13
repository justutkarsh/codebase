package companies.olacabs;

/**
 * Created by utkarsh on 31/12/17.
 */
public class BeautifulNumbers {
  static int countArrangements(int n,int[] data){
    if(n<=0){
      return 1;
    }
    int count = 0;
    for(int i=0;i<n;++i){
      if(data[i]%n == 0 || n%data[i] ==0){
        swap(data,i,n-1);
        count += countArrangements(n-1,data);
        swap(data,i,n-1);
      }
    }
    return count;
  }

  static void swap(int[] data,int i,int j){
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  static int arrangements(int n) {
    int[] data = new int[n];
    for(int i=0;i<n;++i){
      data[i] = i+1;
    }
    return countArrangements(n,data);
  }
}
