package com.home.javacommon.study.algorithm;

import java.text.MessageFormat;

public class BallFall {
    public static void main(String[] args) {
        System.out.println(MessageFormat.format
            ("ball fall from {0} meters, when hit {1} times, total {2} meters have passed", 
            100, 10, new BallFallUtil().getTotal(100, 10)));
        
        System.out.println(MessageFormat.format
            ("ball fall from {0} meters, when hit {1} times, The ball will bounce {2} meters", 
            100, 10, new BallFallUtil().getUp(100, 10 + 1)));
    }
    
}

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
 * 分析： https://blog.csdn.net/nvd11/article/details/127234854?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22127234854%22%2C%22source%22%3A%22nvd11%22%7D
 */
class BallFallUtil{

    public Double getTotal(int start, int fallTime){
        Double fall = 0d;
        Double up = 0d;
        Double sum = 0d;

        for (int i=1; i <= fallTime; i++){
            fall = start * Math.pow(0.5, i-1);
            if (i > 1){
                up = fall;
            }

            sum = sum + fall + up;
        }
        return sum;
    }

    public Double getUp(int start, int fallTime){
        //if fallTime = 1 then up = 0；
        Double up = 0d;

        //up = fall 
        if (fallTime > 1){
            up = start * Math.pow(0.5, fallTime - 1);
        }
        return up;
    }
}