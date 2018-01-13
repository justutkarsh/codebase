package syntax;

public class loopCheck {
    public static void main(String args[]) {
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j >= 0; j--) {
                if (i == j) break;
                System.out.println("i=" + i + " j=" + j);
            }
        }


        char[] input = {'a', 'b', 'c', 'd', 'e'};

        for (char ch : input) {
            input[0] = 'z';
            System.out.println(ch);
        }

        for (int i = 0; i < 5; i++) {

            i--;
            i--;
            System.out.println(i);

        }

    }

}
