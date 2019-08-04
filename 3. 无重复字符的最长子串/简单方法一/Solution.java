
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        Set<Character> chars = new HashSet<>();
        for (int pre = 0; pre < s.length(); ++pre) {
            int cur = pre + 1;
            chars.clear();
            chars.add(s.charAt(pre));
            for (; cur < s.length(); ++cur) {
                if (chars.contains(s.charAt(cur))) {
                    if (max < cur - pre) {
                        max = cur - pre;
                    }
                    break;
                }
                chars.add(s.charAt(cur));
            }
            if (max < cur - pre) {
                max = cur - pre;
            }
        }
        return max;
    }
    // 测试代码，提交答案需删除
    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring( "pwwkew");
        System.out.println(len);
    }
}