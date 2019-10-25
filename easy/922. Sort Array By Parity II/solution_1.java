class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int m;
        
        //generate *even* array
        int[] evenArray = new int[N/2];
    
        m = 0;
        for (int i = 0; i < N; i++) {
            if (A[i]%2 == 0) {
                evenArray[m++] = A[i];
            }
        }
        
        //generate *odd* array
        int[] oddArray = new int[(N+1)/2];
        
        m = 0;
        for (int i = 0; i < N; i++) {
            if (A[i]%2 != 0) {
                oddArray[m++] = A[i];
            }
        }
        
        int[] sortedArray = new int[N];
        
        //Fill the even values in the corresponding indexes.
        for (int i = 0; i < oddArray.length; i++) {
            sortedArray[i*2] = evenArray[i];
        }
        
        //Fill the odd values in the corresponding indexes.
        for (int i = 0; i < evenArray.length; i++) {
            sortedArray[i*2+1] = oddArray[i];
        }
        
        return sortedArray;
    }
}

