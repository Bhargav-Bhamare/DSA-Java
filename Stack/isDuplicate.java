package Stack;
import java.util.*;

public class isDuplicate {
    public static boolean isDuplicateStr(String str){
        Stack<Character> s = new Stack<>();

        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);

            //Closing
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count< 1){
                    return true; //Duplicate Found
                }else{
                    s.pop(); //Opening pair
                }
            }else{
                //Opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "(a+b)"; //false
        String str2 = "((a+b))"; //true
        System.out.println(isDuplicateStr(str2));
    }
}
