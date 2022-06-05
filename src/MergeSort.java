import java.util.Random;

public class MergeSort {
    Random rand = new Random();
    int[] unsortedArray = new int[10];

    public void initArray(int[] unsortedArray) {
        for(int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(100);
        }
    }

    public static void mergeSort(int[] unsortedArray) {
        int inputLength = unsortedArray.length;

        if(inputLength < 2) {
            return;
        }
        //
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for(int i = 0; i < midIndex; i++) {
            leftHalf[i] = unsortedArray[i];
        }

        for(int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = unsortedArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //Merge
        merge(unsortedArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize) {
            if(leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
