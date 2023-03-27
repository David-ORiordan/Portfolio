# Multithreaded-Indexer-API

### Main Feature:  
Creates an index containing each word from a book (.txt file), assuming that the word has a dictionary definition and isn’t in the set of excluded words (the 1000 most common words). The index includes the page number(s) the word appears on and the number of times the word appears in total within the text.  

### Extra Features:  
• Prints each word’s total number of occurrences to the output file.  
• Displays the total number of unique words in the book.  
• Displays the unique words in alphabetical or reverse alphabetical order.  
• Displays the time taken to create the output file.  
• Offers the choice of excluding the 1000 most common words (google-1000.txt) from the index or specifying a text file containing other words to exclude of one’s own choosing.  
• The menu updates to reflect the user's taken actions and informs them of any missing elements if they attempt to create the output file without specifying/configuring these necessary elements.  

### Design rationale:  
Using virtual threads, each line in the book was parsed into its individual words. Each word was stored as a key in a ConcurrentSkipListMap alongside a value of IndexCount, which stored both the word’s associated page number(s) and the number of times it appeared. Likewise, words from a dictionary were parsed and stored in a ConcurrentSkipListMap, with each word and its definition being the key/value pairs. Finally, words to be excluded were stored in a Set.  
The final output file accessed the first map of words, checked if it had a matching word in the dictionary and, if so, accessed its definition. These words, assuming they were not also present in the set of excluded words, were added to the output file, alongside their definitions, their page number(s), and the number of times they appeared.  
Optionally, the number of unique words in the book could be displayed by accessing the size of the set of keys in its map. Similarly, these keys could be printed out to display each unique word in the book.

### How to use the application:  
• Run the application via the Runner() class or by entering “java --enable-preview -cp ./indexer.jar ie.atu.sw.Runner” into the command line.  
• The menu displays the options (1-8) available. The user inputs a number, depending on the desired option.   
• Note: Options 1-4 must be specified/configured before using Option 7; Option 1 must be specified before using Options 5-6; it is assumed that the dictionary.csv (98,544 words) and google-1000.txt files are present in the project directory  

View of Menu:   

<img width="360" alt="AOOPmenu" src="https://user-images.githubusercontent.com/124048714/216377411-3cfe6cd1-39a8-4467-8dbb-37c386339dc1.png">

 
 
Sample Output (Index sourced from Machiavelli's The Prince):  

<img width="682" alt="IndexerOutput" src="https://user-images.githubusercontent.com/124048714/217574799-1ed8ab6f-1ea3-431a-a9f4-a73490539e64.png">


### Technology used:
• Java 19
