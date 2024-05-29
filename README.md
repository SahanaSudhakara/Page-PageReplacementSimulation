**Title:Page Replacement Simulation**

This project implements a page replacement simulation using various algorithms. It allows you to evaluate the performance of different page replacement algorithms by simulating their execution on a set of processes.

**Dependencies:**

This program requires Java version 8 or higher.

**Usage:**

To run the program, execute the following command from the command line:
(1)Go to the directory which has all java and make files.
(2)Run command: make 
(3)Next run command: java DriverClass

**PageReplacementAlgorithm class** represents a page replacement algorithm that operates on a simulated memory system. It consists of a linked list of frames representing the physical memory, with a fixed size defined by the MAIN_MEMORY_SIZE constant. The virtual memory, represented by the VIRTUAL_MEMORY_SIZE constant, contains all the pages available to the system.

runPageReplacementSimulation(int runTime) method:
executes the page replacement algorithms on a set of processes and calculates the hit ratios for each process as well as the average hit ratio for the chosen algorithm.
The method starts by picking a process from the head of the JobQueue.
Memory is assigned to the pages referenced by the process by calling the respective page replacement algorithm's run method.
The number of hits for the process is recorded.
Steps 2-4 are repeated for all processes in the JobQueue.
The total number of hits and references are calculated.
The hit ratio for each process and the average hit ratio for the chosen algorithm are computed.
The results are printed to the console.

The following algorithms are included:

1. FIFO (First-In-First-Out) Algorithm
The FIFO algorithm replaces the page that has been in memory the longest i.e evicts the page at the front of the queue when a new page needs to be loaded.

2. Random Algorithm
The Random algorithm selects a page to replace randomly from the set of pages currently in memory. It does not take into account any access patterns or page history.

3. Optimal Algorithm
The Optimal algorithm makes the optimal choice for page replacement by evicting the page that will not be needed for the longest time in the future.In the provided code, an approximation of the optimal choice is made based on the furthest future reference.

4. LRU (Least Recently Used) Algorithm
The LRU algorithm replaces the page that has not been accessed for the longest time. It uses the concept of tracking the last access time of each page to make eviction decisions.

**JobQueue class**represents a queue that holds a collection of Process objects. It provides methods to add processes to the queue and sort them based on their arrival time. The addPagesRequestedByProcess method generates a sequence of page requests for a given process. It takes the current page number, generates the next page number based on a probability of locality of reference, and adds the generated page to the list of requested pages for the process
**Page Class**represents a page in memory. Each page has a page number (virtual address) and a last access time. The class provides methods to get and set the page number and last access time.

**How to Use**

To run the page replacement algorithm simulation, execute the DriverClass main method. It compares the performance of each algorithm by running them multiple times and calculating the hit ratios. The number of runs for each algorithm can be specified in the main method.
