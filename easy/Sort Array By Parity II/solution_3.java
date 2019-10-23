class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        
        int[] sortedArray = A.clone();
        
        int endEven = 0;
        int endOdd = 1;
        while (endEven < N || endOdd < N) {
            while (endEven < N && sortedArray[endEven]%2 == 0) endEven += 2;
            while (endOdd < N && sortedArray[endOdd]%2 != 0) endOdd += 2;
            if (endEven < N && endOdd < N) {
                exchange(sortedArray, endEven, endOdd);
            }
        }
        
        return sortedArray;
    }
    
    public void exchange(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
