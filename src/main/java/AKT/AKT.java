package AKT;

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;

public class AKT {

    public static Set<Vertex> visited = new HashSet<Vertex>(){
        @Override
        public boolean contains(Object obj) {
            Vertex vertex = (Vertex) obj;

            for (Vertex v : this) {
                if ((vertex.equals(v))) {
                    return true;
                }
            }
            return false;
        }
    };

    public AKT() {
    }

    public void AKTSearch(Vertex initialVertex, Vertex goal) {

        PriorityQueue<Vertex> OpenList = new PriorityQueue<>(){
            @Override
            public boolean contains(Object obj) {
                Vertex vertex = (Vertex) obj;

                for (Vertex v : this) {
                    if ((vertex.equals(v))) {
                        return true;
                    }
                }
                return false;
            }
        };

        initialVertex.setG(0);
        visited.add(initialVertex);
        OpenList.add(initialVertex);

        while(!OpenList.isEmpty()){

            Vertex currentVertex = OpenList.poll();

            if(goal.equals(currentVertex)) {
                currentVertex.tracePath().printPath();
                break;
            }


            ArrayList<Vertex> newVertices = new ArrayList<>();
            
            newVertices.add(currentVertex.goBottom());
            newVertices.add(currentVertex.goTop());
            newVertices.add(currentVertex.goLeft());
            newVertices.add(currentVertex.goRight());
            
            
            for (Vertex newVertex : newVertices){   
                if(!currentVertex.tracePath().getPath().contains(newVertex)){                    
                    newVertex.setParent(currentVertex);
                    newVertex.setG(currentVertex.getG()+1);
                    int h = calcHeuristic(newVertex, goal);
                    
                    newVertex.setF(newVertex.getG() + h);
                    
                    if (!visited.contains(newVertex) && !OpenList.contains(newVertex)){
                        OpenList.add(newVertex);                   
                        visited.add(newVertex);       
                    }
                }                
            }       
        }
    }
    
    private int calcHeuristic(Vertex init, Vertex goal){
        int heuristic = 0;
        for(int i = 0; i < init.getState().getArr().length; i++) {
            for(int j = 0; j < init.getState().getArr()[i].length; j++) {
                if(init.getState().getArr()[i][j] != 0 && init.getState().getArr()[i][j] != goal.getState().getArr()[i][j]) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }

    public static void main(String[] args) {
        AKT akt = new AKT();
        int[][] initArr = {{2,8,3},{1,6,4},{7,0,5}};
        int[][] goalArr = {{1,2,3},{8,0,4},{7,6,5}};
        State initState = new State(initArr);
        State goalState = new State(goalArr);
        Vertex init = new Vertex(initState);
        Vertex goal = new Vertex(goalState);
        
        akt.AKTSearch(init, goal);
    }
}
