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
        //catch ConcurrentModificationException from iterator change
        catch(ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException");
        }
//----------------------------------------------------------------------------------------------------------------
        System.out.println(testCollection);


        System.out.println("Size of arraylist: " + testCollection.size());
        System.out.println("Contains element (B): " + testCollection.contains("B"));
        System.out.println("Index of element (B): " + ((CSArrayList<String>) testCollection).indexOf("B"));

        //Testing capacity changes
        ((CSArrayList<String>) testCollection).ensureCapacity(10); //Ensure that capacity is at 10
        System.out.println("Initial Capacity: " + ((CSArrayList<String>) testCollection).capacity()); //Initial
        ((CSArrayList<String>) testCollection).trimToSize(); //Trim array into the current size
        System.out.println("Capacity after trim: " + ((CSArrayList<String>) testCollection).capacity()); //Final
//---------------------------------------------------------------------------------------------
        //Part C Test
        System.out.println(testCollection.toString());          //Making original array as a string
        Collection<String> newCollection = new CSArrayList<>(); //Creating new arraylist
        newCollection.add("Z");                                 //Adding new elements to new arraylist
        newCollection.add("Y");
        newCollection.add("X");
        testCollection.addAll(newCollection);                          //Using addAll method
        System.out.println("Array after adAll: " + testCollection);    //[A,B,C,Z,Y,X] <- Final after method

//---------------------------------------------------------------------------------------------------------------
//Part E Micro Benchmarking

        //Start Benchmarking, with 1,000,000 Elements
        //CSArrayList
        System.out.println("\n1,000,000 Elements");
        System.out.print("CSArrayList: ");
        int N = 1_000_000;
        //Initiating time
        CSArrayList<Integer> a = new CSArrayList<>();
        long t0 = System.nanoTime();
        //Appending in CSArrayList
        for (int i = 0; i < N; i++) a.add(i);
        long t1 = System.nanoTime();
        //Getting random integer from CSArrayList
        java.util.Random r =  new java.util.Random();
        long s = 0;
        for (int i = 0; i < N; i++) s += a.get(r.nextInt(N));
        //Getting second nanotime
        long t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.print("java.util.ArrayList: ");
        //Initiating time
        ArrayList<Integer> b = new ArrayList<>();
        t0 = System.nanoTime();
        //Appending in ArrayList
        for (int i = 0; i < N; i++) b.add(i);
        t1 = System.nanoTime();
        //Getting random integer in ArrayList
        r =  new java.util.Random();
        long s1 = 0;
        for (int i = 0; i < N; i++) s1 += b.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        // Same process but 750,000 elements
        //CSArrayList
        System.out.println("\n750,000 Elements");
        N = 750_000;
        System.out.print("CSArrayList: ");
        CSArrayList<Integer> a2 = new CSArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) a2.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s = 0;
        for (int i = 0; i < N; i++) s += a2.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.print("java.util.ArrayList: ");
        ArrayList<Integer> b2 = new ArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) b2.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s1 = 0;
        for (int i = 0; i < N; i++) s1 += b2.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //500,000 Elements
        //CSArrayList
        System.out.println("\n500,000 Elements");
        N = 500_000;
        System.out.print("CSArrayList: ");
        CSArrayList<Integer> a3 = new CSArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) a3.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s = 0;
        for (int i = 0; i < N; i++) s += a3.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.print("java.util.ArrayList: ");
        ArrayList<Integer> b3 = new ArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) b3.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s1 = 0;
        for (int i = 0; i < N; i++) s1 += b3.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //250,000 Elements
        //CSArrayList
        System.out.println("\n250,000 Elements");
        N = 250_000;
        System.out.print("CSArrayList: ");
        CSArrayList<Integer> a4 = new CSArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) a4.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s = 0;
        for (int i = 0; i < N; i++) s += a4.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.print("java.util.ArrayList: ");
        ArrayList<Integer> b4 = new ArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) b4.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s1 = 0;
        for (int i = 0; i < N; i++) s1 += b4.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //100,000 Elements
        //CSArrayList
        System.out.println("\n100,000 Elements");
        N = 100_000;
        System.out.print("CSArrayList: ");
        CSArrayList<Integer> a5 = new CSArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) a5.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s = 0;
        for (int i = 0; i < N; i++) s += a5.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);

        //java.util.ArrayList
        System.out.print("java.util.ArrayList: ");
        ArrayList<Integer> b5 = new ArrayList<>();
        t0 = System.nanoTime();
        for (int i = 0; i < N; i++) b5.add(i);
        t1 = System.nanoTime();
        r =  new java.util.Random();
        s1 = 0;
        for (int i = 0; i < N; i++) s1 += b5.get(r.nextInt(N));
        t2 = System.nanoTime();
        System.out.printf("append=%.1f ms, get=%.1f ms\n", (t1-t0)/1e6,  (t2-t1)/1e6);
    }

}


//Baseline Results: A (testCollection[0]), B (testCollection[1]), 2 (CSArrayList size), true (testCollection contains B), 1 (indexOf "B" in testCollections)
