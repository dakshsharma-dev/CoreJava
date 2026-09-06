package _03_Arrays;

public class _02_JaggedArray {
    public static void main(String[] args){
        // Jagged array is a multidimensional array where each row can have a different number of columns
        int[][] arr = new int[][]{
                {1,2,3},
                {3,4,4,5,5},
                {8,5,3},
        };

        for(int[] a: arr){
            for(int n: a){
                System.out.print(n + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // another way of initializing jagged array
        int[][] nums = new int[3][];
        // nums[0] = {1, 2, 3};                       // incorrect way
        nums[0] = new int[]{1, 2, 3};
        nums[1] = new int[]{1, 2, 3, 4, 5};
        nums[2] = new int[2];

        for(int[] num: nums){
            for(int n: num){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
