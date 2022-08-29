/**
 * CyclicSort
 */
public class CyclicSort {
    public static void main(String[] args) {
        BasicCyclicSort bsc = new BasicCyclicSort();
        int[] arr = { 3, 4 , 5, 1, 2 };
        bsc.sort(arr);
    }
}

/**
 * BasicCyclicSort
 */
class BasicCyclicSort {
    void sort(int[] arr) {

        int i = 0;
        while(i < arr.length) {
            while (arr[i] - 1 != i) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
            i++;
        }

        for (int j : arr) {
            System.out.println(j);
        }

    }

}