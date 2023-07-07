/**
 * @Author: Neo
 * @Date: 2023/06/29 Thursday 14:36:41 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hjPractice;

public class P0628 {
    public static void main(String[] args) {
        int[] desk = new int[]{1, 0, 0, 0, 1};
        desk = new int[]{0, 0, 0, 0, 1, 0, 0};
//        desk = new int[]{1};
        System.out.println(solution(desk));
    }

    public static int solution(int[] desk) {
        int ans = 0;
        int n = desk.length;
        if (n == 1) {
            return desk[0] == 0 ? 1 : 0;
        }

        for (int i = 0; i < desk.length; i++) {
            if (desk[i] == 1) {
                continue;
            }
            if (i == 0 && desk[i + 1] == 0) {
                ans++;
                desk[i] = 1;
            } else if (i == n - 1 && desk[i - 1] == 0) {
                ans++;
                desk[i] = 1;
            } else if (desk[i - 1] == 0 && desk[i + 1] == 0) {
                ans++;
                desk[i] = 1;
            }
        }
        return ans;
    }
}
