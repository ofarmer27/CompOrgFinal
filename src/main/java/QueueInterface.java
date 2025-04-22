package src.main.java;

public interface QueueInterface<T>
{
    /* 
     * checks if the queue is empty
     * @returns true if queue is empty, otherwise false
     */
    public boolean isEmpty();

    /*  
     * adds a node to the back of the queue
     * updates back to be newNode
     * Sets new Node next reference to the former back
     * @Param item is the node that you wish to enquue
    */
    public void enqueue(T item);
    
    /*  
     * removes item from front and returns it
     * @returns item removed from the front
    */
    public T dequeue();

    /* 
     * view first item in list without making changes
     * @returns front of queue node
     */
    public T peek();

    public T getFront();

    public T getBack();
    
}
