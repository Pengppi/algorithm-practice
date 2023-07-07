/**
 * @Author: Neo
 * @Date: 2023/07/02 Sunday 17:18:08 PM
 * @Project: practice
 * @IDE: IntelliJ IDEA
 **/

package nowcoder.hj;

import java.util.Scanner;
import java.util.StringJoiner;

public class HJ101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        sort(arr, 0, arr.length - 1, k);
        StringJoiner sj = new StringJoiner(" ");
        for (int i : arr) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj.toString());
    }


    private static void sort(int[] a, int lo, int hi, int k) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi, k);
        sort(a, lo, j - 1, k);
        sort(a, j + 1, hi, k);
    }

    private static int partition(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            if (k == 0) {
                while (a[++i] < v) {
                    if (i == hi) {
                        break;
                    }
                }
                while (a[--j] > v) {
                    if (j == lo) {
                        break;
                    }
                }
            } else {
                while (a[++i] > v) {
                    if (i == hi) {
                        break;
                    }
                }
                while (a[--j] < v) {
                    if (j == lo) {
                        break;
                    }
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
