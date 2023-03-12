package AKT;

import TwoWaterJug.*;
import java.util.List;

public class State {

    private int[][] arr;  
    
    public State(){
        this.arr = new int[3][3];
    }
    
    public State(int[][] arr){
        this.arr = arr;
    }
    
    public int[][] getArr(){
        return this.arr;
    }
    
    public State goTop() {
        int[][] newArr = this.copyArr();
        outerLoop:
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr.length; j++) {
                if(newArr[i][j] == 0){
                    if(i == 0) {
                        break outerLoop;
                    } else {
                        newArr[i][j] = newArr[i-1][j];
                        newArr[i-1][j] = 0;
                        break outerLoop;
                    }
                }
            }
        }
        return new State(newArr);
    }
    
    public State goBottom() {
        int[][] newArr = this.copyArr();
        outerLoop:
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr.length; j++) {
                if(newArr[i][j] == 0){
                    if(i == newArr.length - 1) {
                        break outerLoop;
                    } else {
                        newArr[i][j] = newArr[i+1][j];
                        newArr[i+1][j] = 0;
                        break outerLoop;
                    }
                }
            }
        }
        return new State(newArr);
    }
    
    public State goLeft() {
        int[][] newArr = this.copyArr();
        outerLoop:
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr.length; j++) {
                if(newArr[i][j] == 0){
                    if(j == 0) {
                        break outerLoop;
                    } else {
                        newArr[i][j] = newArr[i][j-1];
                        newArr[i][j-1] = 0;
                        break outerLoop;
                    }
                }
            }
        }
        return new State(newArr);
    }
    
    public State goRight() {
        int[][] newArr = this.copyArr();
        outerLoop:
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr.length; j++) {
                if(newArr[i][j] == 0){
                    if(j == newArr.length - 1) {
                        break outerLoop;
                    } else {
                        newArr[i][j] = newArr[i][j+1];
                        newArr[i][j+1] = 0;
                        break outerLoop;
                    }
                }
            }
        }
        return new State(newArr);
    }
    
    private int[][] copyArr() {
        int[][] newArr = new int[this.arr[0].length][this.arr[0].length];
        for(int i = 0; i < this.arr[0].length; i++) {
            for(int j = 0; j < this.arr[0].length; j++) {
                newArr[i][j] = this.arr[i][j];
            }
        }
        return newArr;
    }
    
    @Override
    public boolean equals(Object obj) {
        State s = (State) obj;        
        for(int i = 0; i < s.getArr().length; i++) {
            for(int j = 0; j < s.getArr()[i].length; j++) {
                if(s.getArr()[i][j] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        for (int[] row : arr) {
            for(int data : row){
                System.out.print(data + " ");
            }
            System.out.println(""); // xuống dòng
        }
        //System.out.println("--------------");
        return "";
    }
}
