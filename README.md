Java Stream Program
Overview
This project demonstrates the use of Java Stream API—a powerful feature introduced in Java 8—for processing collections of data in a functional, declarative style. 
Streams enable efficient, readable, and maintainable code for data transformation, filtering, aggregation, and more.

Features
1. Creation of streams from various data sources such as collections and arrays.
2. Use of intermediate operations (e.g., filter(), map(), sorted()) to transform data.
3. Use of terminal operations (e.g., collect(), forEach(), max()) to produce results or side effects.

Example programs including:
1. Sorting list in alphabetical order
2. Anagrams
3. Concatenating string
4. EmployeeSorter
5. Highest repeated pattern in string
6. IntegerOperation
 a. Sum of Even Number
 b. Sum of arrays
 c. Average of Squares
 d. Find min and max from the list
 e. Find PrimeNumber
 f. Remove duplicates integer
 g. Count duplicates
7. Finding the kth largest element.
8. Finding the longest string.
9. Counting vowels in strings
10. Finding the most common first letter
11. Finding the most repeated Character in a string
12. Finding the non repeated Character in a string
13. Finding Palindrome string from the list
14. Calculating averages of sliding windows.

Demonstrates best practices such as proper use of terminal operations and avoiding stream reuse.
How to Use
1. Clone or download the repository.
2. Import the Java project in your IDE or build with your favorite build tool.
3. Explore the source files under src/, where each class/function demonstrates a specific use of Java Streams.
4. Run the main classes to see output examples.

Code Highlights
1. Functional Style: Uses lambda expressions and method references.
2. Immutability: Streams don't modify the underlying data source.
3. Lazy Evaluation: Intermediate stream operations are computed only when terminal operation is called.
4. Parallel Processing: Supports parallel streams to leverage multi-core processors.
