package D.S.Graph.Weight_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class weight_Graph<E> {
    private Map<E, LinkedList<node_weight>> node = new HashMap<>();

    private void add_vertex(E s) {
        node.put(s, new LinkedList<>());
    }

    public void addEdge(E source, E destination, int Weight) {
        if (!node.containsKey(source))
            add_vertex(source);
        if (!node.containsKey(destination))
            add_vertex(destination);
        node_weight temp = new node_weight();
        temp.data = destination;
        temp.setWeight(Weight);

        node.get(source).add(temp);
    }

    public void delete(E remove) {
        node.remove(remove);
        for (E i : node.keySet()) {
            for (node_weight select : node.get(i)) {
                if (select.data == remove) {
                    node.get(i).remove(select);
                }
            }
        }
    }

    public void print() {
        System.out.println("Representation->(node,weight)");
        for (E i : node.keySet()) {
            System.out.print(i + "-> ");
            for (node_weight f : node.get(i)) {
                System.out.print("(" + f.data + "," + f.getWeight() + ") ");
            }
            System.out.println();
        }

    }
    public int getVertex(){
        return node.keySet().size();
    }

    public int getEdges(){
        int count=0;
        for(E i:node.keySet()){
            for(node_weight j:node.get(i)){
                count++;
            }
        }
    return count;
    }


    private class node_weight {
        E data;
        private int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
