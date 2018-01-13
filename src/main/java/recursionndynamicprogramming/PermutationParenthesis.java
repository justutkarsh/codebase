package recursionndynamicprogramming;

public class PermutationParenthesis {
	
	static void print(int leftRemaining,int rightRemaining,String formation){
		if(leftRemaining<0||rightRemaining<0) return;
		if(leftRemaining>rightRemaining) return;
		
		if(rightRemaining==0&&rightRemaining==0)
		{
			System.out.println(formation);return;
		}
	    
		if(leftRemaining==0)
			print(leftRemaining,rightRemaining-1,formation+"}");
		
		print(leftRemaining-1,rightRemaining,formation+"{");
		print(leftRemaining,rightRemaining-1,formation+"}");
	}
	public static void PrintParenthesis(int leftRemain, int rightRemain, String currentString)
	{
		//firstly check if there is need to go further
		if(rightRemain==0)//all printed out
		{	
			System.out.println(currentString);
			return;
		}
		//now coming to the recursive part
		if(leftRemain>0)//more left parenthesis left for printing
		{
			//choice 1, print another left parenthesis
			PrintParenthesis(leftRemain-1, rightRemain, currentString+"(");
			//choice 2, print right parenthesis if valid
			if(leftRemain < rightRemain)//which means more left parenthesis have been used 
				PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
		}
		else//now there are only right parenthesis left
			PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
	}
	
	//int a = 22.43434444444
	public static void double2Rational(double a){
		
		
	}
	
	public static void main(String[] args) {
		//print(3,3,"");
		PrintParenthesis(3, 3, "");
	}

}
