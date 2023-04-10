package WelshPowell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

public class WelshPowell {

    
    public WelshPowell() {
    }
    
    
    public void coloring (ArrayList<Vertex> arr){
        
        Collections.sort(arr);
        ArrayList<Vertex> UnColored = new ArrayList<>();
        
        for (Vertex v : arr) {
            UnColored.add(v);
        }
        
        int color = 1;
        
        while( !UnColored.isEmpty()){
            System.out.println("================ TO MAU "+ color + " ================");
            for (int i = 0; i < UnColored.size(); i++) {
                
                Vertex currentVertex = UnColored.get(i);
                
                if( !currentVertex.getBanned().contains(color)){
                    // set color
                    currentVertex.setColor(color);
                    
                    ArrayList<Vertex> AdjacentVertices = currentVertex.getAdjacentVertices();
                    
                    for (Vertex v : AdjacentVertices) {
                        if(v.getColor()==0)
                            v.addBannedColor(color);
                    }
                    showResult(arr,currentVertex);
                    UnColored.remove(i--);
                }
            }
            color++;
        }
        
//        Formatter fmt = new Formatter();
//        fmt.format("%8s %8s %8s %10s\n", "Dinh", "Bac", "Mau", "Cam");
//        
//        for(Vertex v : arr){
//            fmt.format("%6s %9s %8s %11s \n", v.getState(), v.getDegree(), v.getColor(), v.bannedColortoString());
//        }
//        System.out.println(fmt);
    }
    
    private void showResult(ArrayList<Vertex> arr, Vertex selectedVertex){
        Formatter result = new Formatter();
        result.format("To mau dinh: %s \n", selectedVertex.getState());
        result.format("%8s %8s %8s %10s\n", "Dinh", "Bac", "Mau", "Cam");
        
        for(Vertex v : arr){
            result.format("%6s %9s %8s %11s \n", v.getState(), v.getDegree(), v.getColor(), v.bannedColortoString());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        
        int[][] adjacencyMatrix = { {0,1,1,1,0,0,0,0,0,0,1,1}, 
                                    {1,0,1,1,0,0,0,0,0,0,0,0},
                                    {1,1,0,1,0,0,0,0,0,0,0,0},
                                    {1,1,1,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,1,0,0,1,0,0},
                                    {0,0,0,0,1,0,1,0,0,1,0,0},
                                    {0,0,0,0,1,1,0,0,0,1,0,0},
                                    {0,0,0,0,0,0,0,0,1,1,0,0},
                                    {0,0,0,0,0,0,0,1,0,1,0,0},
                                    {0,0,0,0,1,1,1,1,1,0,0,0},
                                    {1,0,0,0,0,0,0,0,0,0,0,1},
                                    {1,0,0,0,0,0,0,0,0,0,1,0}};
        
        Vertex vertexA = new Vertex("A");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexG = new Vertex("G");
        Vertex vertexB = new Vertex("B");
        Vertex vertexH = new Vertex("H");
        Vertex vertexK = new Vertex("K");
        Vertex vertexE = new Vertex("E");
        Vertex vertexJ = new Vertex("J");
        Vertex vertexL = new Vertex("L");
        Vertex vertexF = new Vertex("F");
        Vertex vertexI = new Vertex("I");
        
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(vertexA);
        vertices.add(vertexC);
        vertices.add(vertexD);
        vertices.add(vertexG);
        vertices.add(vertexB);
        vertices.add(vertexH);
        vertices.add(vertexK);
        vertices.add(vertexE);
        vertices.add(vertexJ);
        vertices.add(vertexL);
        vertices.add(vertexF);
        vertices.add(vertexI);
        
        for (int i = 0; i < 12; i++) {
            int degree=0;
            for (int j = 0; j < 12; j++) {
                if(adjacencyMatrix[i][j] == 1){
                    vertices.get(i).addAdjacentVertex(vertices.get(j));
                }
                degree += adjacencyMatrix[i][j];
            }
            vertices.get(i).setDegree(degree);
        }
        WelshPowell wp = new WelshPowell();
        
        wp.coloring(vertices); 
    }
    
}
