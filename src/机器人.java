import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/9/8 20:33
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class 机器人 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt();
            int[] src = new int[n];
            int[] res = new int[n];
            for (int i = 0; i < res.length; i++) {
                res[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                src[i] = input.nextInt();
            }
            for (int i = src.length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (src[j] >= src[i]) {
                        res[j]++;
                        break;
                    }
                }
            }
            int index = 0;
            int max = 0;
            for (int i = 0; i < res.length; i++) {
                if (res[i] > max) {
                    max = res[i];
                    index = i;
                }
            }
            System.out.println(src[index]);
        }
    }
}
