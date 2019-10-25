class Solution {

    public int countCharacters(String[] words, String chars) {
        int answer = 0;
        for (String word: words) {
            if (canFormed(word, chars)) {
                answer += word.length();
            }
        }
        return answer;
    }
    
    public boolean canFormed(String word, String chars) {
        int M = chars.length();
        boolean[] mark = new boolean[M];
        
        for (char c: word.toCharArray()) {
            int i = 0;
            while (i < M && (mark[i] || chars.charAt(i) != c)) i++;
            if (i == M) return false;
            mark[i] = true;
        }
                   
        return true;
    }
}
