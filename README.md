# Array Sorter
This program uses the bubble sorting method to sort through an array of integers and arrange them from smallest to largest. The array may come either from a file provided by the user, or be created through a random number generated with the desired length.  

Array Sorter uses a scanner object, which will scan the user input when needed.

## User Commands
Upon start up, the program will ask whether you want to use a file containing an array (through entering 1) or generate an array of random integers (through entering 2)  
By entering either a 1 or a 2, the program will branch to insrtuctions for either reading in a file or generating an array.  

At any point, the user may enter -1 to exit the program.  
If an input entered is not valid, the user will be warned and prompted to re-enter a valid input.
### Reading in a file:
If the user selects this option, there will be a prompt asking the user to enter the file path for the file containing the array. Once a valid file path is entered, the program will convert the file into an array, and will print the array into the terminal if it is less than 30 elements long.
### Generating a random array:
If the user chooses to generate an array, they will next be prompted to enter the desired length of their array. When a valid length is entered, an array of random integers ranging from 0 to 100 of the desired length is generated. If the length entered was less than 30, the array will be printed to the terminal.
### Sorting:
Once an array is made either from a file or randomly generated, the array will move on to being sorted without any further prompts for the user. This array is sorted using the bubble sort method. Once the array is sorted, it will be written to a file called sortedArray and, if less than 30 elements, will be shown on the terminal after sorting.  

The user will then be re-prompted to choose either 1 or 2 for the next array to be sorted. The program will continue to run in this fashion until the user inputs -1 to exit.  

**Please note that the previous array written to the file sortedArray will be overwritten with a new array unless saved elsewhere.