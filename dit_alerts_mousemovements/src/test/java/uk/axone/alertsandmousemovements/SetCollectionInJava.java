package uk.axone.alertsandmousemovements;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Karthik.Gandhinathan
 */
public class SetCollectionInJava {


    @Test
    public void testSetCollection(){
        //1. How to create a set collection
        Set<String> fruitset = new HashSet<>();

        //2. How to add elements
        fruitset.add("Apple");
        fruitset.add("Raspberry");
        fruitset.add("Orange");
        fruitset.add("Banana");
        fruitset.add("Banana");
        fruitset.add("Banana");

        //3. how to fetch the size of the collection
        System.out.println("Size is: "+fruitset.size());

        //4. How to iterate the elements
        Iterator<String> itr = fruitset.iterator();

/*
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
*/
        while (itr.hasNext()){
            System.out.println(itr.next());
        }


    }

}
