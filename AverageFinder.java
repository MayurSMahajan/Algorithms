public class AverageFinder {
    public static void main(String[] args) {
        Shreyash sy = new Shreyash();
        sy.avgFinder();
    }
}

class Shreyash{
    public void avgFinder(){
        int[] runs = {1,2,3,4,5,6,7,8,9,10};

        int min = runs[0];
        
        for (int j = 1; j < runs.length; j++) {
            if(runs[j] < min){
                min = runs[j];
            }
        }

        System.out.println("Minimum = " + min);

        int max = runs[0];

        for (int i = 1; i < runs.length; i++) {
            if(runs[i] > max){
                max = runs[i];
 
            }
        }
        System.out.println("Maximum = "+ max);

        //average = sum of arr / length of arr
        int sum = 0;
        for (int i : runs) {
           sum += i;
        }
        System.out.println("Sum = "+sum);
        System.out.println("length= "+runs.length);

        int average = sum / runs.length;

        System.out.println("Average ="  +average);
    }
}