
package TwoWaterJug;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
            System.out.print(path.get(i).toString());
            if(i != path.size()-1){
                System.out.print(" -> ");
            }
        }
        
        System.out.println();
    }    
}
