// 1572. Matrix Diagonal Sum
// https://leetcode.com/problems/matrix-diagonal-sum
// beats 100% in speed and 6% in memory

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {2,6,3,8},
                {7,20,10,2},
                {5,4,3,5},
        };
        MatrixDiagonalSumSolution mds = new MatrixDiagonalSumSolution();
        System.out.println(mds.diagonalSum(mat));
    }
}

class MatrixDiagonalSumSolution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int left = 0;
        int right = mat[0].length - 1;

        for (int[] ints : mat) {
            sum += ints[left++] + ints[right--];
        }

        if(mat.length % 2 == 0){
            return sum;
        }
        int middleIndex = mat.length / 2;
        return sum - mat[middleIndex][middleIndex];
    }
}
