package nowcode_huawei;

import java.util.Scanner;

//https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
public class Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            long num = input.nextLong();
            getResult(num);
        }
        input.close();

    }

    public static void getResult(long ulDataInput) {
        if (ulDataInput<=1) throw new IllegalArgumentException("_");
        while (!isPrime(ulDataInput)) {
            for (int i = 2; i < ulDataInput; i++) {
                if (isPrime(i) && ulDataInput % i == 0) {
                    ulDataInput /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
        System.out.print(ulDataInput + " ");
        System.out.println();
    }

    public static boolean isPrime(long n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
