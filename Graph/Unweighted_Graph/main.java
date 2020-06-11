package D.S.Graph.Unweighted_Graph;

public class main {
    public static void main(String[] args) {
        unweighted_Graph s=new unweighted_Graph();
        s.addEdge(2,5);
        s.addEdge(5,9);
        s.addEdge(7,6);
        s.addEdge(6,8);
        s.addEdge(2,6);
        s.addEdge(8,7);
        s.bfs(2);
    }
}
