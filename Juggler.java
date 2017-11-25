/**
 * @author Wanner Guzman
 * CS310
 * Fall 2017
 */
import java.util.*;

/**
 * class jugglar with an inner class hand, that will perform most of the functionalities
 * @author wanner
 *functionalities throw, catch, pass, throws exceptions when it can't be performed
 */
class Juggler
{
 /**
  * private class hand for jugglar
  * @author wanner
  *
  */
 private class Hand
 {
  //you code here - variables, required methods, etc.
	 /**
	  * private variable ball, that will be used to store ball
	  */
   private Ball ball = null;
   /**
    * method to catch ball only if it has no ball else throw exception
    * @param ball
    * @throws
    * @exception
    */
   public void catchBall(Ball ball){
     if(this.ball==null){
       this.ball = ball;
     }
     else{
       throw new RuntimeException("Hand is full");
     }
   }
   /**
    * throw the ball, by removing current ball and setting it to null, if its null/empty throw exception
    * @return the ball that was thrown
    * @throws
    * @exception
    */
   public Ball throwBall(){
     if(this.ball==null){
       throw new RuntimeException("Hand is empty");
     }
     else{
       //create a copy to return
       Ball thrown = new Ball(this.ball.getNumber());
       //update current ball to null because there will be known after thrown
       this.ball=null;
       return thrown;
     }
   }
   /**
    * check if the hand has a ball
    * @return false if ball is null/empty else return true
    */
   public boolean hasBall(){
     if(this.ball==null){
       return false;
     }
     else{
       return true;
     }
   }
   /**
    *@return a to string representation of ball
    */
   public String toString(){
     if(this.ball==null){
       return("   ");
     }
     else{
       return(ball.toString());
     }
   }
 }
 
 /*-------------- DO NOT CHANGE ANYTHING BELOW THIS LINE --------------*/
 
 /**
  * create instance variable air to store balls in the air
  */
 private Air<Ball> air = new Air<>();
 
 /**
  * create instance variable hands, we will have two for catching balls and passing
  */
 private Hand[] hands = new Hand[2];
 
 /**
  * keep track of numUnthrownBalls privatly
  */
 private int numUnthrownBalls;
 
 /**
  * keep track of totalballs
  */
 private int totalBalls;
 
 /**
  * constructor that inializes hand and total number of balls
  */
 public Juggler()
 {
  hands[0] = new Hand();
  hands[1] = new Hand();
  this.totalBalls = this.numUnthrownBalls = 5; //((new Random()).nextInt(5))+3;
 }
 
 /**
  * pass the ball by calling hand catchball method
  */
 public void passBall()
 {
  hands[0].catchBall(hands[1].throwBall());
 }
 
 /**
  * throw ball to air if no ball in left had, if ball in left hand throw ball from hand
  */
 public void throwBall()
 {
  if(!hands[0].hasBall() && this.numUnthrownBalls > 0)
   air.add(new Ball(this.numUnthrownBalls--));
  else
   air.add(hands[0].throwBall());
 }
 
 /**
  * catch the ball by calling hand catchball method
  */
 public void catchBall()
 {
  hands[1].catchBall(air.remove());
 }
 
 /**
  * getter that gets number of unthrown balls
  * @return from variavle numUnthrownBalls
  */
 public int getNumUnthrownBalls()
 {
  return this.numUnthrownBalls;
 }
 
 /**
  * 
  * @return tostring to create hand balls everthing else
  */
 public String toString()
 {
  String spacing = "";
  if(this.totalBalls < 7) spacing += "   ";
  if(this.totalBalls < 5) spacing += "   ";
  
  return spacing + air.toString() + "\n\n      "
   + hands[0].toString() + "( )" + hands[1].toString() + "\n   "
   + "    \\__|__/\n   "
   + ((this.numUnthrownBalls > 6) ? "(7)" : "   ")
   + ((this.numUnthrownBalls > 5) ? "(6)" : "   ")
   + " |\n   "
   + ((this.numUnthrownBalls > 4) ? "(5)" : "   ")
   + ((this.numUnthrownBalls > 3) ? "(4)" : "   ")
   + " |\n   "
   + ((this.numUnthrownBalls > 2) ? "(3)" : "   ")
   + ((this.numUnthrownBalls > 1) ? "(2)" : "   ")
   + "/ \\\n   " 
   + ((this.numUnthrownBalls > 0) ? "(1)" : "   ")
   + "  /   \\\n";
 }
}