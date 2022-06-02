import java.util.Random;

public class QuickSort {

    Random rand = new Random();
    int[] unsortedArray = new int[10];

    public void initArray(int[] initArray) {
        for(int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(100);
        }
    }

    public void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        //if there is only one element in array
        if (lowIndex >= highIndex) {
            return;
        }

        //1 Step - choose a pivot
        //2 Step - lp > pivot and rp < pivot if TRUE -> swap lp and rp array
        //then continue moving lp toward rp and if lp = rp
        // we swap pivot with the current lp=rp index in the array
        //3 Step recursively sort left and right partiotions subarrays

        //[1, 5, 9, 4, 3, 8, 7]
        //       lp    rp
        //[1, 5, 3, 4, 9, 8, 7]
        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightpointer = highIndex - 1;

        //moving left index and right index towards each other
        while(leftPointer < rightpointer) {
            //check if leftmost item is less than pivot and lp != rp
            while(array[leftPointer] <= pivot && leftPointer < rightpointer) {
                leftPointer++; //if item is less pivot move leftPointer to right
            }
            //check if rightmost item is greater than pivot and lp != rp
            while(array[rightpointer] >= pivot && leftPointer < rightpointer) {
                rightpointer--; //move rightPointer to left
            }
            //if lp item greater than pivot and rp less then pivot
            swap(array, leftPointer, rightpointer);
        }//while

        swap(array, leftPointer, highIndex);
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }//quickSort

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}//QuickSort



