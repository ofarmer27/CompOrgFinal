package traffic.interfaces;

public interface NodeInterface<T>
{

    /* 
     * @returns the dataPortion field of the Node
     */
    public T getData();


    /* 
     * Sets dataportion field to data
     * 
     * @param data that you wish to set.
     */
    public void setData(T data);

    /* 
     * @returns node at next refernence
     */
    public Node<T> getNext();

    /* 
     * @param next represents desired next reference for current node
     */
    public void setNext(Node<T> next);
    
}
