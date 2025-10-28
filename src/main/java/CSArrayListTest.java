import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CSArrayListTest {
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
                    testCollection.remove("D");
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

        System.out.println(testCollection.toString());
        Collection<String> newCollection = new CSArrayList<>();
        newCollection.add("Z");
        newCollection.add("Y");
        newCollection.add("X");
        testCollection.addAll(newCollection);
        System.out.println(testCollection);

    }
}
//Baseline Results: A (testCollection[0]), B (testCollection[1]), 2 (CSArrayList size), true (testCollection contains B), 1 (indexOf "B" in testCollections)
