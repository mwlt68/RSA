import java.awt.*;
import java.util.Scanner;

public class EulerAndEuclid {
    public static int  EuclidAlgorithm(int smallVal,int bigVal){
        while (true){
            int remain=bigVal % smallVal;
            if (remain==0){
                return smallVal;
            }
            bigVal=smallVal;
            smallVal=remain;
        }
    }
    public static int EuclidExpandAlgorithm(int value,int moduleValue){
        int tempVal=value;
        int tempModule=moduleValue;
        int t0=0,t=1;
        int q=(int)Math.floor(tempModule/tempVal);
        int r= tempModule-q * tempVal;
        while (r>0){
            int temp=t0-q*t;
            if (temp >=0)
                temp=temp % moduleValue;
            else
                temp=moduleValue-((-temp)%moduleValue);
            t0=t;
            t=temp;
            tempModule=tempVal;
            tempVal=r;
            q=(int)Math.floor(tempModule/tempVal);
            r= tempModule-q * tempVal;
        }
        if (tempVal != 1)
            return -1;
        else
            return t;
    }
    public static int EulerAlgorithm(int value,int baseVal,int moduleVal){
        int result=1;
        while(baseVal != 0){
            if (baseVal % 2==1){
                result=(result*value)%moduleVal;
                baseVal--;
            }
            else{
                value=(value*value)%moduleVal;
                baseVal/=2;
            }
        }
        return result;
    }
}
