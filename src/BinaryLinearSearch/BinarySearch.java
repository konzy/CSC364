package BinaryLinearSearch;

/**
 * Author: Brian Konzman
 * Date: 1/14/2016
 * INF 364
 */
public class BinarySearch implements SearchableSet {

    @Override
    public int search(int[] set, int n) {
        int hi = set.length - 1;
        int mid;
        int lo = 0;

        while (hi >= lo) {
            mid = (hi + lo) / 2;
            if (n > set[mid]) {
                lo = mid + 1;
            } else if (n < set[mid]) {
                hi = mid - 1;
            } else if (n == set[mid]) {
                return mid;
            }
        }
        return NOT_FOUND;
    }
}
