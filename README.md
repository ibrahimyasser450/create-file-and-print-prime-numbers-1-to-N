# create-file-and-print-prime-numbers-1-to-N

i have 4 classes

1- class main => There is code to create a form with three inputs: number, Buffer Size, and file name then pass them to class buffer, Producer and Consumer
   Then the result returns to three texts : Large of prime number, Number of prime numbers and Time of processing

2- class Buffer => there is queue same size of buffer and there is two functions => 
  1- add to add item to queue if the size of queue not equal the size of buffer add item 
  2- consume to remove item from queue if the queue not empty remove item 
  
3- class Producer => there is two functions => 
  1- isPrime takes one parameter (number) then check if the number is a prime number or not 
  2- run after check if the number is a prime number use the add function to add the item to buffer(queue) after finished calculate Large of prime number,
    Number of prime numbers and Time of processing
   
4- class Consumer => there is one function =>
  1- run to print all  prime numbers in file after adding the item use the consume function to remove the item from buffer(queue) and close the file 
