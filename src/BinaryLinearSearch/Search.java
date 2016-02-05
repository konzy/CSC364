package BinaryLinearSearch;

import java.util.Arrays;
import java.util.Random;
/**
 import java.util.Random;

 /**
 *   Project BinaryLinearSearch.Search.java
 *
 *   Description: Runs timing tests for Binary and Linear search
 *
 *   Maureen Doyle, doylem3
 *   CSC 364, Spring 2016
 *   1:57:25 PM
 *
 */

/**
 * @author doylem3
 *
 */
public class Search {

    Random data;  // Random number generator
    boolean[] checklist;  // try to have unique values. Not required
    final static int RANGE = 100000;

    // constants for size of sets to be searched
    final static int ZEROS = 5;
    final static int TEN = 0;
    final static int HUNDRED = 1;
    final static int THOUSAND = 2;
    final static int TEN_THOUSAND = 3;
    final static int HUNDRED_THOUSAND = 4;

    int [][] set = new int[ZEROS][];
    SearchableSet s;  // Just holder for the search algorithm


    /**
     * @param set
     * initialize
     *
     * Description:
     *
     * Returns : void
     *
     */
    private void initialize(int[] set){

        // use values only once in an array, although not requred
        for (int i = 0; i < checklist.length; i++)
            checklist[i] = false;

        for (int i = 0; i < set.length; i++) {
            do {
                set[i] = data.nextInt(RANGE);//random number array
            } while (checklist[set[i]] == true);
            checklist[i] = true;
        }

        Arrays.sort(set);
    }


    /**
     *
     * BinaryLinearSearch.Search Create BinaryLinearSearch.Search Sets
     */
    public Search() {

        data = new Random();
        data.setSeed(193041321);  // don't change

        checklist = new boolean[RANGE];
        set[TEN] = new int[10];
        initialize(set[TEN]);

        set[HUNDRED] = new int[100];
        initialize(set[HUNDRED]);

        set[THOUSAND] = new int[1000];
        initialize(set[THOUSAND]);

        set[TEN_THOUSAND] = new int[10000];
        initialize(set[TEN_THOUSAND]);

        set[HUNDRED_THOUSAND] = new int[100000];
        initialize(set[HUNDRED_THOUSAND]);

    }

    /**
     * @param set
     * @param search_value
     * @param set_key
     * @param ex
     * timeMeBinary
     *
     * Description:  Times the call to do a binary search using nanoseconds.
     *    Prints out the execution time, neatly
     *
     * Returns : void
     *
     */
    public void timeMe(int[] set, int search_value, int set_key)
    {

        // TODO - Put in timing here,   Uncomment the System.out.println.
        //  Comment out the testing code
        //   with the if (sol != NOT_FOUND) since testing will be done by the time
        //   you need to add timing.
        double startTime = System.nanoTime();
        int sol = s.search(set, search_value);
        double time = System.nanoTime() - startTime;

        System.out.printf("\t" + String.valueOf(time));

        if (sol != SearchableSet.NOT_FOUND)
            System.out.printf("Found %d in set %d", search_value, set_key);
    }



    /**
     * @param value
     * findAndTime
     *
     * Description:  Do the timing around calling the solution
     *
     * Returns : void
     *
     */
    public void findAndTime(int value)
    {
        timeMe(set[TEN], value, TEN);
        timeMe(set[HUNDRED], value, HUNDRED);
        timeMe(set[THOUSAND], value, THOUSAND);
        timeMe(set[TEN_THOUSAND], value, TEN_THOUSAND);
        timeMe(set[HUNDRED_THOUSAND], value, HUNDRED_THOUSAND);
    }

    /**
     * @param title
     * @param search_value
     * runExample
     *
     * Description:  Just runs the examples.
     *
     * Returns : void
     *
     */
    public void runExample(String title, int search_value)
    {
        System.out.printf("\n%s\t\t: ", title);
        findAndTime(search_value);
    }


    /**
     * @param args
     * main
     *
     * Description:  Main method to test different search algorithms on different
     *     size data sets.
     *
     * Returns : void
     *
     */
    public  static void main(String []args)
    {
        Search binaryTest = new Search();
        binaryTest.s = new BinarySearch();

        Search linearTest = new Search();
        linearTest.s = new LinearSearch();

        // Let's just look for some numbers, but make sure
        // the include numbers that are in at least one list
        int [] searchList = {667,99840,55555, 57, 9999};

        for (int i = 0; i < searchList.length; i++ )
        {

            System.out.printf("\n\nLooking for %d\n", searchList[i]);
            binaryTest.runExample("Binary BinaryLinearSearch.Search", searchList[i]);
            linearTest.runExample("Linear BinaryLinearSearch.Search", searchList[i]);

        }


    }
}
