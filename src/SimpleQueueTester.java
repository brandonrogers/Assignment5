/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brandonrogers
 */
public class SimpleQueueTester {
    
    public static void main(String[] args) {
        
        SimpleQueue<Integer> sample = new SimpleQueue<Integer>();
        sample.add(4);
        sample.add(3);
        sample.add(1);
        sample.add(2);
        sample.add(5);
        Object[] tempObjectArray = sample.toArray();
        
        for (int i=0; i < tempObjectArray.length; i++) {
            System.out.print(tempObjectArray[i] + ", ");
        }
        sample.add(6);
        sample.add(7);
        sample.add(4);
        for (int i = 0; i < sample.size(); i++)
            System.out.print(sample.remove() + " ");
        
    }
}
