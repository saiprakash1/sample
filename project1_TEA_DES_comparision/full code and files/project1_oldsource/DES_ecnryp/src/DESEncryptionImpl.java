
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
 
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
 
 
public class DESEncryptionImpl {
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    private static final byte[] iv = {11, 22, 33, 44, 99, 88, 77, 66};
    
 
    public static void main(String[] args) {
      
    	String clearTextFile = "source.txt";    
    	System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DES ALGORITHM~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Please enter number one for ciper block chaining mode and number two for counter mode implementation using DES algorithm \n 1.Ciper Block Chaining  2.Counter Mode");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();

        String cipherTextFile = "ciper.txt";
        String clearTextNewFile = "source-new.txt";
        
        try{
            //create SecretKey using KeyGenerator
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            
            //get Cipher instance and initiate in encrypt mode
            if(option==1)
            encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            else
            encryptCipher = Cipher.getInstance("DES/CTR/PKCS5Padding");
           
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
             
            //get Cipher instance and initiate in decrypt mode
           if(option==1)
           decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
           else
           decryptCipher = Cipher.getInstance("DES/CTR/PKCS5Padding");
           
           
           decryptCipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
           
            //method to encrypt clear text file to encrypted file
            encrypt(new FileInputStream(clearTextFile), new FileOutputStream(cipherTextFile));
            
            //method to decrypt encrypted file to clear text file
           
            decrypt(new FileInputStream(cipherTextFile), new FileOutputStream(clearTextNewFile));
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
 
    private static void encrypt(InputStream is, OutputStream os) throws IOException {
    	
    	System.out.println("\t ~~~~~~~~~~~~~Encryption~~~~~~~~~~~~~~\n");
    	long start_time=System.nanoTime();
    	
        //create CipherOutputStream to encrypt the data using encryptCipher
    	System.out.println("Before calling encryption function , Current time in nanoseconds: "+start_time);
        os = new CipherOutputStream(os, encryptCipher);
        writeData(is, os);
        long end_time=System.nanoTime();
        System.out.println("After calling encryption function , Current time in nanoseconds: "+end_time);
        double difference=(end_time-start_time);
        System.out.println("Time taken to complete encryption function in nanoseconds is : "+difference);
        System.out.println("ciper.txt file is created and encrypted data is stored in it.\nPlease refresh workspace to view file.");
       
    }
 
 
    private static void decrypt(InputStream is, OutputStream os) throws IOException {
    	
    	System.out.println("\t ~~~~~~~~~~~~~Decryption~~~~~~~~~~~~~~\n ");
    	long start_time=System.nanoTime();
       
    	//create CipherOutputStream to decrypt the data using decryptCipher
        System.out.println("Before calling decryption function , Current time in nanoseconds: "+start_time);
        is = new CipherInputStream(is, decryptCipher);
        writeData(is, os);
        long end_time=System.nanoTime();
        System.out.println("After calling decryption function , Current time in nanoseconds: "+end_time);
        
        double difference=(end_time-start_time);
        System.out.println("Time taken to complete decryption function in nanoseconds is : "+difference);
        System.out.println("source-new.txt file is created and original plain text obtained after decryption operation is stored.\nplease refresh workspace to view file.");
    }
     
    //utility method to read data from input stream and write to output stream
    private static void writeData(InputStream is, OutputStream os) throws IOException{
        byte[] buf = new byte[1024];
        int numRead = 0;
        //read and write operation
        while ((numRead = is.read(buf)) >= 0) {
            os.write(buf, 0, numRead);
        }
        os.close();
        is.close();
    }
 
}