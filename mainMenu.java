import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

class mainMenu
{
   public static void main(String[] args) throws IOException
   { 
     /* Try statement to catch exception */
     try
     {
         /* Initialize Flag to control loop */
         int stillMenu = 1;
         
         /* Initialize Scanner for input */
         Scanner keyboard = new Scanner(System.in);
         
         /*
         // instantiate file object
         File file = new File("stats.txt");
       		
         // if file doesnt exists, then create it
         if(!file.exists())
       	   file.createNewFile();
       	 		
         // new fileWriter that allows file to be appended with true
          FileWriter fileWriter = new FileWriter(file.getName(),true);
       
         // new bufferedWriter for multiple writes
         BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
       
         // close the file
         bufferWriter.close();
         */
         
         /* Print the main menu system */
         /* Only Prints the menu once */
         /* Returning from game mode should not reprint menu */
           
         System.out.println("Welcome to Mastermind!");
         System.out.println("Type the following number to decide:");
         System.out.println("1:Player vs Computer");
         System.out.println("2:Computer vs Player");
         System.out.println("3:Statistics");
         System.out.println("4:Help");
         System.out.println("5:Exit");
         
         /* Loop controlling the main menu */
         /* Only accepts int 1-5, any other int is invalid */
         /* Non Int will kill program */
         
         while(stillMenu == 1)
         {   
             /* Variable to hold the user input */      
             int menuChoice = keyboard.nextInt();
             
             /* Test line */
             //System.out.println(menuChoice);
         
             if (menuChoice == 1)
             {
                /* Player v Computer */  
                //System.out.println("choice 1");
             }
             else if (menuChoice == 2)
             {
                /* Computer v Player */
                //System.out.println("Choice 2");
             }
             else if (menuChoice == 3)
             {
                /* Stat */
                //System.out.println("Choice 3");
                Stats s = new Stats();
             }
             else if (menuChoice == 4)
             {
                /* Help */
                // create new help object, launching the menu
                Help h = new Help();
             }
             else if (menuChoice == 5)
             {
                /* Exit */
                System.out.println("Thanks for Playing!");
                stillMenu = 0;
             }
             /* Statement for when the input isn't one of the choices */
             else
             {
                 /* Printed when invalid input entered */
                 System.out.println("Enter Valid Number");
                 System.out.println("");
             }
         }
     }
     
     /* Catch statement for when a string or non int input is entered */
     /* Kills program */    
     catch(java.util.InputMismatchException e)
     {
         System.out.println("dead");
     }    
   }  
}     