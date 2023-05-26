package El_sender;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConvertFile {
    public static void main(String[] args) {
        
        // PictureToBitConverter(filePath);
        
    }
    public static String FileToBitConverter(String filePath) {
        String binaryString="";
        try {
            byte[] Data = readFile(filePath);
            binaryString = convertToBinaryString(Data);
            
            // System.out.println(binaryString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return binaryString;
    }
    public static String TextToBitConverter(String message) {
        byte[] text = message.getBytes();
        String binaryString = convertToBinaryString(text);  
        // System.out.println(binaryString);
        
        return binaryString;
    }
    
    private static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] buffer = new byte[(int) file.length()];
        
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(buffer);
        }
        
        return buffer;
    }
    
    static String convertToBinaryString(byte[] data) {
        StringBuilder binaryString = new StringBuilder();
        
        for (byte b : data) {
            String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryString.append(binary);
        }
        
        return binaryString.toString();
    }


    

}
