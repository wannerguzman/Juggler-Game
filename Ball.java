/**
 * @author Wanner Guzman
 * CS310
 * Fall 2017
 * Start Ball class
 */

class Ball
{
	/**
	 * private in number to keep track of number of ball
	 */
  private int number;
  /**
   * constructor to start the ball
   * @param number
   */
  public Ball(int number){
    this.number = number;
  }
  /**
   * toString method to print the ball (#)
   * @return string
   */
  public String toString(){
    String str = "("+number+")";
    return str;
  }
  /**
   * method that returns the number of the ball
   * @return number
   */
  public int getNumber(){
    return number;
  }
  
}