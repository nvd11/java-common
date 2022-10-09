package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;

import lombok.AllArgsConstructor;

/**
 *   求最大公约数
  假设 x 是 m 和 n 的最大公约数， 其中m > n
  那么 m = x * a
      n = x * b

  其中 x a b 都是整数
  我们 用 m 除以 n 取余数， 得出 y = m/n = a/b ,  z = m%n
  如果 y是整数， z余数是0， 则n就是 m和n的最大公约数， 毕竟m能被n整除

  如果 z余数不是0， 则用 n 去除于 z  得出z2 = n%z 不断循环执行这个操作， 知直至余数为0

  例子 假如 M=30 n=12
  1.  m = 32 n = 12 , z = 30%12 = 8
  2.  m2 = 12, n2 = 8 , z2= 12%8 = 4
  3.  m3 = 8,  n3 = 4, z3 = 8%4 = 0
  则 最大公约数是n2 = 6
  ******************************************************

  求最小公倍数
  假设 x 是 m 和 n 的最大公约数
   那么 m = x * a
       n = x * b

   其中 a b 互质 （最大公约数是1）
   则最小公倍数 y = a * b * x
   也就是讲 y = m * n / x   (x 是 m n 的最大公约数）
 *
 */
public class DivisorMultiple {
    public static void main(String[] args) {
        int m = 32; int n = 12;
        int z = new DivisorMultipleUtil(n, m).getMaxDivisor();
        System.out.println(MessageFormat.format("The max divisor of {0} and {1} is {2} , the min multiple of them is {3}",
                                                m,n,z,(m * n/ z)));
    }
}

@AllArgsConstructor
class DivisorMultipleUtil{
    private int m;
    private int n;

    /**
     * 
     * @return int , the max divisor from m n
     */
    public int getMaxDivisor(){
        this.swap();
        if (m == n){
            return m;
        }

        int m1 = m; int n1 = n; int z1 = m1 % n1;
        while (0 != z1){
            m1 = n1; n1 = z1; z1 = m1 % n1;
        }

        // z1 == 0
        return n1;
    }

    /**
     * make the m to be greater value, if n > m , then swap them
     */
    private void swap(){
        if (m < n){
            int t = m;
            m = n;
            n = t;
        }
    }

}
