class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        
        int[] sortedArray = new int[N];
        
        int endEven = 0;
        int endOdd = 1;
        
        for (int x: A) {
            if (x%2 == 0) {
                sortedArray[endEven] = x;
                endEven += 2;
            } else {
                sortedArray[endOdd] = x;
                endOdd += 2;
            }
        }
        
        return sortedArray;
    }
}
