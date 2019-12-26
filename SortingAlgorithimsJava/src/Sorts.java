
public class Sorts<K extends Comparable<K>> {
    
    private K[] A;
    private int length;
    
    public Sorts(K[] arr) {
        A = arr;
        length = A.length;
    }
    /**
     * Loop through array starting index = 0 and going to length - 2 
     * Then have a inner loop that starts at index + 1
     * Compare values stored at index  and index + 1
     * if value at index + 1 is less than value at index swap the values
     * Complexity is O(N^2)
     */
    public void selectionSort() {
        for(int i = 0; i < length - 1; i ++) {
            K min = A[i];
            int minIndex = i;
            for(int j = i + 1; j < length ; j++) {
                if(A[j].compareTo(min) < 0) {
                    min = A[j];
                    minIndex = j;
                }
            }
            A[minIndex] = A[i];
            A[i] = min;           
        }   
    }
    /*
     * Put first 2 items in correct relative order
     * Insert the 3rd item in the correct place to the relative to the first 2
     * Insert the 4th item in the correct place relative to the first 3
     * repeat ........
     * 
     */
    public void insertionSort() {
        K temp;
        int j;
        for(int i = 1; i < length; i++) {
            j = i -1;
            temp = A[i];
            while(j >= 0 && A[j].compareTo(temp) > 0) {
             // if the value of j is larger than temp move one place to the right
                A[j + 1] = A[j];
                j--;             
            }
            A[j + 1] = temp;
            printArray();
        }

    }
    /**
     * Merge sort 
     * 
    Divide the array into two halves.
    Recursively, sort the left half.
    Recursively, sort the right half.
    Merge the two sorted halves.

     */
    public void mergeSort() {
        merge(A,0,length-1,"OG CALL");
        System.out.println("After OG CALL");
    }
    
    private void  merge(K[] arr,int low, int high, String str) {
        //Base Case Length 1 array is already sorted
        if(low == high ) {
            System.out.print(str+ " BASE CASE");
            System.out.println();
            return;
        }else {
        System.out.print(str);
        System.out.println();
        }
        int mid  = (low + high)/2; //Find middle index of Array
        merge(arr,low, mid, "first call- low: " + low + " high: " +mid );
        merge(arr, mid + 1, high, "second call- low: " + (mid+1) + " high: " +high);
 
  
      
        
        
        int left = low;
        int right = mid + 1;
        int pos = 0;
        //Create array to store sorted values 
        K[] temp = (K[]) new Comparable[high-low + 1];
       
        // Compare left side to right side to see which has the smaller
        // value stored at an index and store that in temp array  
        // Exits loop once one of side of the array has been completely
        // iterated over
        while( left <= mid && right <= high) {
            if(A[left].compareTo(A[right]) < 0) {
                temp[pos] = A[left];
                pos++;
                left++;
            }else {
                temp[pos] = A[right];
                pos++;
                right++;              
            }
        }
        // If right side has been iterated over then store the 
        // rest of the left side
        while(left <= mid) {
            temp[pos] = A[left];
            pos++;
            left++;
        }       
        // If left side has been iterated over then store the 
        // rest of right side
        while(right <= high) {
            temp[pos] = A[right];
            pos++;
            right++;
        }
        System.out.println("temp array: ");
        for(int i = 0; i < temp.length; i++ ) {
            if(i != temp.length -1) {
            System.out.print("" + temp[i] + ", ");
            }else {
                System.out.println("" + temp[i]);
            }
        }
        
        //Then copy sorted values in temp array back into original array
        for(int i = 0; i < temp.length; i++) {       
            int j = i + low;
            A[j] = temp[i];
        }
        System.out.println("After Copy: " + "low: " + low + " high: " + high);
        printArray();
      
        
    }

    
    /** 
     * Prints contents of array 
     */
    private void printArray() {  
        for(int i = 0; i < A.length; i++ ) {
            if(i != A.length -1) {
            System.out.print("" + A[i] + ", ");
            }else {
                System.out.println("" + A[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        Integer[] intArray = {6,4,9,3,1,8};
        Sorts<Integer> test = new Sorts<Integer>(intArray);
        test.mergeSort();
        System.out.println("A: "); 
        test.printArray();
    }

}
