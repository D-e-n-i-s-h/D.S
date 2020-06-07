package D.S.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class weight_Graph<E> {
    private class node_weight{
        E data;
        int weight;
    }
    private Map<E, LinkedList<node_weight>> node=new HashMap<>();

    private void add_vertex(E s){
        node.put(s,new LinkedList<>());
    }
    public void addEdge(E source,E destination,int Weight){
        if(!node.containsKey(source))
            add_vertex(source);
        if (!node.containsKey(destination))
            add_vertex(destination);
        node_weight temp=new node_weight();
        temp.data=destination;
        temp.weight=Weight;

        node.get(source).add(temp);
    }
    public void print(){
        System.out.println("Representation->(node,weight)");
        for(E i:node.keySet()){
            System.out.print(i+"-> ");
            for (node_weight f:node.get(i)){
                System.out.print("("+f.data+","+f.weight+") ");
            }
            System.out.println();
        }

    }
}
