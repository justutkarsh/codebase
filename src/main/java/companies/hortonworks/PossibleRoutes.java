package companies.hortonworks;

import java.util.*;

/**
 * Created by utkarsh on 11-10-2016.
 */
public class PossibleRoutes {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("A", null);
        graph.addEdge("B", null);
        graph.addEdge("C", null);
        graph.addEdge("D", null);
        graph.addEdge("E", null);

    }

    static class Graph {
        HashMap<String, Set<String>> graph = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        public void addEdge(String a, String b) {

            Set<String> adjacents = graph.get(a);
            if (adjacents == null) {
                Set<String> set = new HashSet<>();
                set.add(b);
                graph.put(a, set);

            } else {
                graph.get(a).add(b);
            }

        }

        public void search(String src, String dest, LinkedList<String> path) {
            visited.put(src, true);
            if (src.equals(dest)) {
                System.out.println(Arrays.toString(path.toArray()));
                return;
            } else {
                for (String ajacent : graph.get(src)) {
                    if (visited.get(ajacent) == null) {
                        path.add(ajacent);
                        search(ajacent, dest, path);
                    }
                }
            }
        }

        public List<LinkedList> allRoutes(String src, String dest, LinkedList path, List<LinkedList> allPaths) {
            visited.put(src,true);
            if (src.equals(dest)) {
                allPaths.add(path);
            }
            else {

            }

            return allPaths;
        }
    }
/*

 If I have the following records:
        A, B, C, D, E

    and the following represents the connections:
        (A,B),(A,C),(B,A),(B,D),(B,E),(B,F),(C,A),(C,E),
        (C,F),(D,B),(E,C),(E,F),(F,B),(F,C),(F,E)

        [where (A,B) means record A connects to record B]


  All paths connecting B to E:
      B->E
      B->F->E
      B->F->C->E
      B->A->C->E
      B->A->C->F->E

 */


}
