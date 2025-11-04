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
- Benchmarking was pretty inconsistent since it gave me drastic differences between the two arraylists in the append section when the number of elements have the portion 50,000 on it (Ex: 250,000; 750,000; etc) but they have closer times when they are multiples of 100,000 (Ex: 100,000; 500,000; etc.). This really confused me but I believe this could be an outcome based on my laptop and its specs which could play a part in these different nano times.

**BenchMark Tests**
<br/>
*1st Test*<br/>
(Append)
| # Elements | (CSArrayList) | (java.util.ArrayList) |                  
| ---------- | ------------- | --------------------- |
|  1,000,000 |   29.1 ms     |    106.2 ms           |
|   750,000  |   36.5 ms     |     64.3 ms           |
|   500,000  |   22.6 ms     |     20.1 ms           |
|   250,000  |   43.0 ms     |     24.2 ms           |
|   100,000  |    1.6 ms     |      1.5 ms           |  

(Get Random Integer)
| # Elements | (CSArrayList) | (java.util.ArrayList) |
| ---------- | ------------- | --------------------- |
|  1,000,000 |   90.6 ms     |     83.6 ms           |
|   750,000  |   53.8 ms     |     57.7 ms           |
|   500,000  |   33.7 ms     |     28.1 ms           |
|   250,000  |   14.4 ms     |     19.8 ms           |
|   100,000  |    6.1 ms     |      2.3 ms           |

<br/>*2nd Test*<br/>
(Append)
| # Elements | (CSArrayList) | (java.util.ArrayList) |                  
| ---------- | ------------- | --------------------- |
|  1,000,000 |   31.1 ms     |    100.4 ms           |
|   750,000  |   32.6 ms     |     62.4 ms           |
|   500,000  |   26.3 ms     |     22.4 ms           |
|   250,000  |   15.4 ms     |     59.7 ms           |
|   100,000  |    6.1 ms     |      6.0 ms           |  

(Get Random Integer)
| # Elements | (CSArrayList) | (java.util.ArrayList) |
| ---------- | ------------- | --------------------- |
|  1,000,000 |   92.1 ms     |     94.3 ms           |
|   750,000  |   60.0 ms     |     69.6 ms           |
|   500,000  |   35.8 ms     |     44.0 ms           |
|   250,000  |   21.8 ms     |     21.9 ms           |
|   100,000  |   16.5 ms     |     15.8 ms           |

<br/>*3rd Test*<br/>
(Append)
| # Elements | (CSArrayList) | (java.util.ArrayList) |                  
| ---------- | ------------- | --------------------- |
|  1,000,000 |   54.8 ms     |    154.0 ms           |
|   750,000  |   70.3 ms     |    133.5 ms           |
|   500,000  |   42.0 ms     |     37.4 ms           |
|   250,000  |   62.3 ms     |     22.3 ms           |
|   100,000  |    9.4 ms     |      8.8 ms           |  

(Get Random Integer)
| # Elements | (CSArrayList) | (java.util.ArrayList) |
| ---------- | ------------- | --------------------- |
|  1,000,000 |  161.1 ms     |    139.2 ms           |
|   750,000  |  117.4 ms     |    121.2 ms           |
|   500,000  |   70.9 ms     |     41.3 ms           |
|   250,000  |   33.7 ms     |     30.2 ms           |
|   100,000  |   25.8 ms     |     10.7 ms           |

**Benchmark Conclusion**
- It seems like the different times between the two different types of arraylists are closer when they are multiples of 100,000 more likely than having the portion of 50,000 (250,000; 750,000; etc). This may be because of my CPU which is AMD since I asked someone else who has an Intel processor and they have a different mixed result when the numbwr of elements is at around 500,000.

