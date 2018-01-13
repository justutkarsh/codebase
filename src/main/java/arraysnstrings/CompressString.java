package arraysnstrings;

public class CompressString {

	public static String compressString(char[] inputArr){
		Integer count=0;
		int index=0;
		Character prevChar = inputArr[0];
		for(Character c:inputArr){
			//checks
			if(index>=inputArr.length)
				return new String(inputArr);
			
			if(c==prevChar){
				count++;
			}
			else{
				inputArr[index++]=prevChar;
				for(char ch:count.toString().toCharArray()){
					inputArr[index++]=ch;
				}
				count=1;
				prevChar=c;
			
			}

			
		}
		inputArr[index++]=prevChar;
		for(char ch:count.toString().toCharArray()){
			if(index>=inputArr.length)
				return new String(inputArr);
			inputArr[index++]=ch;
		}
		
	 return new String(inputArr).substring(0,index);

	}
	
	
//	public static String compressInPlace(char[] inputArr){
//		char prevChar=inputArr[0];
//		int index=0;
//		int count=0;
//		for(int i=0;i<inputArr.length-1;i++){
//			if(inputArr[i]==prevChar){
//				count++;
//			}else{
//				
//			}
//			
//		}
//	}
	public static void main(String[] args) {

		String input="aaaaabbbbbcccccdd";
		char[] inputArr = input.toCharArray();
		System.out.println(compressString(inputArr));
	}
}
