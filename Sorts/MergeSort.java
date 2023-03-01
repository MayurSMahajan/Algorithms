import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {5,1,3,2,7,21,5,1,31,2,15,7,9,1,16,24,60,40,25,18,19,26,70,10,5,71,81,12,10,90};
        MergeSortMethod mg = new MergeSortMethod();
        numbers = mg.mergeSortArray(numbers);
        for(int el : numbers) {
            System.out.println(el);
        }
    }
}

class MergeSortMethod{
    public int[] mergeSortArray(int[] numbers){
        if(numbers.length < 2) return numbers;
        //divide the array into two sub arrays.
        int[] part1 = mergeSortArray(Arrays.copyOfRange(numbers,0, numbers.length/2));
        int[] part2 = mergeSortArray(Arrays.copyOfRange(numbers,numbers.length/2, numbers.length));

        //merge results of part1 and part2.
        return mergeTwoSubArrays(part1, part2, numbers);
    }

    public int[] mergeTwoSubArrays(int[] arr1, int[] arr2, int[] ansArray){
        int arr1Index = 0, arr2Index = 0, ansIndex = 0;
        while((arr1Index < arr1.length) && (arr2Index < arr2.length)){
            //none of the arrays are exhausted yet, lets compare the elements and arrange them
            if(arr1[arr1Index] < arr2[arr2Index]){
                ansArray[ansIndex++] = arr1[arr1Index++];
            }else{
                ansArray[ansIndex++] = arr2[arr2Index++];
            }
        }

        while(arr1Index < arr1.length){
            ansArray[ansIndex++] = arr1[arr1Index++];
        }

        while(arr2Index < arr2.length){
            ansArray[ansIndex++] = arr2[arr2Index++];
        }

        return ansArray;
    }

}
