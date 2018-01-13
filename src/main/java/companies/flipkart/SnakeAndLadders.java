package companies.flipkart;

import java.util.*;

/**
 * Created by utkarsh on 28-02-2016.
 */
public class SnakeAndLadders {

    class Player {
        String name;
        int position;

        public Player(String name) {
            this.name = name;
        }
    }

    ;

    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladder = new HashMap<>();
    Map<String, Player> players = new HashMap<>();

    public SnakeAndLadders() {
        snakes.put(50, 2);
        snakes.put(40, 9);

        //ladder.put(30, 40);
        ladder.put(60, 99);

        players.put("1", new Player("1"));
        players.put("2", new Player("2"));
    }


    private int diceThrow() {
        Random random = new Random();
        return random.nextInt() % 6 + 1;
    }

    public boolean play(Player p) throws Exception {

        int diceThrow = 0;
        do {
            diceThrow = this.diceThrow();
            int currentPosition = p.position;
            if (currentPosition >= 100) {
                return true;
            }
            if (ladder.get(currentPosition) != null && snakes.get(currentPosition) != null)
                throw new Exception("Invalid Configuration");

            if (ladder.get(currentPosition + diceThrow) != null) {
                currentPosition = ladder.get(currentPosition + diceThrow);
                p.position = currentPosition;

            } else if (snakes.get(currentPosition + diceThrow) != null) {
                currentPosition = snakes.get(currentPosition + diceThrow);
                p.position = currentPosition;
            } else {
                p.position = currentPosition + diceThrow;
            }

        } while (diceThrow == 6);
        return false;
    }

    private int minimalThrow() {
        int start = 0, destination = 100;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[101];
        int[] distance = new int[101];
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
           // System.out.println("removing"+queue.peek());
            Integer element = queue.remove();
            if (element >= 100) {
                return distance[element];
            }
            if (snakes.get(element) != null) {
                int nextElementSnake = snakes.get(element);
                if (!visited[nextElementSnake]){
                    queue.add(nextElementSnake);
                  //  System.out.println("adding"+nextElementSnake);
                    visited[nextElementSnake] = true;
                    distance[nextElementSnake] = distance[element];
                }

            }
            if (ladder.get(element) != null) {
                int nextElementLadder = ladder.get(element);
                if (!visited[nextElementLadder]){
                    queue.add(nextElementLadder);
                //    System.out.println("adding"+nextElementLadder);
                    visited[nextElementLadder] = true;
                    distance[nextElementLadder] = distance[element];
                }

            }
            for (Integer next = element + 1; next <= element + 6 && next <= 100; next++) {
                if (!visited[next]){
                    distance[next] = distance[element] + 1;
                    queue.add(next);
                    visited[next]=true;
                   // System.out.println("adding"+next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SnakeAndLadders game = new SnakeAndLadders();
        System.out.println("Optimal throws Needed=" + game.minimalThrow());
        boolean gameOn = true;
        do {
            for (Player p : game.players.values()) {
                try {
                    if (game.play(p)) {
                        System.out.println(p.name + " has won");
                        gameOn = false;
                    } else {
                        System.out.println("name=" + p.name + "& Position=" + p.position);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (gameOn);


    }


}
