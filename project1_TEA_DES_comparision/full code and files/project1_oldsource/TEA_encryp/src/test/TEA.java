package test;

import java.io.IOException;
import java.util.*;

public class TEA{

	private static int DELTA = 0x9e3779b9;		//Delta varialbe is used to store magic constant.
	private static int ROUNDS = 32;
	private int sum;
		

	private int[] key; 			//key used to encrypt or decrypt

	/*
	 * This constructor is used for countermode implementation of creating a TEA object where key is externally supplied from user.
	 * */
	public TEA(){
		key = null;
	}

	
	/*
	 * This constructor is used for ciper block chaining mode implementation of creating a TEA object where key is hard coded.
	 * */
	public TEA(int[] keyAdd){
		key = new int[4];
		key[0] = keyAdd[0];
		key[1] = keyAdd[1];
		key[2] = keyAdd[2];
		key[3] = keyAdd[3];

	}
	
	
	/*
	 * To add or change a Key 
	 */
	public void addKey(int[] key){
		if(key.length < 4)
			System.out.println("Key is less than 128 bits");
		else if(key.length > 4)
			System.out.println("Key is more than 128 bits");
		else
			this.key = key;			
	}

	/* print the key added to TEA
	 * if there's no key added, a status message will be generated */
	public void printKeys(){
		if(key == null){
			System.out.println("There's no key");
		}
		System.out.println("Keys are\n");
		for(int i=0;i<4;i++){
			System.out.println(key[i]);
		}
	}
	
	/* TEA ENCRYPTION ALGORITHMS*/

	
	
	/*
	 * CBC MODE ENCRYPTION
	 * This methods take a block of 64 bit size and the previous encrypted block of size
	 * 64 bit, too. Then, it apply CBC mode algorithms on it. 
	 * and the encryption is done using TEA Algorithm
	 * @param: - plainText[2] Block of size 64 bit, 
	 * 		   - previous[2] previously encrypted block of size 64 bit
	 * Output: block[2]: encrypted block of size 64 bit
	 */
	public int[] encryptCBC(int[] plainText, int[] previous){
		//Check if the user defined the key
		if(key == null){
			System.out.println("Key is not defined!");
			System.exit(0);
		}
		
		/* XOR the block with the previously encrypted block */
		int left = plainText[0] ^ previous[0];
		int right = plainText[1] ^ previous[1];
		
		sum = 0;

		for(int i=0; i<32;i++){
			sum += DELTA;
			left += ((right << 4) + key[0]) ^ (right+sum) ^ ((right >> 5) + key[1]);
			right += ((left << 4) + key[2]) ^ (left+sum) ^ ((left >> 5) + key[3]);

		}
		
		int block[] = new int[2];
		block[0] = left;
		block[1] = right;
		
		return block;

	}

	/* TEA DECRYPTION ALGORITHMS*/
	
	
	/*
	 * CBC MODE DECRYPTION
	 * This methods take an encrypted block of 64 bit size and the previous encrypted block of size
	 * 64 bit, too. Then, it apply CBC mode algorithms on it. 
	 * and the decryption is done using TEA Algorithm
	 * @param: - cipherText[2] Block of size 64 bit, 
	 * 		   - previous[2] previously encrypted block of size 64 bit
	 * Output: block[2]: decrypted block of size 64 bit
	 */
	public int[] decryptCBC(int[] cipherText, int previous[]){
		if(key == null){
			System.out.println("Key is not defined!");
			System.exit(0);
		}
		
		/* Divding the block into left and right sub blocks */
		int left = cipherText[0];
		int right = cipherText[1];

		sum = DELTA << 5;		//initialize the sum variable

		for(int i=0; i<32;i++){
			right -= ((left << 4) + key[2]) ^ (left+sum) ^ ((left >> 5) + key[3]);
			left -= ((right << 4) + key[0]) ^ (right+sum) ^ ((right >> 5) + key[1]);
			sum -= DELTA;
		}
		
		/*XOR the result of TEA Algorithm output with the previous block's data*/
		int block[] = new int[2];
		block[0] = left ^ previous[0];
		block[1] = right ^ previous[1];
		
		
		
		return block;

	}
	
	
	

	/* 
	 * COUNTER MODE ENCRYPTION AND DECRYPTION
	 * This method is used for encryption and decryption purpose of counter mode implementaion using TEA algorithm.It
	 * takes counter array and key array as input values and uses TEA algorithm to encrypt data. 
	 *@param: - counter[2] Block of size 64 bit, 
	 * 		  - dummy_key[4] is key array used for encryption 
	 * */
	public int[] encipher(int[] counter,int[] dummy_key) throws IOException
	{
	
			int y, z;
			int sum = 0;  
		
			int[] outputvalue=new int[2];

			y = counter[0];
	    	z = counter[1];
	    	
				for (int i = 0; i < 32; i++)
			{
			//	sum += delta;
				
				sum += DELTA;

				y += ((y << 4) + dummy_key[0]) ^ (y + sum)
						^ ((y >>> 5) + dummy_key[1]);

				z += ((y << 4) + dummy_key[2]) ^ (y + sum)
						^ ((y >>> 5) + dummy_key[3]);
			}
			outputvalue[0]=y;
			outputvalue[1]=z;
			
			
			return outputvalue;
	}
}