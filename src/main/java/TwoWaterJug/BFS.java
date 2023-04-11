
package TwoWaterJug;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
        
public class BFS {
    public static int MAX_JUG1, MAX_JUG2, GOAL;
    
    public static Queue<Vertex> OpenList = new LinkedList<>();
    
    public static ArrayList<Vertex> closedList = new ArrayList<>();
    
    public static void main(String[] args) {
        MAX_JUG1 = 4;
        MAX_JUG2 = 3;
        GOAL = 2;

        Vertex.setMaxJugsCapacity(MAX_JUG1, MAX_JUG2);
        
        Vertex initialVertex = new Vertex(new State(0, 0));
        OpenList.add(initialVertex);
        
        int count = 1;
        
        while(!OpenList.isEmpty()){
            System.out.println("Lan " + count++ + ":");
            StringBuilder sb = new StringBuilder();
            
            sb.append("Tap Open: [");
            int i = 0;
            for(Vertex v : OpenList){
                sb.append(v.getState().toString());
                if( i != OpenList.size()-1){
                    sb.append(", ");
                }
                i++;
            }
            sb.append("] \n");
            
            sb.append("Tap Closed: [");
            i = 0;
            for(Vertex v : closedList){
                sb.append(v.getState().toString());
                if( i != closedList.size()-1){
                    sb.append(", ");
                }
                i++;
            }
            sb.append("] \n");
            
            System.out.println(sb);
            
            Vertex currentVertex = OpenList.poll();
            
            if(currentVertex.getState().getJug1() == GOAL || currentVertex.getState().getJug2() == GOAL){
                currentVertex.tracePath().printPath();                                                   
                break;
            }
            
            System.out.println("====== Lay "+ currentVertex.toString() + " ra khoi OPEN ======\n" );
            
            ArrayList<Vertex> newVertices = new ArrayList<>();
            
            newVertices.add(currentVertex.full_jug1());
            newVertices.add(currentVertex.full_jug2());
            newVertices.add(currentVertex.empty_jug1()); 
            newVertices.add(currentVertex.empty_jug2());                        
            newVertices.add(currentVertex.pour_jug1_jug2());
            newVertices.add(currentVertex.pour_jug2_jug1());
            
            closedList.add(currentVertex);
            for (Vertex newVertex : newVertices){   
                if(!currentVertex.tracePath().getPath().contains(newVertex)){                    
                    newVertex.setParent(currentVertex);
                    
                    if (!closedList.contains(newVertex) && !OpenList.contains(newVertex)){
                        OpenList.add(newVertex);       
                    }
                }                
            }
        }
    }        
}
