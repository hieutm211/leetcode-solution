class Solution {
    
    // there are 26 letters in the English alphabet.
    private static final int NUMBER_OF_CHARACTER = 26; 
    private static final char BEGIN_CHARACTER = 'a';
    
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[NUMBER_OF_CHARACTER]; 
        distributedCount(chars, count);
        
        int answer = 0;
        
        for (String word: words) {
            if (check(word, count)) {
                answer += word.length();
            }
        }
        
        return answer;
    }
    
    private boolean check(String word, int[] count) {
        int[] count2 = new int[NUMBER_OF_CHARACTER];
        distributedCount(word, count2);
        
        for (int i = 0; i < NUMBER_OF_CHARACTER; i++) {
            if (count[i] < count2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private void distributedCount(String word, int[] count) {
        for (char c: word.toCharArray()) {
            count[c - BEGIN_CHARACTER]++;
        }
    }
}
