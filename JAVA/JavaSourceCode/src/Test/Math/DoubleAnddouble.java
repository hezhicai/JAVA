package Test.Math;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Stack;
import java.util.Vector;

public class DoubleAnddouble {
    public static void main(String[] args) {
        double c=0.99999999f;
        double d=1f;
        System.out.println(c==d);//true  计算机只能识别二进制 它们二进制相等
        BigDecimal e=new BigDecimal(Double.toString(0.99999999f));
        BigDecimal f=new BigDecimal(Double.toString(1f));
        System.out.println(e==f);//false

        BigInteger g=new BigInteger("2");//只能存储整数 不能存储 浮点型数

        BigInteger h=new BigInteger("3");
        System.out.println(g.add(h));
    }
}
