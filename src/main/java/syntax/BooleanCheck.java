package syntax;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
  @author utkarsh
*/
public class BooleanCheck {
    public static void main(String[] args) {

        String a ="utkarsh";
        System.out.println(a=="utkarsh");
        System.out.println(5 == new Integer(5));
        System.out.println(new Integer(5) == 5);

        Integer i1 = 2;
        Integer i2 = 2;

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i11 = new Integer(2);
        Integer i22 = new Integer(2);

        System.out.println(i11 == i22);
        System.out.println(i11.equals(i22));

        Integer i31 = 2;
        Integer i32 = new Integer(2);

        System.out.println(i31 == i32);
        System.out.println(i31.equals(i32));

        Integer i41 = 2;
        int i42 = 2;

        System.out.println(i41 == i42);
        System.out.println(i42 == i41);

        System.out.println(i41.equals(i42));

        Integer i51 = new Integer(2);
        int i52 = 2;

        System.out.println(i51 == i52);
        System.out.println(i52 == i51);
        System.out.println(i51.equals(i52));

        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s11 = "abc";
        String s22 = new String("abc");

        System.out.println(s11 == s22);
        System.out.println(s11.equals(s22));

        String s31 = new String("abc");
        String s32 = new String("abc");

        System.out.println(s31 == s32);
        System.out.println(s31.equals(s32));

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        System.out.println(list1 == list2);
        System.out.println(list1.equals(list2));

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println(set1 == set2);
        System.out.println(set1.equals(set2));







    }
}
