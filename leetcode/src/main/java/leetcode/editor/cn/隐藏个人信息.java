/**
 * @Title: 831.隐藏个人信息
 * @TitleSlug: maskingPersonalInformation
 * @Author: Neo
 * @Date: 2023-04-01 22:49:44
 */
package leetcode.editor.cn;

public class 隐藏个人信息 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 隐藏个人信息().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maskPII(String s) {
            if (s.contains("@")) {
                return maskEmail(s);
            } else {
                return maskPhone(s);
            }
        }

        public String maskEmail(String s) {
            String[] ss = s.split("@");
            String host = ss[0];
            String domain = ss[1];
            char[] cs = host.toCharArray();
            if (Character.isUpperCase(cs[0])) {
                cs[0] = Character.toLowerCase(cs[0]);
            }
            if (Character.isUpperCase(cs[cs.length - 1])) {
                cs[cs.length - 1] = Character.toLowerCase(cs[cs.length - 1]);
            }
            host = cs[0] + "*****" + cs[cs.length - 1];
            domain = domain.toLowerCase();
            return host + "@" + domain;

        }

        public String maskPhone(String s) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    cnt++;
                    sb.append(c);
                    if (sb.length() > 4) {
                        sb.deleteCharAt(0);
                    }
                }
            }
            String prefix = "";
            switch (cnt) {
                case 10:
                    prefix = "***-***-";
                    break;
                case 11:
                    prefix = "+*-***-***-";
                    break;
                case 12:
                    prefix = "+**-***-***-";
                    break;
                case 13:
                    prefix = "+***-***-***-";
            }
            int n = s.length();
            return prefix + sb.toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
