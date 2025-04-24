package src.main.java.traffic.interfaces;

public class Node<T>
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

        //getData
        public T getData()
        {
            return data;
        }
        //setData
        private void setData(T data)
        {
            this.data = data;
        }
        //getNext

        public Node<T> getNext()
        {
            return next;
        }

        //setNext 
        public void setNext(Node<T> next)
        {
            this.next = next;
        }

    }