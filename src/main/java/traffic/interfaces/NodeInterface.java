package src.main.java.traffic.interfaces;

public interface NodeInterface<T>
{
    public T getData();

    public void setData(T data);

    public Node<T> getNext();

    public void setNext(Node<T> next);
    
}
