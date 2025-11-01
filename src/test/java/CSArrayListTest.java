import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CSArrayListTest {

    @Test
    @DisplayName("Remove Element from Array")
    void remove() {
        //Arrange
        Collection<String> testRemove = new CSArrayList<>();
        testRemove.add("A");
        testRemove.add("B");
        testRemove.add("C");
        testRemove.add("D");
        //Act
        testRemove.remove("C");
        //Assert
        assertEquals(3, testRemove.size());
        assertFalse(testRemove.contains("C"));

    }

    @Test
    @DisplayName("Head_Tail_Middle")
    void addElement() {
        //Arrange
        Collection<String> testInsert = new CSArrayList<>();
        testInsert.add("B");                                               // [B]
        testInsert.add("C");                                               // [B, C]
        //Act
        ((CSArrayList<String>) testInsert).add(1, "A");      // [B, A, C]
        ((CSArrayList<String>) testInsert).add(0, "D");      // [D, B, A, C]
        ((CSArrayList<String>) testInsert).add(3, "E");      // [D, B, A, E, C]
        //Assert
        assertAll(
                () -> assertEquals(5, testInsert.size()),
                () -> assertTrue(((CSArrayList<String>) testInsert).indexOf("D") == 0),
                () -> assertTrue(((CSArrayList<String>) testInsert).indexOf("B") == 1),
                () -> assertTrue(((CSArrayList<String>) testInsert).indexOf("A") == 2),
                () -> assertTrue(((CSArrayList<String>) testInsert).indexOf("E") == 3),
                () -> assertTrue(((CSArrayList<String>) testInsert).indexOf("C") == 4)
        );
    }

    @Test
    @DisplayName("Finding Set Amount of Duplicates in Array")
    void searchDuplicates(){
        //Arrange
        Collection<String> testSearch = new CSArrayList<>();
        testSearch.add("A");
        testSearch.add("B");
        testSearch.add("C");
        testSearch.add("B");
        //Act
        int i = 0;
        Collection<String> testDuplicates = new CSArrayList<>();
        while(i < testSearch.size()){
            if (((CSArrayList<String>) testSearch).get(i).equals("B")){
                testDuplicates.add("B");
            }
            i++;
        }
        //Assert
        assertEquals(2, testDuplicates.size());
    }

    @Test
    @DisplayName("Iterator Check")
    void iteratorCheck(){
        //Arrange
        Collection<String> start = new CSArrayList<>();
        start.add("A");
        start.add("B");
        start.add("C");
        start.add("D");

        Iterator<String> testIterator = start.iterator();
        //Act
        assertThrows(ConcurrentModificationException.class, () -> {
            while (testIterator.hasNext()){
                String s = testIterator.next();
                if (s.equals("D")){
                    start.remove("D");
                }
            }
        });
    }

    @Test
    @DisplayName("Size Changes")
    void sizeChange1() {
        //Arrange
        Collection<String> a = new CSArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        //Assert first size
        assertEquals(3, a.size());

        Collection<String> b = new CSArrayList<>();
        b.add("Z");
        b.add("Y");
        b.add("X");
        b.add("W");

        //Act 1
        a.addAll(b);
        //Assert second size
        assertEquals(7, a.size());

        //Act 2
        a.clear();
        //Assert third size
        assertEquals(0, a.size());

    }
}