package El_sender;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;


public class Send {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ConvertFile conv=new ConvertFile();
        System.out.print("Enter n for length prime ==> ");
        int n=sc.nextInt();
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
        
        // ==============================random number=====================================================
        
        BigInteger minP=Power(n-1);
        BigInteger maxP=Power(n);
        System.out.println("minP is "+minP);
        System.out.println("maxP is "+maxP);
        BigInteger p = RandomNumber(minP,maxP);
        System.out.println("Random Number: " + p);

        // ==============================check prime=====================================================
        
    }

    
    public static BigInteger Power(int num){
        int base = 2, exponent = num;
        BigInteger result = BigInteger.valueOf(1);

        for (; exponent != 0; --exponent) {
            result =result.multiply(BigInteger.valueOf(base));
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