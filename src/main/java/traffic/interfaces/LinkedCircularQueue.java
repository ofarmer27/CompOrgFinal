package traffic.interfaces;

public class LinkedCircularQueue<T> implements LinkedQueueInterface<T>
{
    private int numberOfElements;

    Node<T> front;
    Node<T> back;
    
    public LinkedCircularQueue()
    {

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

        if (isEmpty())
        {
            front = back = newNode;
        }
        else
        {
            back.setNext(newNode);
            back = newNode;
            back.setNext(front);;
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

    public T peekNext()
    {
        return front.getNext().getData();
    }

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

    public void printQueue()
    {
        Node<T> currentNode = front;
        
        System.out.print("head: ");
        for (int i = 0; i < numberOfElements; i++)
        {
            System.out.print(currentNode.getData());
            if (currentNode.getNext() != front) 
            {
                currentNode = currentNode.getNext();
            }
        }
        System.out.print(":tail");
        
        System.out.println();
    }

    public void cycle()
    {
        if (!isEmpty() && back != null) {
            front = front.getNext();
            back.setNext(back.getNext());
        }
    }

}

