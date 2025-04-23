package src.main.java;

import src.main.java.traffic.;

public class Driver
{
    public static void main(String[] args)
    {
        Queue<Character> myTrafficQueue = new Queue<Character>();
        
        myTrafficQueue.enqueue('a');
        myTrafficQueue.enqueue('b');
        myTrafficQueue.enqueue('c');

        System.out.println(myTrafficQueue.peek());
        System.out.println(myTrafficQueue.getBack());
        System.out.println(myTrafficQueue.getFront());



    }
}