package src.main.java.traffic.interfaces;

public class CircularQueue<T> implements QueueInterface<T>
{
    public Boolean isCircularBoolean; 
    private int numberOfElements;

    protected Node<T> front;
    protected Node<T> back;
    
    public CircularQueue(Boolean isCircularBoolean)
    {
        this.isCircularBoolean = isCircularBoolean; 
    }
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
            back.setNext(front); // set new back node next reference to front

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
            else
            {
                back.setNext(front);
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

    public void cycle()
    {
        if (isCircularBoolean == true)
        {
            if (!isEmpty() && back != null) {
                front = front.getNext();
                back.setNext(back.getNext().getNext());
            }
        }
        else
        {
            System.out.println("");
        }
        
    }

}

