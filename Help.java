import java.util.Scanner;
public class Help{
   public Help(){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Welcome to Mastermind!\n\n"+
      "--o  enter this command for an overview of the game\n"+
      "--p  enter this command for Player Mode instructions\n"+
      "--c  enter this command for Computer Mode instructions\n"+
      "--s  enter this command for details on scoring\n\n"+
      "--h  enter this command to return home\n");
      String s = keyboard.nextLine();
      DetailedHelp(s);
      
   }
   private static String DetailedHelp(String s){
      Help h;
      switch(s){
         case "--o": System.out.print("This is a software version of the\n"+
                  "code-breaking game called Mastermind from 1970,\n"+
                  "developed by Mordecai Meirowitz\n\n");
                  h = new Help();
                  break;
         case "--p": System.out.print("In Player Mode, the user makes a code\n"+
                  "and the computer attempts to break the code\nwithin 10 tries.\n\n"+
                  "To begin, the player chooses a four-pegged code for\n"+
                  "the computer to crack. There are six different colors\n"+
                  "to choose from, and repeats are allowed. The colors\n"+
                  "are: red, orange, yellow, green, blue, and purple.  The\n"+
                  "player enters the choice of colors one at a time as prompted,\n"+
                  "clicking “OK” after each entry.\n\n"+
                  "After each guess, a window will pop up telling whether the\n"+
                  "computer guessed correctly or not.\n");
                  h = new Help();
                  break;
         case "--c": System.out.print("In computer mode, the computer generates a\n"+
                  "four-pegged code and the player attempts to break it within 10 tries.\n\n"+
                  "To begin, click “Start”. In the dialog box, enter a comma-separated\n"+
                  "list of four colors and press “Guess”. This would look something like\n"+
                  "“red, blue, blue, blue” without the quotation marks. Alternatively, press\n"+
                  "“Hint” to receive a hint about the computer’s code.\n");
                  h = new Help();
                  break;            
         case "--s": System.out.print("Hi");
                  h = new Help();
                  break;
         case "--h": // print main menu options
                     System.out.println("Welcome to Mastermind!");
                     System.out.println("Type the following number to decide:");
                     System.out.println("1:Player vs Computer");
                     System.out.println("2:Computer vs Player");
                     System.out.println("3:Statistics");
                     System.out.println("4:Help");
                     System.out.println("5:Exit");
                     
                     // prepare menu for input
                     mainMenu m = new mainMenu();
                  break;
      }
      return s;  
   }
}