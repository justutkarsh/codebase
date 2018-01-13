package recursionndynamicprogramming;

public class CoinSum {
/* infinite no. of coins available for 25,10,5,1
 * f(n)=no of ways of making a change for amount n
 * f(100)= f(100 using 1*25)+f(100 using 2*25).. + f(100 using 4*25)
 *       = f(75 using 0*25) + f(50 using 0*25) .. +1
 */
//static int ways;
static int makeChange(int sum,int denomination){
	if(denomination==1) return 1;
	int ways=0;
	for(int i=1;i*denomination<=sum;i++){
		ways+=makeChange(sum-i*denomination,next(denomination));
	}
	return ways;
}
private static int next(int denomination) {
	// TODO Auto-generated method stub
	switch(denomination){
	case 25: return 10;
	case 10: return 5; 
	case 5:  return 1;
	case 1:  return 0; 
	default: return -1;
	}
 
}
public static void main(String[] args) {
	System.out.println(makeChange(100,25));
	
	
}
}
