import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author epochong
 * @date 2019/9/8 19:28
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class 解码 {
    static HashMap<Integer,Character> map = new HashMap <>();
    static TreeSet<String> res = new TreeSet <>();
    static String str = "";

    public static void process(int index,String s) {
        int cur = Integer.valueOf(str.substring(index,index + 1));

        if (index < str.length() - 2) {
            int more = Integer.valueOf(str.substring(index,index + 2));
            String tem = new String(s);
            if (more <= 26) {
                s += map.get(more);
                process(index + 2,s);
            }
            tem += map.get(cur);
            process(index + 1,tem);
        } else if (index == str.length() - 2){
            int more = Integer.valueOf(str.substring(index,index + 2));
            StringBuilder tem = new StringBuilder(s.toString());
            if (more <= 26) {
                s += map.get(more);
                res.add(s.toString());
            }
            tem.append(map.get(cur)).append(map.get(Integer.valueOf(str.substring(index + 1,index + 2))));
            res.add(tem.toString());
        } else {
            s += map.get(cur);
            res.add(s.toString());
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 26; i++) {
            map.put(i,(char) (64 + i));
        }
        Scanner input = new Scanner(System.in);
        str = input.nextLine();
        process(0,new String());

        for (String s :
             res) {
            System.out.println(s);
        }
    }
}
