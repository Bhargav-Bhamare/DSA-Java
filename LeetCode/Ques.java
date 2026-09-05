package LeetCode;
//Question 231
//Used Bit Manipulation to check if the number is a power of 2

public class Ques {
    
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
}
