package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Intermediatefile_cbc{

	
	public static void main(String[] args) throws IOException{
	
		Random rand = new Random(250);
		int[] key = {10,12,13,14};				//instantiating a key
		TEA tea = new TEA(key);					//instantiating a TEA class
		
		int[] img = new int[2];
		
		int IV[] = {rand.nextInt(),rand.nextInt()};		//generating a random IV
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Ciper Block Chaining~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("Please enter option one for encryption or option two for decryption of file using ciper block chaining mode implementation of TEA ALGORITHM \n 1. Encryption 2. Decryption");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		
		
		boolean firstTime = true;		//to know when to apply IV or the previous encrypted block
		int cipher[] = new int[2];
		boolean check = true;			//to catch where the reading from the file is stopped
		System.out.println("\n Note: Key is hard coded in program");
		
		/*
		 * If encryption is selected then it enter this code other wise it moves to else block where decryption will be done*/
		if(option ==1)
		{
			
		FileInputStream imgIn = new FileInputStream("input_cbc.txt");
		FileOutputStream imgOut = new FileOutputStream("ciper_output_cbc.txt",true);
		
		DataInputStream dataIn = new DataInputStream(imgIn);
		DataOutputStream dataOut = new DataOutputStream(imgOut);
		
		long start_time=System.nanoTime();
		System.out.println("Before CBC mode Encryption operation started,time in nanoseconds: "+start_time);
		
		while(dataIn.available() > 0){
			try{
				img[0] = dataIn.readInt();
				check = true;
				img[1] = dataIn.readInt();
				if(firstTime){		//if true, the block is passed with IV to be encrypted by TEA algorithm
					cipher = tea.encryptCBC(img, IV);
					firstTime = false;		//set firstTime to false since IV is only encrypted with first block
				}
				else
					cipher = tea.encryptCBC(img, cipher);		//pass the block with the previous encrypted block
				
				dataOut.writeInt(cipher[0]);
				dataOut.writeInt(cipher[1]);
				check = false;
			}catch(EOFException e){				//excetion is thrown if the file ends and dataIn.readInt() is executed 
				if(!check){						//if false, it means last block were not encrypted
					dataOut.writeInt(img[0]);
					dataOut.writeInt(img[1]);
					System.out.println("check if");
				}else			{				//if true, it means only last half a block is not encrypted
					dataOut.writeInt(img[0]);
					System.out.println("check else");
				}
			}
			
		}
		dataIn.close();
		dataOut.close();
		
		
		imgOut.close();
		imgIn.close();
	
		long end_time=System.nanoTime();
		System.out.println("Ater CBC mode Encryption operation ended,time in nanoseconds: "+end_time);
		double difference=(end_time-start_time);
		System.out.println("Time taken to complete encryption operation in nano seconds is : "+difference);
		System.out.println("ciper_output_cbc.txt file is created in which ciper text is stored for input data.\nplease refresh workspace area to find encrypted file ");
		}
	
		
		/*~~~~~~~~~~~~~~~~~~~~~~~Decrypting the output_cbc file in which cipher data is stored ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		else{
	
		DataInputStream dataIn1 = new DataInputStream(new FileInputStream("ciper_output_cbc.txt"));
		DataOutputStream dataOut1 = new DataOutputStream(new FileOutputStream("ciper_to_original_cbc.txt"));
	
		
		int[] copyCipher = new int[2];
		firstTime = true;
		int plain[] = new int[2];
		check = true;
		
		long start_time=System.nanoTime();
		
		while(dataIn1.available() > 0){
			try{
				img[0] = dataIn1.readInt();
				check = true;
				img[1] = dataIn1.readInt();
				
				if(firstTime){							//if true, the first block is passed with IV to be decrypted
					plain = tea.decryptCBC(img,IV);
					firstTime = false;					//set first time to false
				}else									//if false, the block is passed with the previously encrypted block
					plain = tea.decryptCBC(img,copyCipher);		
				
				dataOut1.writeInt(plain[0]);
				dataOut1.writeInt(plain[1]);
				
				copyCipher[0] = img[0];				//Save the previously encryted block in copyCipher to use it
				copyCipher[1] = img[1];
				
				check = false;
			}catch(EOFException e){
				if(!check){
					dataOut1.writeInt(img[0]);
					dataOut1.writeInt(img[1]);
				}else
					dataOut1.writeInt(img[0]);;
			}
			
		}
		dataIn1.close();
		dataOut1.close();
	
		
		long end_time=System.nanoTime();
		long difference=(end_time-start_time);
		System.out.println("Time taken to complete decryption operation in nano seconds is : "+difference);
		System.out.println("ciper_to_original_cbc.txt file is created and original plain text data obtained by decryption operation is stored.");
		}
		

	}
}