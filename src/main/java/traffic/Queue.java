package src.main.java.traffic;

public class Queue<T> implements QueueInterface<T>
{
    private int numberOfElements;

    private Node front;
    private Node back;
    
    public Queue()
    {

    }
    // front --> back
    
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
        Node newNode = new Node(item);

        if (back != null)
        {
            back.setNext(newNode);
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
            Node newFront = front.getNext();
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

    protected class Node
    {
        private T data; 
        private Node next;
        
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        //getData
        private T getData()
        {
            return data;
        }
        //setData
        private void setData(T data)
        {
            this.data = data;
        }
        //getNext

        private Node getNext()
        {
            return next;
        }

        //setNext 
        private void setNext(Node nextNode)
        {
            next = nextNode;
        }

    }
}

