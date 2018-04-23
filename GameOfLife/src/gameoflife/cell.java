/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Bartosz
 */
public class cell {
    
    public int population = 50;
    public boolean[][] location = new boolean[10][10];
    private int randomNum; 
    
    public cell(){};
    
    public void locateCells(){
        int lifes = 0;
        for (boolean[] location1 : location) {
            for (int j = 0; j < location1.length; j++) {
                randomNum = ThreadLocalRandom.current().nextInt(0, 10);
                if (randomNum%2 == 1 && lifes < population) {
                    location1[j] = true;
                    lifes++;
                } else {
                    location1[j] = false;
                }
            } 
        }
    }
    
    public void bornNewCell(int a, int b){
       
        
        /**
        * class of coordinates for the arrayList
        *
        * 
        */ 
        class Coords  {
            int x = a;
            int y = b;
            
            public Coords(int x, int y) {
                this.x = x;
                this.y = y;
            }
            public int getCoordsX() {
                return x;
            }
            public int getCoordsY() {
                return y;
            }
            public void setX(int x) {
                this.x = x;
            }
            public void setY(int Y) {
                this.y = y;
            }	
        }
        
        ArrayList<Coords> lista = new ArrayList<>();
        


        /**
        * count numbers of free neighbours pool
        *
        * 
        */
        Random randomGenerator =  new Random();
        int x = a; int y = b;

            if(x < location.length- 1 && location[x+1][y] == false)                                 lista.add(new Coords(x+1,y));
            if(x > 0 && location[x-1][y] == false)                                                  lista.add(new Coords(x-1,y));
            if(y < location[x].length-1 && location[x][y+1] == false )                              lista.add(new Coords(x,y+1));
            if(y > 0 && location[x][y-1] == false)                                                  lista.add(new Coords(x,y-1));
            if(x < location.length-1 && y < location[x].length-1 && location[x+1][y+1] == false)    lista.add(new Coords(x+1,y+1));
            if(x > 0 && y > 0 && location[x-1][y-1] == false )                                      lista.add(new Coords(x-1,y-1));
            if(x > 0 && y < location[x].length-1 && location[x-1][y+1] == false )                   lista.add(new Coords(x-1,y+1));
            if(x < location.length-1 && y > 0 && location[x+1][y-1] == false )                      lista.add(new Coords(x+1,y-1));
        
        /**
        * numbers of free neighbour pool
        *
        *@see java.util.ArrayList;
        *@see java.util.Random;
        *@see java.util.concurrent.ThreadLocalRandom;
        */
        int index=0;
              if(lista.size()>0){
                  ThreadLocalRandom.current().nextInt(0, lista.size());
                  location[lista.get(index).getCoordsX()][lista.get(index).getCoordsY()] = true;
              } 
    } 
}
