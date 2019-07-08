package others;

import java.util.*;

public class OtherTest {

    public static void main(String[] args) {

        进制转换();

//        getRepeatSting("abcgrgsssvvqqqqqsdd");

    }

    //测试集合的remove方法
    private static void testListRemove(){
//        List list = Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"});

        char c ='9';
        System.out.println(Integer.valueOf(0x7fffffff));
        System.out.println(Integer.valueOf(0x80000000));
        System.out.println(964632435 * 10);

        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        printList(list);


        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            printList(list);
            i--;
        }

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            iterator.remove();
//            printList(list);
//        }
    }

    private static void printList(List list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.printf("%s \t", next);
        }
        System.out.println();
    }

    //https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
    private static void 计算字符个数(){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s1 = input.next();
            String s2 = input.next();
            int count = 0;
            for(int i=0; i<s1.length()-1; i++){
                if(String.valueOf(s1.charAt(i)).equalsIgnoreCase(s2)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
    private static void 明明的随机数(){
//        String s = "23 29 40 111 41 104 21 94 108 118 21 110 34 24 24 40 66 19 25 40 30 5 59 116 98 110 118 77 87 49 95 53 44 94 52 104 7 118 20 5 57 81 73 39 106 6 26 2 69 44 19 50 78 61 55 27 97 103 109 66 101 15 86 17 70 96 50 1 118 81 107 102 22 84 112 64 106 14 15 14 93 54 38 66 78 5 118 60 107 84 34 47 57 8 5 67 111 42 35 64 10 109 90 57 72 73 91 54 5 10 31 64 113 39 120 6 45 15 46 112 40 105 115 106 88 64 20 113 52 1 40 90 103 63 28 11 34 33 11 78 42 30 119 34 94 78 73 104 36 44 65 41 81 69 74 75 49 66 30 74 75 111 44 97 102 65 99 63 77 78 102 84 10 6 12 27 99 120 84 37 10 74 2 83 53 18 106 48 17 26 94 50 11 120 17 21 79 42 48 48 75 91 56 69 21 44 16 14 34 110 43 27 102 63 81 92 109 97 100 70 23 44 17 32 60 40 40 36 3 92 48 34 88 58 30 106 63 31 8 116 90 100 83 111 42 112 6 8 115 109 83 7 26 88 68 86 116 39 55 76 109 45 1 39 4 52 78 26 33 96 14 38 105 65 116 4 48 83 24 113 111 70 37 34 51 46 18 104";
//        int n = 288;
//        String[] strings = s.split(" ");
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.valueOf(strings[i]);
//        }

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int temp;

        //插入排序
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = temp;
            }
        }

//        // 冒泡排序
//        for (int i = 0; i < n; i++) {
//            arr[i] = input.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n-i-1; j++) {
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                    flag = false;
//                }
//            }
//            if (flag) break;
//        }
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                System.out.println(arr[i]);
            }
        }
    }

    //https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
    private static void 字符串分隔(){
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            StringBuffer sb = new StringBuffer(input.nextLine());
            if(sb.length() > 8){
                int i = 0;
                do{
                    System.out.println(sb.substring(i,(i+1)*8));
                    sb = sb.delete(i,(i+1)*8);
                } while(sb.length()>8);
            }
            while(sb.length() < 8){
                sb.append("0");
            }
            if(sb.length() == 8){
                System.out.println(sb.toString());
            }
        }
    }

    //https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
    //16进制转10进制
    private static void 进制转换(){
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            String s = input.nextLine().trim();
            int temp = 0;
            char ch;
            if (s.startsWith("0x")){
                for(int i=2; i<s.length(); i++){
                    int t;
                    ch = s.charAt(i);
                    if(ch >= '0' && ch <= '9'){
                        t = ch - '0';
                    }else if(ch >= 'A' && ch <= 'F'){
                        t = ch - 'A' + 10;
                    }else if(ch >= 'a' && ch <= 'z'){
                        t = ch - 'a' + 10;
                    }else{
                        break;
                    }
                    for(int j = 0; j < s.length()-i-1; j++){
                        t *= 16;
                    }
                    temp += t;
                }
            }
            System.out.println(temp);
        }

    }


    /**
     * 找到字符串中连续重复两次以上的字符并输出
     * 例：abcgrgsssvvqqqqqsdd  => sss,vv,qqqqq,dd
     *
     * @param str
     */
    private static String getRepeatSting(String str) {
        if (str == null || str.length() == 0) return null;
        for (int i = 1; i < str.length(); i++) {
            int temp = i - 1;
            if (str.charAt(i - 1) == str.charAt(i)) {
                while ((++i) < str.length()) {
                    if (str.charAt(i - 1) == str.charAt(i)) {
                        continue;
                    } else {

                        break;
                    }
                }
                System.out.print(str.substring(temp, i) + ",");
            }
        }

        return str;
    }
}

