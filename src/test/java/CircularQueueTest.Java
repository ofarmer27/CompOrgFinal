package src.test.java;



public class CircularQueueTest
{
    CircularQueue<Character> myQueue;

     public CircularQueueTest()
     {
        myQueue = new Queue<Character>();
        runCircularQueueTests();

     }

     private Boolean enqueueTest()
     {
        myQueue.enqueue('a');
        myQueue.enqueue('b');
        myQueue.enqueue('c');
        myQueue.enqueue('d');
        myQueue.enqueue('e');

        // should now be ABCDE
     }
     
     private Boolean dequeueTest()
     {
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();

        // should now be CDE

     }

     private Boolean peekTest()
     {
        myQueue.peek();
        //should be C
     }

     privateBoolean isEmptyTest()
     {

     }

     public Boolean runCircularQueueTests()
     {
        enqueueTest();
        dequeueTest();
        peekTest()


     }
}

}