package InsertionBucketSearch;

import java.util.*;

/**
 * Author: Brian Konzman
 * Date: 2/2/2016
 * INF 364
 */
public class Bucket {

    public static void main(String[] args) {
        Random rand = new Random();
        //int[] tenArray = createRandomSet(10, 1000);
        int[] hundredArray = createRandomSet(100, 1000);
        int[] thousandArray = createRandomSet(1000, 1000);
        int[] tenThousandArray = createRandomSet(10000, 1000);

        double start = System.nanoTime();
        hundredArray = insertionSort(hundredArray);
        double total = System.nanoTime() - start;
        System.out.println("hundred insertion " + String.valueOf(total));

        start = System.nanoTime();
        insertionSort(thousandArray);
        total = System.nanoTime() - start;
        System.out.println("thousand insertion " + String.valueOf(total));

        start = System.nanoTime();
        insertionSort(tenThousandArray);
        total = System.nanoTime() - start;
        System.out.println("ten thousand insertion " + String.valueOf(total));

//        start = System.nanoTime();
//        bucketSort(tenArray, 10);
//        total = System.nanoTime() - start;
//        System.out.println("ten 10 buckets " + String.valueOf(total));

        start = System.nanoTime();
        bucketSort(hundredArray, 10);
        total = System.nanoTime() - start;
        System.out.println("hundred 10 buckets " + String.valueOf(total));

        start = System.nanoTime();
        bucketSort(hundredArray, 100);
        total = System.nanoTime() - start;
        System.out.println("hundred 100 buckets " + String.valueOf(total));

        start = System.nanoTime();
        bucketSort(hundredArray, 1000);
        total = System.nanoTime() - start;
        System.out.println("hundred 1000 buckets " + String.valueOf(total));

//        start = System.nanoTime();
//        bucketSort(thousandArray, 100);
//        total = System.nanoTime() - start;
//        System.out.println("thousand bucket " + String.valueOf(total));
//
//        start = System.nanoTime();
//        bucketSort(tenThousandArray);
//        total = System.nanoTime() - start;
//        System.out.println("ten thousand insertion " + String.valueOf(total));
    }

    public static int[] createRandomSet(int n, int range){
        Random rand = new Random();
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = rand.nextInt(range);
        }
        return set;
    }

    private static int[] bucketSort(int [] set, int numBuckets){
        LinkedList<Integer>[] buckets = new LinkedList[numBuckets];

        for (int i = 1; (int) Math.round(Math.pow(10, i)) <= 1000; i++) {
            for (int index = 0; index < numBuckets; index++) {
                buckets[index] = new LinkedList<>();
            }
            for (int j = 0; j < set.length; j++) {
                int number = set[j];
                int mod = (int) Math.round(Math.pow(10, i));
                int slash = (int) Math.round(Math.pow(10, i - 1));
                int bucket = number % mod / slash;
                buckets[bucket].add(number);
            }

            set = new int[set.length];
            int k = 0;
            for (LinkedList list: buckets) {
                for (Object elt: list) {
                    if (elt instanceof Integer){
                        set[k] = (int)elt;
                        k++;
                    }
                }
            }
        }
//        for (int integer :
//                set) {
//            System.out.println(integer);
//        }
        return set;
    }

    private static int[] insertionSort(int[] set, Integer... end){

        int limit;
        if (end.length > 0){
            limit = end[0];
        }else{
            limit = set.length;
        }
        for (int i = 1; i < set.length; i++) {
            int temp = set[i];
            for (int j = i; j >= 0; j--) {
                if(j == 0){
                    set[j] = temp;
                }else if(temp < set[j - 1]){
                    set[j] = set[j - 1];
                }else{
                    set[j] = temp;
                    break;
                }
            }
        }
        return set;
    }
}
