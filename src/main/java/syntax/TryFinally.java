package syntax;

/**
 * Created by utkarsh on 02-08-2016.
 */
public class TryFinally {
    public static void main(String[] args) {
        try{
            function();
        }finally {
            System.out.println("inside finally main");
        }
    }

    private static void function()  {
        try{
            System.out.println("inside function");
            throw new RuntimeException("exception");
           // System.out.println("after exception");
        }finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("inside finally function");
        }
    }
}
