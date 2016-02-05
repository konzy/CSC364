package BinaryLinearSearch;

/**
 * Author: Brian Konzman
 * Date: 1/14/2016
 * INF 260-002
 */
public class LinearSearch implements SearchableSet {

    @Override
    public int search(int[] set, int n) {
        for (int i = 0; i < set.length; i++) {
            if(set[i] == n){
                return i;
            }
        }
        return NOT_FOUND;
    }
}
