package org.example.arrays;
public class Chessboard
{
   public void printChessBoard(int side){
      /*
      Write a function that prints a chessboard pattern, with "W" being white
square and "B" being black. 
      - Input is an integer that is the number of squares
on the board. 
      - Output is 2D char array (printed), no need to use extra space. 
      
      BF:
      - loop for i = 1 to side * side times strat printing a 'W' on first line and then 
      - swithc flag to print B and alternate.  Use System.out.print(). when number i dividible by side, print the 
      - letter first, and then do System.out.println()
      */
      boolean printW = true;
      for(int i = 1; i <= side * side; i++)
      {
         // will execute once per i
         if(printW)
         {
            System.out.print("W");
         }
         else 
         {
            System.out.print("B");
         }
         printW = !printW;
         // will execute once per line ; 
         if(i % side == 0) // this just tells us that we have reached then end of the line 
         {
            // undo printW to print the same char on next line if side or i is even 
            if(side % 2 == 0)
            {
               printW = !printW;
            }
            System.out.println();
         }
      }
       
   }

}