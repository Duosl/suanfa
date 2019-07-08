package others;

import org.junit.Test;

public class Others {

    /**
     * 约瑟夫问题
     * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
     */
    private static void lastPerson(int n){

        if (n < 1){
            throw new IllegalArgumentException("人数不能小于0");
        }else {

            int[] persons = new int[n + 1];
            int num = 0;  //模拟报数 1~3
            int dead = 0; //退出人数

            //给每个人进行标号
            for (int i = 1; i <= n; i++) {
                persons[i] = i;
            }

            for (int i = 1; ; i++) {
                if (i > n) { //如果i>n; 重新开始 i=1;
                    i = 1; //等价于 i=1
                }

                if (persons[i] != 0) { //如果这个人没有退出，则报数
                    num++;
                }

                if (num == 3 && dead != n - 1) { //如果退出人数不等于或者说小于n-1, 则表示游戏未结束
                    num = 0;  //num重置
                    persons[i] = 0;   //表示此人退出
                    dead++; //退出人数+1
                } else if (dead == n - 1) { //只剩下最后一人，表示此人是幸存者
                    System.out.println("幸存者编号为：" + i);
                    break;
                }
            }
        }
    }

    /**
     * 给定一个字符串，求第一个不重复的字符 abbcad -> c
     */




    @Test
    public void testFun1(){
        lastPerson(1);
    }



}
