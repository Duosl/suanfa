package nowcode_huawei;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class MapMergeAndSort {
    public static void main(String[] args) {

        //impl1();
        impl2();
    }

    // 使用自定义类实现
    public void impl1(){
        Scanner input = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            Item item = new Item(input.nextInt(), input.nextInt());
            if (items.isEmpty()) {
                items.add(item);
                continue;
            }
            int len = items.size();
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (items.get(j).add(item)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                items.add(item);
            }

        }
        Collections.sort(items);
        for (Item item : items) {
            System.out.println(item.key + " " + item.value);
        }
    }


    public static void impl2(){
        Scanner input = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int key = input.nextInt();
            int value = input.nextInt();
            if(map.containsKey(key)){
                map.replace(key,map.get(key)+value);
            }else{
                map.put(key, value);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1,o2) -> o1.getKey() - o2.getKey());
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static class Item implements Comparable<Item>{
        int key;
        int value;

        Item(int key, int value){
            this.key = key;
            this.value = value;
        }

        boolean add(Item another){
            if(this.key == another.key){
                this.value += another.value;
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Item another) {
            return this.key - another.key;
        }
    }
}