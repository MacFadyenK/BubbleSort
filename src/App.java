import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    //reads a file and stores the contents in array form
    //parameter fileName: a valid path for the txt file
    //return: returns an integer array from the intput file
    public static int[] readFileToArray(String fileName) throws IOException{
        int length = 0;
        FileReader r = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(r);
        //finds the length of the array
        while(reader.readLine() != null){
            length++;
        }
        int[] arr = new int[length];

        r = new FileReader(fileName);
        reader = new BufferedReader(r);
        //writes the file to an array
        for(int i = 0; i < length; i++){
            String element = reader.readLine();
            arr[i] = Integer.parseInt(element);
        }
        reader.close();
        return arr;
    }

    //writes an array to a file with the givin file name
    //parameter array: the integer array to be written to a file
    //parameter fileName: the name of the file to be written to
    public static void writeArrayToFile(int[] array, String fileName) throws IOException{
        FileWriter w = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(w);
        //writes the array to the file
        for(int i = 0; i < array.length; i++){
            int elem = array[i];
            writer.write(Integer.toString(elem));
            //file will not have an extra line without an integer
            if(i != array.length-1){
                writer.newLine();
            }
        }
        writer.close();
    }

    //creates an array of specified length filled with random integers
    //parameter arrayLength: the desired size of the array
    //return: returns an integer array of random integers
    public static int[] createRandomArray(int arrayLength){
        int[] array = new int[arrayLength];
        Random rand = new Random();
        for(int i = 0; i < arrayLength; i++){
            array[i] = rand.nextInt(101);
        }
        return array;
    }

    //Uses bubble sorting to sort an array of integers from the smallest to largest number
    //parameter array: the array of integers to be sorted
    //parameter n: the largest index of the array desired to be sorted
    public static void bubbleSort(int[] array, int n){
        //stops if array is null or if there is only one element left
        if(array == null || n < 1){
            return;
        }
        //compares up to the index n
        for(int i = 0; i < n; i++){
            //swaps elements if the left is greater than the right element
            if(array[i] > array[i+1]){
                //swaps array elements
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        //recursion to sort through whole array
        bubbleSort(array, n-1);
    }

    //sorts integer array from smallest to largest using bubble sort. No n needed.
    //parameter array: the integer array to be sorted
    public static void bubbleSort(int[] array){
        bubbleSort(array, array.length-1);
    }


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ArraySorter.");

        boolean exit = false;
        //main program loop. runs until exit desired
        programLoop:
        while(!exit){
            System.out.println("If you would like to sort an array from a file, input 1.\n"
            + "If you would like to sort a randomly generated array, input 2\n"
            +"If you would like to exit, input -1");

            int[] array = null;
            boolean valid = false;
            //loops while an input is not valid
            while(!valid){
                String input = scan.nextLine();
                //sorting from a file option
                if(input.equals("1")){
                    System.out.println("Please enter your file path here:");
                    while(!valid){
                        String filePath = scan.nextLine();
                        //exit option
                        if(filePath.equals("-1")){
                            System.out.println("Exiting ArraySorter...");
                            exit = true;
                            break programLoop;
                        }
                        //for a valid file path
                        try {
                            array = readFileToArray(filePath);
                            //prints array to terminal if not too long
                            if(array.length<30){
                                System.out.println("Array before sorting:");
                                System.out.println(Arrays.toString(array));
                            }
                            //will cause continue to sorting
                            valid = true;
                        //for an invalid input
                        } catch (Exception e) {
                            System.out.println("Invalid file path. Please try again:");
                        }
                    }
                //for sorting a random array
                }else if(input.equals("2")){
                    System.out.println("Please input the desired length of the random array:");
                    while(!valid){
                        try {
                            int length = scan.nextInt();
                            //exit option
                            if(length == -1){
                                System.out.println("Exiting ArraySorter...");
                                exit = true;
                                break programLoop;
                            }
                            //catches negative cases so that it doesnt scan next line twice
                            if(length >=0){
                                scan.nextLine();
                            }
                            //creation of random array
                            array = createRandomArray(length);
                            //prints array to terminal if not too long
                            if(array.length<30){
                                System.out.println("Array before sorting:");
                                System.out.println(Arrays.toString(array));
                            }
                            //will continue to sorting
                            valid = true;
                        //invalid inputs
                        } catch (Exception e) {
                            System.out.println("Invalid Input. Please enter a positive number:");
                            scan.nextLine();
                        }
                    }
                //exit option
                }else if(input.equals("-1")){
                    System.out.println("Exiting ArraySorter...");
                    exit = true;
                    break programLoop;
                //invalid inputs
                }else{
                    System.out.println("Invalid input. Please enter either 1 or 2 or enter -1 to exit.");
                }
            }

            //sorting and writing to file
            bubbleSort(array);
            //prints sorted array if not too long
            if(array.length<30){
                System.out.println("Array after sorting:");
                System.out.println(Arrays.toString(array));
            }
            writeArrayToFile(array, "sortedArray.txt");
            System.out.println("Your sorted array is stored in the file 'sortedArray.txt'\n");
        }
        scan.close();
    }
}
