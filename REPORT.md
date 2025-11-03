**Complexity Summary**
- add(E e): O(1)
- add(int index, E e): O(n)
- get(int index): O(1)
- set(int index, E newValue): O(1)
- remove(int index): O(n)
- reallocate(): O(n)
- indexOf(Object item): O(n)
- toString(): O(n)
- clear(): O(n)
- isEmpty(): O(1)
- remove(Object o): O(n)
- ensureCapacity(int minCapacity): O(n) if needed, O(1) if not
- trimToSize(): O(n)
- addAll(int index, Collection<? extends E> c): O(m + n)

**Design Decisions**
- I used CSArrayListDriver class to test different methods that I have made in the class CSArrayList
- I separated all of the added methods from the setted methods of the homework using comments with dashes (//---------)
- Tests using JUnit were more simple than usual to test out simple outcomes
- Remove(Object o) was made by combining remove(int index) and indexOf(Object o) = remove(indexOf(Object o))
- toString() uses a StringBuilder so that the entire string would be made easier

**Pitfalls**
- Iterators took a while for me to fully understand, from the modCounts and also from implementing them into my code since I couldn't really figure out how to track it
- I messed up on the remove(Object o) function at first by changing all objects in the array into null, which led to the array lowering its size but the same number of elements was in it, which led to errors. 
- addAll() was very confusing for me of how to implement it, until I realized that I just needed to use the System.arraycopy() method to actually combine arrays
- At the start of using JUnit, I have struggled a lot in the beginning because I was very confused of how to get it started and how to prepare the pox.xml file into allowing JUnit to be used

**BenchMark Tests**
* Append
| (CSArrayList) | (java.util.ArrayList) |
|---------------|-----------------------|
|   29.8 ms     |    127.9 ms           |
|   20.7 ms     |     84.1 ms           |
|   20.3 ms     |     80.7 ms           |
|   19.4 ms     |     83.4 ms           |

* Get Random Integer
| (CSArrayList) | (java.util.ArrayList) |
|---------------|-----------------------|
|   71.9 ms     |     63.2 ms           |
|   85.1 ms     |     69.2 ms           |
|   69.8 ms     |     81.4 ms           |
|   77.4 ms     |     71.3 ms           |
