package AKT;

import java.util.*;

public class AKT {

    public AKT() {
    }

    public void AKTSearch(Vertex initialVertex, Vertex goal) {
        ArrayList<Vertex> closedList = new ArrayList<>();
        ArrayList<Vertex> OpenList = new ArrayList<>();

        initialVertex.setG(0);
        initialVertex.setH(calcHeuristic(initialVertex, goal));
        initialVertex.setF(initialVertex.getG() + initialVertex.getH());
        OpenList.add(initialVertex);
        
        int count=1, state = 1;
        
        System.out.println(initialVertex.toString());

        while(!OpenList.isEmpty()){
            Collections.sort(OpenList);
            
            System.out.println("Lan " + count++ + ":");
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("Tap Open: [");
            
            int i = 0;
            for(Vertex v : OpenList){
                sb.append(v.getState().getName() + "(F = " + v.getF() + ")");
                if( i != OpenList.size()-1){
                    sb.append(", ");
                }
                i++;
            }
            sb.append("] \n");
            
            sb.append("Tap Closed: [");
            
            i = 0;
            for(Vertex v : closedList){
                sb.append(v.getState().getName() + "(F = " + v.getF() + ")");
                if( i != closedList.size()-1){
                    sb.append(", ");
                }
                i++;
            }
            sb.append("] \n");
            
            System.out.println(sb);

            Vertex currentVertex = OpenList.get(0);

            if(goal.equals(currentVertex)) {
                currentVertex.tracePath().printPath();
                break;
            }
            
            // Cho vao tap dong'
            closedList.add(currentVertex);
            
            // Tim dinh ke`
            ArrayList<Vertex> newVertices = new ArrayList<>();
            
            newVertices.add(currentVertex.goBottom());
            newVertices.add(currentVertex.goTop());
            newVertices.add(currentVertex.goLeft());
            newVertices.add(currentVertex.goRight());
            
            System.out.println("===== Tu " + currentVertex.getState().getName() + " sinh ra =====");
            for (Vertex newVertex : newVertices){   
                if(!currentVertex.tracePath().getPath().contains(newVertex)){                    
                    newVertex.setParent(currentVertex);
                    newVertex.setG(currentVertex.getG()+1);
                    int h = calcHeuristic(newVertex, goal);
                    
                    newVertex.setF(newVertex.getG() + h);
                    
                    if (!closedList.contains(newVertex) && !OpenList.contains(newVertex)){
                        newVertex.getState().setName("S"+ state++);
                        OpenList.add(newVertex);
                        System.out.println(newVertex.toString());
                    }
                }
            }
            OpenList.remove(0);
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
        initState.setName("S0");
        State goalState = new State(goalArr);
        Vertex init = new Vertex(initState);
        Vertex goal = new Vertex(goalState);
        
        akt.AKTSearch(init, goal);
    }
}
