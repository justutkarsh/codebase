package arraysnstrings;

public class RedundantSpaces {
	private char[]str;

	public RedundantSpaces(String input){
		str=input.toCharArray();
	}
	public void print(){
		System.out.println(str);
	}

	private int skipWord(int start){
		while(str[start]!=' '&& start<str.length-1)
			start++;
		return start;
	}

	private int skipSpaces(int start){
		while(str[start]==' '&& start<str.length-1)
			start++;
		return start;

	}

	public void inPlaceRemoval(){

		int wb=0;
		int we=0;
		int tPtr=0;

		wb=skipSpaces(0);
		we=skipWord(wb);
		tPtr=0;
		System.arraycopy(str,wb,str,tPtr,we-wb+1);

		while(wb<str.length-1){
			tPtr+=we-wb+1;
			wb=skipSpaces(we);
			we=skipWord(wb);

			if(wb>tPtr){
				System.arraycopy(str,wb,str,tPtr,we-wb+1);
			}
		}



	}
	public static void main(String[] args) {

		RedundantSpaces rs= new RedundantSpaces("  This String     has     many  redundant   spaces    ");
		rs.inPlaceRemoval();
		rs.print();


	}
}
