
/**
 * @author Wanner Guzman
 * CS310
 * Fall 2017
 */
 
import java.util.*;

/**
 * 
 */
class Test
{
 /**
  * @param main program
  * @exception
  * @catch all exceptions
  * print the introduction of the game
  */
 public static void main(String[] args)
 {
  Juggler stephen = new Juggler();
  System.out.println("\nStephen, the juggler, is learning to do a shower trick...");
  System.out.println("He has " + stephen.getNumUnthrownBalls() + " balls");
  System.out.println(stephen);
  //create int x and new scanner to scan user input
  int x = 0;
  Scanner sc = new Scanner(System.in);
  while(x!=4){
	  //print the jugglar 
    if(x>0 & x<5)System.out.println(stephen);
    x = Test.doMenu(sc);
    //Invalid input if 0 or greater then 4 or letter.
    if(x==0 || x>4){
      System.out.println("Invalid selection");
    }
    //case for when input is 1
    else if(x==1){
      try{
        stephen.throwBall();
      }
      catch(Exception e)
      {
        stephen = new Juggler();
        System.out.println("Not enough balls!");
        System.out.println("Stephen dropped everything.");
        System.out.println("Stephen wants to try again...\nHe has " + stephen.getNumUnthrownBalls() + " balls");
        //stephen.clear();
      }
    }
    //case for when input is 2
    else if(x==2){
      try{
        stephen.passBall();
      }
      catch(Exception e)
      {
        stephen = new Juggler();
        System.out.println("Too many Balls!");
        System.out.println("Stephen dropped everything.");
        System.out.println("Stephen wants to try again...\nHe has " + stephen.getNumUnthrownBalls() + " balls");
        //stephen.clear();
      }
    }
    //case for when input is 3
    else if(x==3){
      try{
        stephen.catchBall();
      }
      catch(Exception e)
      {
        stephen = new Juggler();
        System.out.println("Not enough items!");
        System.out.println("Stephen dropped everything.");
        System.out.println("Stephen wants to try again...\nHe has " + stephen.getNumUnthrownBalls() + " balls");
        //stephen.clear();
      }
    }
    sc.nextLine();
  };//if it for then the game ends
  return;
 }
 
 /**
  * Print the following to ask user what action he wants to take
  * @param part of the main program
  * @return the input from the user and convert it into an int
  * if it could not be converted to int return 0, later throw invalid input to user
  * @exception
  */
 public static int doMenu(Scanner in)
 {
  System.out.println("\nStephen can:");
  System.out.println("1) Throw a ball into the air");
  System.out.println("2) Pass a ball between hands");
  System.out.println("3) Catch a ball from the air");
  System.out.println("4) Quit");
  System.out.print("\nWhat should he do? ");
  
  //your code here
  int input = 0;
  try{
    input = in.nextInt();
  }
  catch(Exception e)
  {
    //keep input as 0 which will denote its an invalid input
    input = 0;
  }
  return input;
 }
}
