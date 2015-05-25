/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo22;

import Queue.Queue;

/**
 *
 * @author Theo
 */
public class Algo22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.offer("Person1");
        q.offer("Person2");
        q.offer("Person3");
        q.offer("Person4");
        System.out.println(q.toString());
        System.out.println("Removed: " + q.poll() + " | " + "Left: " + q.toString());
        System.out.println("Removed: " + q.poll() + " | " + "Left: " + q.toString());
        System.out.println("Removed: " + q.poll()+ " | " + "Left: "+ q.toString());
        System.out.println("Removed: " + q.poll()+ " | " + "Left: "+ q.toString());
        
    }

}
