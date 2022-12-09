package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;

/**
 * 题目：
    求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。
    而aa…a 的最大长度是n

    思路：
    https://blog.csdn.net/nvd11/article/details/127231342?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22127231342%22%2C%22source%22%3A%22nvd11%22%7D
 */
public class SumAAA {
    public static void main(String[] args) {
       System.out.println(MessageFormat.format("Sum of 2 + 22 + 222 + 222..2 n=10 is {0}", new SumAAAUitl().getSum(2,10)));
    }

}

class SumAAAUitl{
    /**
     * 
     * @param a  the number, 1 to 9
     * @param n  the number of elements of the sum list
     * @return the sum of the int list
     */
    public Long getSum(int a, int n){
         Long sum = 0L;
        Long x = 0L;

        for (int i=1; i<=n; i++){
            x = x * 10 + a; // X(n) = X(n-1) * 10 + a
            sum += x;
        }
        return sum;
    }
}
