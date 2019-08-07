import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLen = 0;
        for (int pre = 0, cur = 0; cur < s.length(); ++cur) {
            if (indexMap.containsKey(s.charAt(cur))) {
                pre = Math.max(pre, indexMap.get(s.charAt(cur)));
            }
            indexMap.put(s.charAt(cur), cur + 1); //  为什么cur + 1， 而不是cur；是为了有重复字符的时候，将pre指向前一个重复字符的下个位置
            maxLen = Math.max(maxLen, cur - pre + 1);
        }
        return maxLen;
    }
    // 测试代码，提交答案需删除
    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring( "abcabcbb");

        System.out.println(len);
    }
}