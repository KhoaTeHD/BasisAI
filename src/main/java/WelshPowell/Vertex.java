
package WelshPowell;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> implements Comparable<Vertex> {
    
    private int color;
    private int degree;
    private T state;
    private ArrayList<Integer> banned ;
    private ArrayList<Vertex> adjacentVertices;
    
    public Vertex(){
    }
    
    public Vertex(T state){
        this.state = state;        
        this.color = 0;
        this.banned = new ArrayList<>();
        this.adjacentVertices = new ArrayList<>();
    }
    
    public void addBannedColor(int n){
        this.banned.add(n);
    }
    
    public void addAdjacentVertex(Vertex v){
        this.adjacentVertices.add(v);
    }

    public ArrayList<Integer> getBanned() {
        return banned;
    }

    public ArrayList<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(ArrayList<Vertex> adjcentVertices) {
        this.adjacentVertices = adjcentVertices;
    }

    public void setBanned(ArrayList<Integer> banned) {
        this.banned = banned;
    }
    
    public T getState(){
        return state;
    }        
    
    @Override
    public String toString(){
        return state.toString();
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.getDegree() < o.getDegree())
            return 1;
        else if(this.getDegree() > o.getDegree())
            return -1;
        else 
            return 0;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    
    public String bannedColortoString() {
        if (banned.isEmpty())
            return "0";

        StringBuilder sb = new StringBuilder();
        for (int i : banned) {
            sb.append("-");
            sb.append(i);
            if(i != banned.get(banned.size()-1))
                sb.append(',');
        }
        return sb.toString();
    }
}
