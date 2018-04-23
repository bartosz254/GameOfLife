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
public class boardWorld  {
    
    public int rows = 10;
    public int cols = 10;
    static int tours = 0;
    private final cell c1 = new cell();
   
    
    /**
    * generate original world
    *
    * 
    */ 
    public void buildWorld(){
        c1.locateCells();
        System.out.print("\033[H\033[2J");// Simulates a clear screen on linux machines
        System.out.print("\n|#| 0||1||2||3||4||5||6||7||8||9 ");
            
                        for(int i = 0; i<cols;i++){
                            
                            System.out.print("| |\n|"+i+"|");
                            for(int j = 0; j < rows;j++){
                               if(c1.location[i][j] == true){
                                   System.out.print(" 0 ");
                               } else { System.out.print("   "); }
                            } 
                        }
            System.out.print("\n");
        System.out.print("| |\n|#| 0||1||2||3||4||5||6||7||8||9 | |\n");
    }
    
    /**
    * check cell and its neibhbours, next kill or born new cell
    *
    * 
    */ 
    public void cellNeighbour(){
        boolean[][] loc = null;
        
        for(int i = 0; i<rows;i++){
         for(int j = 0; j<cols; j++){
            int neighbours = 0;

            if(c1.location[i][j] == true){
                if(i < rows- 1 && c1.location[i+1][j] == true)                neighbours++;
                if(i > 0 && c1.location[i-1][j]==true)                        neighbours++; 
                if(j < cols-1 && c1.location[i][j+1] == true )                neighbours++;
                if(j > 0 && c1.location[i][j-1] == true)                      neighbours++;
                if(i < rows-1 && j < cols-1 && c1.location[i+1][j+1] == true) neighbours++;
                if(i > 0 && j > 0 && c1.location[i-1][j-1] == true )          neighbours++;
                if(i > 0 && j < cols-1 && c1.location[i-1][j+1] == true )     neighbours++;
                if(i < rows-1 && j > 0 && c1.location[i+1][j-1] == true )     neighbours++;

                //principle of world
                if(neighbours < 2 || neighbours > 3){
                    //kill cell
                    c1.location[i][j] = false;
                } else {
                    //generate new cell;
                    c1.bornNewCell(i,j);
                    }
                }
            }   
        }
    }
    
    /**
    * printing new board
    *
    * 
    */ 

    public void checkBoard() throws InterruptedException{
        System.out.print("\n|#| 0||1||2||3||4||5||6||7||8||9 ");            
                        for(int i = 0; i<cols;i++){
                            
                            System.out.print("| |\n|"+i+"|");
                            for(int j = 0; j <rows;j++){
                               if(c1.location[i][j] == true){
                                   System.out.print(" X ");
                               } else { System.out.print("   "); }
                            } 
                        }
                        System.out.print("\n");
        System.out.print("| | 0||1||2||3||4||5||6||7||8||9 | |\n");
        //Thread.sleep(500);
    }
}
