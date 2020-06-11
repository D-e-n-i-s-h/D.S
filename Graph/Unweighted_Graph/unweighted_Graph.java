package D.S.Graph.Unweighted_Graph;

import java.util.*;

public class unweighted_Graph<E> {

    private Map<E, List<E>> node = new HashMap<>();
    private HashSet<E> visited = new HashSet<>();

    private void addvertex(E s) {
        node.put(s, new LinkedList<>());
    }

    public void addEdge(E source, E destination) {
        if (!node.containsKey(source))
            addvertex(source);
        if (!node.containsKey(destination))
            addvertex(destination);

        node.get(source).add(destination);

    }

    public int getvertex() {
        return node.keySet().size();
    }

    public int getEdge() {
        int count = 0;
        for (E i : node.keySet()) {
            count += node.get(i).size();
        }
        return count;
    }

    public void print() {
        for (E e : node.keySet()) {
            System.out.print(e + "->" + node.get(e) + " ");

        }
        System.out.println();
    }

    public void delete_Node(E remove) {
        if (!node.containsKey(remove))
            System.out.println("Node is not in the graph");
        else
            node.remove(remove);
        for (E i : node.keySet()) {

            node.get(i).remove(remove);

        }
    }

    public void bfs(E n) {
        BFS(n);
        visited.clear();
    }

    private void BFS(E n) {
        if (visited.contains(n)) {
            return;
        } else {
            visited.add(n);
            System.out.print(n + "-->");
            for (E i : node.get(n)) {
                BFS(i);
            }
        }
    }


}
