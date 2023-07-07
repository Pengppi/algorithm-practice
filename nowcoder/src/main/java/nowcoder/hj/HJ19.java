/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 15:35:26 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.*;

public class HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String path = in.next();
            int p = path.lastIndexOf("\\") + 1;
            int begin = Math.max(p, path.length() - 16);
            path = path.substring(begin);
            String line = in.next();
            String key = path + " " + line;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
                list.add(key);
            }
        }
        int n = list.size();
        for (int i = Math.max(0, n - 8); i < n; i++) {
            String key = list.get(i);
            System.out.println(key + " " + map.get(key));
        }
    }
}
