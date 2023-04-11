package DSATUR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.PriorityQueue;

public class DSATUR {

    public DSATUR() {
    }
    
    public void coloring(int[][] matrix, ArrayList<Vertex> arr ){
        //PriorityQueue<Vertex> unColor = new PriorityQueue();
        ArrayList<Vertex> unColor = new ArrayList();
        
        for(Vertex v : arr){
            unColor.add(v);
        }
        
        //Vertex max = Collections.max(arr, Comparator.comparing(Vertex::getDegree));
        
        Formatter fmt = new Formatter();
        
        fmt.format("Dinh: %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n", "A", "C", "D", "G", "B", "H", "K", "E", "J", "L", "F", "I");
        
        fmt.format("Bac: %10s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n" , arr.get(0).getDegree()
                                                                    , arr.get(1).getDegree()
                                                                    , arr.get(2).getDegree()
                                                                    , arr.get(3).getDegree()
                                                                    , arr.get(4).getDegree()
                                                                    , arr.get(5).getDegree()
                                                                    , arr.get(6).getDegree()
                                                                    , arr.get(7).getDegree()
                                                                    , arr.get(8).getDegree()
                                                                    , arr.get(9).getDegree()
                                                                    , arr.get(10).getDegree()
                                                                    , arr.get(11).getDegree() );
        
        fmt.format("Mau: %10s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n" , arr.get(0).getColor()
                                                                    , arr.get(1).getColor()
                                                                    , arr.get(2).getColor()
                                                                    , arr.get(3).getColor()
                                                                    , arr.get(4).getColor()
                                                                    , arr.get(5).getColor()
                                                                    , arr.get(6).getColor()
                                                                    , arr.get(7).getColor()
                                                                    , arr.get(8).getColor()
                                                                    , arr.get(9).getColor()
                                                                    , arr.get(10).getColor()
                                                                    , arr.get(11).getColor() );
        
        System.out.println(fmt);
        int count = 1;
        
        while(!unColor.isEmpty()){
            Collections.sort(unColor);
            Vertex selectedVertex = unColor.get(0);
            
            for(int color = 1; color < 5; color++){
                if(!selectedVertex.getBanned().contains(color)){
                    // to mau
                    selectedVertex.setColor(color);
                    // ha bac thanh 0
                    selectedVertex.setDegree(0);
                    // xoa khoi ArrayList
                    unColor.remove(0);
                    // cam to mau
                    ArrayList<Vertex> AdjacentVertices = selectedVertex.getAdjacentVertices();

                    for (Vertex v : AdjacentVertices) {
                            if(v.getDegree()>0){
                                v.addBannedColor(color);
                                v.setDegree(v.getDegree()-1);
                            }
                        }
                    showResult(arr, selectedVertex, count++);
                    break;
                }
            }
        }
    }
    
    private void showResult(ArrayList<Vertex> arr, Vertex selectedVertex, int lan){
        Formatter result = new Formatter();
        
        result.format("LAN %d:\n", lan);
        result.format("To mau: %s \n", selectedVertex.getState());
        result.format("====== Ha bac ====== \n");
        result.format("Dinh: %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n", "A", "C", "D", "G", "B", "H", "K", "E", "J", "L", "F", "I");
        result.format("Bac: %10s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n" , arr.get(0).getDegree()
                                                                , arr.get(1).getDegree()
                                                                , arr.get(2).getDegree()
                                                                , arr.get(3).getDegree()
                                                                , arr.get(4).getDegree()
                                                                , arr.get(5).getDegree()
                                                                , arr.get(6).getDegree()
                                                                , arr.get(7).getDegree()
                                                                , arr.get(8).getDegree()
                                                                , arr.get(9).getDegree()
                                                                , arr.get(10).getDegree()
                                                                , arr.get(11).getDegree() );

        result.format("Mau: %10s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n" , arr.get(0).getColor()
                                                                , arr.get(1).getColor()
                                                                , arr.get(2).getColor()
                                                                , arr.get(3).getColor()
                                                                , arr.get(4).getColor()
                                                                , arr.get(5).getColor()
                                                                , arr.get(6).getColor()
                                                                , arr.get(7).getColor()
                                                                , arr.get(8).getColor()
                                                                , arr.get(9).getColor()
                                                                , arr.get(10).getColor()
                                                                , arr.get(11).getColor() );

        result.format("Cam: %10s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s %9s \n" , arr.get(0).bannedColortoString()
                                                                , arr.get(1).bannedColortoString()
                                                                , arr.get(2).bannedColortoString()
                                                                , arr.get(3).bannedColortoString()
                                                                , arr.get(4).bannedColortoString()
                                                                , arr.get(5).bannedColortoString()
                                                                , arr.get(6).bannedColortoString()
                                                                , arr.get(7).bannedColortoString()
                                                                , arr.get(8).bannedColortoString()
                                                                , arr.get(9).bannedColortoString()
                                                                , arr.get(10).bannedColortoString()
                                                                , arr.get(11).bannedColortoString() );
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
        
        // set degree and add adjacentVertex
        for (int i = 0; i < vertices.size(); i++) {
            int degree=0;
            for (int j = 0; j < 12; j++) {
                if(adjacencyMatrix[i][j] == 1){
                    vertices.get(i).addAdjacentVertex(vertices.get(j));
                }
                degree += adjacencyMatrix[i][j];
            }
            vertices.get(i).setDegree(degree);
        }
        
        DSATUR test = new DSATUR();
        test.coloring(adjacencyMatrix, vertices);

    }
}
