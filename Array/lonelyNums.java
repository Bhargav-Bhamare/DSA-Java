import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Method 1

    // public List<Integer> findLonely(int[] nums) {
    //     List<Integer> ans = new ArrayList<>();
    //     Map<Integer, Integer> map = new HashMap<>();

    //     for(int num : nums){
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    //         int val = entry.getKey();
    //         if(entry.getValue() == 1 && !map.containsKey(val +1) && !map.containsKey(val-1)){
    //             ans.add(val);
    //         }
    //     }
    //     return ans;
    // }



//Method 2
public class lonelyNums {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getKey();
            if(entry.getValue() == 1 && !map.containsKey(val +1) && !map.containsKey(val-1)){
                ans.add(val);
            }
        }
        return ans;
    }
}
