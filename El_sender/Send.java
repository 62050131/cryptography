package El_sender;

import java.util.*;


public class Send {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ConvertFile conv=new ConvertFile();
        System.out.print("Enter n for length prime ==> ");
        long n=sc.nextLong();
        // String inputfile="D:/Crypto/code/input.txt";
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
        
        
        
    }
    
}