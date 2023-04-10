package DSATUR;

import java.util.ArrayList;

public class Vertex<T> implements Comparable<Vertex> {

    //Attribute
    private T state;
    private int color;
    private int degree;
    private ArrayList<Integer> banned;
    private ArrayList<Vertex> adjacentVertices;

    //Constructor
    public Vertex(T state) {
        this.state = state;
        this.color = 0;
        this.banned = new ArrayList<>();
        this.adjacentVertices = new ArrayList<>();
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public ArrayList<Integer> getBanned() {
        return banned;
    }

    public void setBanned(ArrayList<Integer> banned) {
        this.banned = banned;
    }

    public ArrayList<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(ArrayList<Vertex> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }


    public int getColor() {
        return color;
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
    
    public void addBannedColor(int n){
        this.banned.add(n);
    }

    public void addAdjacentVertex(Vertex v) {
        this.adjacentVertices.add(v);
        //this.setDegree(this.adjacentVertices.size());
    }

    //Methods
    @Override
    public int compareTo(Vertex v) {
        if (this.getDegree() > v.getDegree()) {
            return -1;
        } else if (this.getDegree() < v.getDegree()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public void SetupDegree(){
        this.setDegree(this.adjacentVertices.size());
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
    
    @Override
    public String toString() {
        return "";
    }
}
