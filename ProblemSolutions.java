/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        //Sorts the arrays and creates a bollean to later compare them
        Arrays.sort(list1);
        Arrays.sort(list2);
        boolean isSubset = true;
       
        //creates two ints to track the arrays
        int track1 = 0, track2 = 0;
        
        //uses a while loop to iterate and compare the two arrays
        while (track1 < list1.length && track2 < list2.length){
            //if the two arrays are equal, increment both tracks
            if (list1[track1] == list2[track2]){
                track1++;
                track2++;
                //if the first array is less than the second, increment the first track
            } else if (list1[track1] < list2[track2]){
                track1++;
            } else {
                //if the second array is less than the first, the second array is not a subset of the first
                isSubset = false;
                break;
            }
        }


        return isSubset;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
    
        /*Sorts the array and returns the kth largest element by 
        subtracting k from the length of the array*/
        Arrays.sort(array);
        int kMax = array[array.length - k];

        return kMax;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        //creates ints needed to track the arrays and their lengths
        int len1 = array1.length;
        int len2 = array2.length;
        int nTrack = 0, mTrack = 0;

        //sorts the arrays and creates a new array to store the sorted elements
        Arrays.sort(array1);
        Arrays.sort(array2);

        int[] result = new int[len1 + len2];

        for (int i = 0; i < result.length; i++){
            //makes sure the tracks are not at the end of the arrays
           if (nTrack != len1 && mTrack != len2){
                //compares the two arrays and adds the smaller element to the result array
               if (array1[nTrack] < array2[mTrack]){
                   result[i] = array1[nTrack];
                   nTrack++;
               } else {
                   result[i] = array2[mTrack];
                   mTrack++;
               }
           } 
           //when one array is empty, the other array is added to the result array and the track is incremented
           else if (nTrack == len1){
               result[i] = array2[mTrack];
               mTrack++;
           }
           else {
               result[i] = array1[nTrack];
               nTrack++;
           }
        }

        return result;
    }

}