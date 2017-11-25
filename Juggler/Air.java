/**
 * @author Wanner Guzman
 * CS310
 * Fall 2017
 */

import java.util.*; //for Queue interface

/**
 * YOUR COMMENTS HERE
 * 
 * For the Queue interface, see http://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * and http://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
 */
/**
 * Create Air class that performs the functions of quene linked list
 * @author wanner
 *
 * @param <T> generic list queue
 * for this project it will be integer
 * start the list from class
 */
class Air<T> implements Queue<T>
{
 /**
  * Wikipedia claims max solo record is 13
  * see http://en.wikipedia.org/wiki/Juggling_world_records#Solo_records
  * Allowing room for growth...
  */
 public static final int MAX_CAPACITY = 15;
 
 // add my own private variable to keep track of list size
 /**
  * 
  * @author wanner
  *
  * @param <T> generic node for linked list
  */
 private class ListItem<T>
 {
	 /**
	  * store T value
	  */
   T value;
   /**
    * link to prev node
    */
   ListItem<T> prev;
   /**
    * link to next node
    */
   ListItem<T> next;
   /**
    * constructor that starts the node with value
    * @param value
    */
   public ListItem(T value){
     this.value = value;
   }
 }
 /**
  * create private instance variables head and tail for linked list
  * size to keep track of list
  */
 private ListItem<T> head;
 private ListItem<T> tail;
 private int size = 0;
 /**
  * add the ball to the list
  * perform checks if it is empty, if bigger the max throw exception
  * else configure node.
  *true if successful add
  *@param <T>
  * @return 
  */
 public boolean add(T item){
   //if the item is null throw NullPointerException
   if(item==null){
	   throw new NullPointerException("Item is Null");
   }
   // if max_capacity balls have been thrown, no more balls left
   if(this.size>MAX_CAPACITY){
     throw new IllegalStateException("No balls left to throw");
   }
   ListItem<T> n = new ListItem<T>(item);
   //if head has not been initialized, initialize head
   if(head==null && tail==null){
     head=tail=n;
   }
   //else we are adding
   else{
     tail.prev = n;
     n.next = tail;
     tail = tail.prev;
   }
   //increment size when add is successful
   size++;
   return true;
 }
 /**
  * offer calls add and returns its return value
  * @param <T>
  * @return
  */
 public boolean offer(T item){
   return add(item);
 }
 /**
  * if ball is empty throw exception
  * the ball removed and configure linkedList
  * return ball removed
  * @return 
  * @throws
  * @exception 
  */
 public T remove(){
   //first check for exception case
   if(isEmpty()==true){
     throw new NoSuchElementException("No balls in the air to remove");
   }
   T removing = null;
   //otherwise remove
   if(size==1){
     removing = head.value;
     head=null;
     tail=null;
   }
   else{
     removing = head.value;
     head = head.prev;
     head.next=null;
   }
   //decrease size when successful
   size--;
   return removing;
 }
 /**
  * check if it is empty, return null in that case
  * else remove ball and configure linked list
  * return the ball removed, or null if nothing was removed
  * @return 
  */
 public T poll(){
      //first check for exception case
   if(isEmpty()==true){
     return null;
   }
   T removing = null;
   //otherwise remove
   if(size==1){
     removing = head.value;
     head=null;
     tail=null;
   }
   else{
     head = head.prev;
     head.next = null;
   }
   //decrease size
   size--;
   return removing;
 }
 /**
  * return the head, throw exception if no head
  *@return 
  *@throw
  *@exception 
  */
 public T element(){
   if(head==null || tail==null)throw new NoSuchElementException("queue is empty");
   else
     return head.value;
 }
 /**
  * @return return the head return null if no head
  */
 public T peek(){
   if(head==null || tail==null)return null;
   else
     return head.value;
 }
 /**
  * @return string representation of all the balls
  */
 public String toString(){
   String str = "";
   ListItem<T> temp = tail;
   while(temp!=null){
     str+=temp.value;
     temp = temp.next;
   }
   return str;
 }
 /**
  * clear list
  */
 public void clear(){
   head=tail=null;
   size = 0;
 }
 /**
  *@return true if it is empty else return false
  */
 public boolean isEmpty(){
   //if both head and tail are null its empty
   if(head==null & tail==null)return true;
   //otherwise its not
   else
     return false;
 }
 /**
  * @return the size of list
  */
 public int size(){
   return this.size;
 }
 /**
  * @return and array representation of linked list
  */
 public Object[] toArray(){
   ListItem<T> temp = tail;
   Object[] a = new Object[size];
   for(int i=0;i<size;i++){
     a[i] = temp.value;
     temp = temp.next;
   }
   return a;
 }
 
 
 /*-------------- DO NOT CHANGE ANYTHING BELOW THIS LINE --------------*/
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean addAll(Collection<? extends T> c)  
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean contains(Object o)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean containsAll(Collection<?> c)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean equals(Object o)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public int hashCode()
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public Iterator<T> iterator()
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean remove(Object o)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean removeAll(Collection<?> c)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public boolean retainAll(Collection<?> c)
 {
  throw new UnsupportedOperationException();
 }
 
 /**
  * DO NOT CHANGE THIS, no comment needed
  */
 public <E> E[] toArray(E[] a)
 {
  throw new UnsupportedOperationException();
 }
}
