package LeetCode;
//Question 231

public class Ques {
    
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
}
