package companies.Goldmansachs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utkarsh on 16-09-2016.
 */
public class Permutation {


    public static void main(String[] args) {
        List<String> permutations = perm("abcd");

        permutations.stream().forEach(System.out::println);
        System.out.println(permutations.size());
    }

    private static List<String> perm(String buffer) {
        if (buffer == null || buffer.isEmpty()) return null;

        if (buffer.length() == 1) {
            List list = new ArrayList();
            list.add(buffer);
            return list;

        } else {
            Character prefix = buffer.charAt(0);
            String suffix = buffer.substring(1);

            List<String> result = perm(suffix);
            List<String> newResult = new ArrayList<>();

            for (String entry : result) {
                for (int i = 0; i <= entry.length(); i++) {
                    String element = entry.substring(0, i) + prefix + entry.substring(i);
                    newResult.add(element);
                }
            }
            return newResult;
        }
    }
}


