package traffic.interfaces;

public class Node<T> implements NodeInterface<T>
    {
        public T data; 
        public Node<T> next;
        
        public Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        public Node(T dataPortion, Node<T> next)
        {
            setData(dataPortion);
            this.next = next;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }


        public Node<T> getNext()
        {
            return next;
        }


        public void setNext(Node<T> next)
        {
            this.next = next;
        }

    }