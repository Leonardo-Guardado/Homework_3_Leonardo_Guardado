import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CSArrayListDriver {
    public static void main(String[] args) {
        Collection<String> testCollection = new CSArrayList<>();
        testCollection.add("A");
        testCollection.add("B");
        testCollection.add("C");
        testCollection.add("D");

        Iterator<String> iterator = testCollection.iterator();

        //Part B-----------------------------------------------------------------------------------
        try{                                               //Try and Catch for iteration
            //Checking if there is such thing as a next element
            for (String s : testCollection) {
                //Next element in iteration
                s = iterator.next();
                //Printing the elements added in array previously
                System.out.println("In Array: " + s);
                //Modifying list during iteration
                if(s.equals("D")){
                    //Testing different modifications for ConcurrentModificationException
                    testCollection.remove(s);
                    //testCollection.add("E");
                    //testCollection.clear();
                    //System.out.println("No Modification");
                }
            }
        }
        catch(ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException");
        }
//----------------------------------------------------------------------------------------------------------------
        System.out.println(testCollection);


        System.out.println(testCollection.size());
        System.out.println(testCollection.contains("B"));
        System.out.println(((CSArrayList<String>) testCollection).indexOf("B"));

        //Testing capacity changes
        System.out.println(((CSArrayList<String>) testCollection).capacity()); //Initial
        ((CSArrayList<String>) testCollection).trimToSize(); //Trim array into the current size
        System.out.println(((CSArrayList<String>) testCollection).capacity()); //Final
//---------------------------------------------------------------------------------------------
        //Part C Test
        System.out.println(testCollection.toString());
        Collection<String> newCollection = new CSArrayList<>();
        newCollection.add("Z");
        newCollection.add("Y");
        newCollection.add("X");
        testCollection.addAll(newCollection);
        System.out.println(testCollection);

//---------------------------------------------------------------------------------------------------------------
//Part E Micro Benchmarking

        //CSArrayList
        System.out.println("CSArrayList");
        int N = 1_000_000;
        //Initiating time
        CSArrayList<Integer> list = new CSArrayList<>();
        long t0 = System.nanoTime();
        //Appending in CSArrayList
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long t1 = System.nanoTime();
        //Getting random integer from CSArrayList
        java.util.Random r =  new java.util.Random();
        long s = 0;
        for (int i = 0; i < N; i++) {
            s += list.get(r.nextInt(N));
        }
        long t2 = System.nanoTime();
        System.out.printf("append=%.1f ms get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.println("java.util.ArrayList");
        //Initiating time
        ArrayList<Integer> b = new ArrayList<>();
        t0 = System.nanoTime();
        //Appending in ArrayList
        for (int i = 0; i < N; i++) {
            b.add(i);
        }
        t1 = System.nanoTime();
        //Getting random integer in ArrayList
        java.util.Random q =  new java.util.Random();
        long s1 = 0;
        for (int i = 0; i < N; i++) {
            s1 += b.get(q.nextInt(N));
        }
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);
    }

}


//Baseline Results: A (testCollection[0]), B (testCollection[1]), 2 (CSArrayList size), true (testCollection contains B), 1 (indexOf "B" in testCollections)
