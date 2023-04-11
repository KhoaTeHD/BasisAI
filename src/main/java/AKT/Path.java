package AKT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path<T> {
    private List<T> path;
    
    public Path(){
        path = new ArrayList<>();
    }
    
    public void addVertex(T vertex) {
        path.add(vertex);
    }
    
    public List<T> getPath(){
        return path;
    }
    
    public void setPath(List<T> path){
        this.path.addAll(path);
    }

    public void printPath(){
        Collections.reverse(path);
        System.out.println("-------- Ket qua --------");
        for (int i = 0; i < path.size(); i++){
            Vertex v = (Vertex) path.get(i);
            System.out.print(v.getState().getName());
            if(i != path.size()-1){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }    
}
