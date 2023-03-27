# NGram-Frequency-Builder

### Description:  
A menu-driven Java application that can 1) Parse all the text files in a directory, 2) Process the text into a mapping of n-grams and their frequencies and then 3)
Output the map to a text file in CSV format.  

### Features:  
- Creates n-Grams of sizes between 1-5 from text files within a directory.
- Outputs n-Grams in a CSV format to a single file specified by the user.
- Output file displays n-Grams, n-Gram frequency, and frequency percentage of each n-Gram.
- Offers user the choice between chunky and offset n-Grams.  
    Example of a Chunky 2-Gram of the word "example" => {ex}, {am}, {pl}, with the final character ('e') discarded.  
    Example of an Offset 2-Gram of the word "example" => {ex}, {xa}, {am}, {mp}, {pl}, {le}.
- Extracts each word from the text files, then converts all Latin alphabet letters to lowercase (a-z) and removes all characters, including whitespace, that are not between a-z from each word.
- Updates the menu to inform the user of where they have already inputted data.
- Option to view inputted data.
- Option to reset any or all inputted data.
- Prevents user from creating an n-Gram file before they have submitted all necessary data (and informs user of what data is missing).
- Informs user of how long it took to generate the n-Gram output file.

### How to run:
After running the application, the menu will display the options which allow you to input all the necessary data (Options 1-4) to build an n-Gram frequency file.  
(Option 1) Enter a text file directory containing the text files from which you wish to generate n-Grams. Ensure that a full path name is given.  
(Option 2) Choose an n-Gram size (1-5).  
(Option 3) Choose an n-Gram format (1 = Chunky, 2 = Offset).  
(Option 4) Enter the desired output file name. Again, ensure that a full path name is given. Note that the output file will be created in a comma-separated values (CSV) format, therefore, creating a .csv file is recommended.  
Once all data has been input, you can create the n-Gram frequency output file (Option 5). At any point, you can view or reset the data (Options 6 and 7, respectively).  
(Option 8) Quits the application.  

View of Menu:  

<img width="351" alt="NGramMenu" src="https://user-images.githubusercontent.com/124048714/217559622-cf832228-72ba-4a2c-a195-15c14dae6201.png">  

Sample Output (2-Grams sourced from the text file directory found in this repository, sorted by most frequently occurring):  

<img width="259" alt="NGramSampleOutput" src="https://user-images.githubusercontent.com/124048714/217564168-8a4ecc85-aa57-4407-8781-9bfd9626252e.png">




### Techonology used:  
- Java 17
