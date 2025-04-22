package src.main.java;

public class Queue<T> implements QueueInterface<T>
{
    private int numberOfElements;

    public Node front;
    public Node back;
    
    // X <-- Y <-- Z
    
    public Queue()
    {
        front = new Node(null);
        back = new Node(null);
        front.setNext(null);
        back.setNext(front);
    }
    
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

        newNode.setNext(back);
        back = newNode;
        front.setNext(back);
    
        numberOfElements++;
    }

    public T dequeue()
    {
        T value;
        
        if (isEmpty())
        {
            value = null; 
        }
        else
        {
            value = front.getData();
            Node newFront = front.getNext();
            front.setNext(null);
            front = newFront;
            front.setNext(back);
        }
        
        numberOfElements--;
        return value;
    }
    
    public T peek()
    {
        return front.getData();
    }

    public T getFront()
    {
        return front.getData();
    }

    public T getBack()
    {
        return back.getData();
    }


    public

    private class Node
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

