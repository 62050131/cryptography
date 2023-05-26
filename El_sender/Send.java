package El_sender;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;


public class Send {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ConvertFile conv=new ConvertFile();
        System.out.print("Enter n for length prime ==> ");
        BigInteger n=sc.nextBigInteger();
        // String inputfile="D:/Crypto/code/input.txt";

        //===============================input data and convert to plaintext binary================================================
        System.out.print("Enter 1 for message 2 for file ==> ");
        int choose=sc.nextInt();
        sc.nextLine();
        String binarytext="";
        if(choose==1){
            System.out.print("Enter message ==> ");
            String msg=sc.nextLine();
            binarytext=conv.TextToBitConverter(msg);
            // System.out.println(binarytext);
        }else if(choose==2){
            System.out.print("Enter path file ==> ");
            // String inputfile="D:/Crypto/code/Lenna.png";
            String path=sc.nextLine();
            binarytext=conv.FileToBitConverter(path);
            // System.out.println(binarytext);
        }
        System.out.println(binarytext);
        System.out.println("Data length = "+binarytext.length());
        
        // ==============================random number p=====================================================
        
        BigInteger minP=Power(BigInteger.TWO,n.subtract(BigInteger.ONE));
        BigInteger maxP=Power(BigInteger.TWO,n);
        System.out.println("minP is "+minP);
        System.out.println("maxP is "+maxP);
        BigInteger p = RandomNumber(minP.add(BigInteger.ONE),maxP.subtract(BigInteger.ONE));
        System.out.println("Random Number: " + p);

        // ==============================check prime=====================================================


        // ==============================random g and u=====================================================
        BigInteger g = RandomNumber(BigInteger.ONE,p.subtract(BigInteger.ONE));
        BigInteger u = RandomNumber(BigInteger.ZERO,p.subtract(BigInteger.ONE));
        System.out.println("G Number: " + g);
        System.out.println("U Number: " + u);
        BigInteger y = Power(g,u).mod(p);
        System.out.println("Y Number: " + y);
        
    }

    
    public static BigInteger Power(BigInteger base,BigInteger num){
        BigInteger exponent = num;
        BigInteger result = BigInteger.ONE;

        for (; exponent.compareTo(BigInteger.ZERO) != 0; exponent = exponent.subtract(BigInteger.ONE)) {
            result =result.multiply(base);
        }
        return result;
    }

    public static BigInteger RandomNumber(BigInteger min,BigInteger max){
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(max.bitLength(), random);

        while (p.compareTo(min) < 0 || p.compareTo(max) > 0) {
            p = new BigInteger(max.bitLength(), random);
        }
        return p;
    }
    
}