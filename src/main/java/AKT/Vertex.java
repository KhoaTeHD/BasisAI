package AKT;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {

    private State state;
    private Vertex parent;
    private int g;  
    private int h;  
    private int f;
    private ArrayList<Vertex> adjacentVertices;

    public Vertex() {}

    public Vertex(State state){
        this.state = state;
        this.parent = null;
        //this.adjacentVertices = new ArrayList<>();
    }

    public State getState() {
	    return state;
}

    public void setState(State state) {
	    this.state = state;
    }
    
    public Vertex goTop(){
	return new Vertex(state.goTop());
    }
    
    public Vertex goBottom(){
	return new Vertex(state.goBottom());
    }
    
    public Vertex goLeft(){
	return new Vertex(state.goLeft());
    }
    
    public Vertex goRight(){
	return new Vertex(state.goRight());
    }

    public ArrayList<Vertex> getAdjacentVertices() {
	    return adjacentVertices;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public int getF() {
        return f;
    }
    
    public void setF(int f) {
        this.f = f;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return this.state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Vertex v = (Vertex) obj;        
        
	if (!(v instanceof Vertex))
            return false;	
        
        return (this.state.equals(v.getState()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), parent);
    }

    public Path tracePath(){
        Path<Vertex> path = new Path();
        Vertex v = new Vertex();

        v = this;

        while (v != null){
            path.addVertex(v);
            v = v.getParent();
        }

        return path;
    }

    @Override
    public int compareTo(Vertex v) {
        if (this.getF() > v.getF())
            return 1;
        else if (this.getF() < v.getF())
            return -1;
        else
            return 0;
    }
}
