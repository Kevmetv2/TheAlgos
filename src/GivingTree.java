import java.util.*;
import java.lang.StringBuilder;

public class GivingTree {
    public static void main(String[] args) {
        String input = "(A,B) (B,C) (A,E) (B,D)";

        Graph graph = new Graph();
        String[] splitted = input.split(" ");
        for(String x : splitted){
            if(x.length() > 3 && Character.isAlphabetic(x.charAt(1)) && Character.isAlphabetic(x.charAt(3))) {
                String start = String.valueOf(x.charAt(3));
                String end = String.valueOf(x.charAt(1));
                if(!graph.hasVertex(start)){
                    graph.addVertex(start);
                }
                if(!graph.hasVertex(end)){
                    graph.addVertex(end);
                }
                if(graph.hasEdge(start,end)){
                    System.out.println("E2");
                }
                graph.addEdge(start,end);
            }else{
                System.out.println("E1"); // invalid input
                break;
            }
        }
        if(!graph.checkE3()) System.out.println("E3");

        System.out.println("============");
        System.out.println(graph.toString());
        System.out.println(graph.out());
    }


}

class Graph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(destination).add(source);

    }
    public boolean checkE3(){
        for (T v : map.keySet()) {
            if(map.get(v).size()>2){
                return false;
            }
        }
        return true;
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public boolean hasVertex(T s) {
        if (map.containsKey(s)) {
            return true;
        }

        return false;

    }

    // This function gives whether an edge is present or not.
    public boolean hasEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            return true;
        }
        return false;
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) { // for every nod
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) { // print neighbours
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    public String out(){
        StringBuilder sb = new StringBuilder();
        for( T v:map.keySet()){
            if(map.get(v).size() != 0) {
                sb.append("(");
                sb.append(v.toString());
                for (T w : map.get(v)) {
                    sb.append("(");
                    sb.append(w.toString() + ")");
                }
                sb.append(")");
            }
        }

        return sb.toString();
    }
}

// append('(A(B(C)(D))(E))
