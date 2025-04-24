package src.main.java.traffic.interfaces;

public class Queue<T> implements QueueInterface<T>
{
    private int numberOfElements;

    protected Node<T> front;
    protected Node<T> back;
    // front --> element --> back
    
    public boolean isEmpty()
    {
        boolean isEmpty; 
        if (front == null)
        {
            isEmpty = true;
        }
        else
        {
            isEmpty = false;
        }

        return isEmpty;
    }

    public void enqueue(T item)
    {
        Node<T> newNode = new Node<T>(item);

        if (back != null)
        {
            back.setNext(newNode); // set back node next reference to the new node
            back = newNode;
        }
        else if (back == null)
        {
            front = back = newNode;
        }

        numberOfElements++;
    }

    public T dequeue()
    {
        T removedValue;
        
        if (isEmpty())
        {
            removedValue = null;
        }
        else
        {
            removedValue = front.getData();
            Node<T> newFront = front.getNext();
            front.setNext(null);
            front = newFront;
            if (isEmpty())
            {
                back = null;
            }
            numberOfElements--;
        }
        
        
        return removedValue;
    }
    
    public T peek()
    {
        return front.getData();
    }

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

}

