/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;


/**
 *
 * @author Bartosz
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        boardWorld game = new boardWorld();
        game.buildWorld();
        for(int r = 0; r <100;r++){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        game.cellNeighbour();
        game.checkBoard();
         Thread.sleep(100);
    }
    }
  
    
    
}
