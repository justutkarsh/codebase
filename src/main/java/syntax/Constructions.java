package syntax;

import java.util.Arrays;

public class Constructions {
public static void main(String[] args) {
	String[] strArr = new String[]{"string one"};
	System.out.println(Arrays.asList(strArr));
	Class[] classArray = new Class[]{String.class,Integer.class};
	System.out.println(Arrays.asList(classArray));
}
}
