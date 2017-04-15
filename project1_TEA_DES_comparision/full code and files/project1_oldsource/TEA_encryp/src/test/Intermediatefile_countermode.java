package test;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.*;


public class Intermediatefile_countermode {
	static int counter =1;
	static String nounce="cryptio";
	static String inp;
	static int[] num_array=new int[2];
	static String globaltemp;
	
	
	public static int unsignedByteToInt(byte b)
	{
		return (int) b & 0xFF;
	}
	
	/* Utility method to convert from Bytes to Integers */

	public static int byteToInt(byte[] buf, int pos)
	{
		int i = 0;

		i += unsignedByteToInt(buf[pos++]) << 24;
		i += unsignedByteToInt(buf[pos++]) << 16;
		i += unsignedByteToInt(buf[pos++]) << 8;
		i += unsignedByteToInt(buf[pos++]) << 0;

		return i;
	}
	
	
	/* Utility method to convert from Integers to Bytes */
	
	public static byte[] intToByteArray(final int integer)
	{
		int byteNum = (40 - Integer.numberOfLeadingZeros(integer < 0 ? ~integer : integer)) / 8;
		byte[] byteArray = new byte[4];

		for (int n = 0; n < byteNum; n++)
		{
			byteArray[3 - n] = (byte) (integer >>> (n * 8));
		}

		return (byteArray);
	}

	public static void main(String args[])
	{
		
		
		TEA first=new TEA();
	
		try{
				
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Counter Mode~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\n Please enter number one for encryption or number two for decryption of file using counter mode implementation of TEA ALGORITHM \n 1. Encrypt 2.Decrypt");
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();

			//Key input section is done below
			
			int[] key_array = new int[4];
			byte[] byteArray = new byte[16];

		
			System.out.println("\n Please enter key array here [It should be in range of 4 to 16 characters]");
			System.in.read(byteArray);
			System.in.skip(System.in.available());
			for (int i = 0; i < 4; i++)
					{
						key_array[i] = (int)byteArray[i];
			
					}
			
			
			boolean  check=true;
			
			
			/*Encryption operation starts from here*/
			
			if(option==1)
			{
				
				System.out.println("Program have entered encryption \n");
				
				
		    	long start_time=System.nanoTime();
		    	System.out.println("Before Counter mode Encryption operation started,time in nanoseconds: "+start_time);
		    	
				DataInputStream dis=new DataInputStream(new FileInputStream("inputfile_countermode"));
				
				int[] temp_num_array= new int[2];
				
				//This loop checks if contents in the file are available
				
				while(dis.available()>0)
				{
				
					
					try{	
					//It divides the input file into two blocks,converts them from bytes to integers and stores it in temp_num_array			
						temp_num_array[0]=dis.readInt();
						check=true;
						temp_num_array[1]=dis.readInt();
				
				
				
					//initializing counter array and setting the values
						String tempenc=nounce+counter;
						byte[] sendtoenc=tempenc.getBytes();
						int[] counter_array=new int[2];
						for (int i = 0; i < 2; i++)
							{
								counter_array[i] = byteToInt(sendtoenc, i * 4);
							}
				
							counter=counter+1;
				  
							//calling the tiny encryption function
				  
							int[] ciper=first.encipher(counter_array,key_array);	
			
							//Xor function which xor's output of encryption function and plaintext block converted in number array 
									
							int[] original_ciper=new int[2];
							/*XOR operation between plain text and output of encryption algorithm*/
							for(int k=0;k<2;k++)			
									{
										original_ciper[k]=ciper[k]^temp_num_array[k];
		
									}
			
									// Creating cipertext output file and writing the ciper contents after encryption operation
			
									byte[] byteArrayciper1 = new byte[4];
									byte[] byteArrayciper2 = new byte[4];

									byteArrayciper1 = intToByteArray(original_ciper[0]);
									byteArrayciper2 = intToByteArray(original_ciper[1]);

					
									FileOutputStream fileOutput = new FileOutputStream("ciperoutputfile_countermode",true);
			 			 
									fileOutput.write(byteArrayciper1, 0, 4);
									fileOutput.write(byteArrayciper2, 0, 4);
									check=false;
				
						}catch(EOFException e){
												if(!check){
													System.out.println("if false, it means last block were not encrypted");
												}else{
													System.out.println("if true, it means only last half a block is not encrypted");
												}
											}
				
				}
				
				long end_time=System.nanoTime();
		    	System.out.println("After Counter mode Encryption operation ended,time in nanoseconds: "+end_time);
		    	long difference=(end_time-start_time);
		    	System.out.println("Time taken for encryption operation in nanoseconds is : "+difference);
		    	System.out.println("ciperoutputfile_countermode file is created and encrypted data is stored in it.Please refresh workspace area to view file.");

			
			
			}
			
					//Decryption block starts from here	
			else{
				
				//Setting counter values
				System.out.println("Program has entered decryption operation");
				
				DataInputStream dis=new DataInputStream(new FileInputStream("ciperoutputfile_countermode"));

				long start_time=System.nanoTime();
				System.out.println("Before Counter mode Decryption operation started,time in nanoseconds: "+start_time);
				int[] temp_num_array= new int[2];

				//This loop checks if contents in the file are available
				while(dis.available()>0)
					{
				
						temp_num_array[0]=dis.readInt();
						temp_num_array[1]=dis.readInt();
							
						String tempenc=nounce+counter;
						byte[] sendtoenc=tempenc.getBytes();
						int[] counter_array=new int[2];
						/* This loop is used for converting counter array values from bytes to integers*/
						for (int i = 0; i < 2; i++)
							{
								counter_array[i] = byteToInt(sendtoenc, i * 4);
							}
				
							counter=counter+1;
				  
							//Calling cipher function which is same in case of counter mode
				  
							int[] deciper=first.encipher(counter_array,key_array);	
			
							int[] original_decip=new int[50];
							/*XOR operation between ciper text and output of encryption algorithm*/
								for(int k=0;k<2;k++)			
								{
									original_decip[k]=deciper[k]^temp_num_array[k];
								}
			
								// Creating and writing the original contents of file after decryption operation on ciper text data.
			
								byte[] byteArray1 = new byte[4];
								byte[] byteArray2 = new byte[4];

								byteArray1 = intToByteArray(original_decip[0]);
								byteArray2 = intToByteArray(original_decip[1]);
					
								FileOutputStream fileOutput = new FileOutputStream("ciper_to_original_countermode",true);
			 			 
								fileOutput.write(byteArray1, 0, 4);
								fileOutput.write(byteArray2, 0, 4);
								}
				
				long end_time=System.nanoTime();
		    	System.out.println("After Counter mode Decryption operation ended,time in nanoseconds: "+end_time);
		    	long difference=(end_time-start_time);
		    	System.out.println("Time taken for Decryption operation in nano seconds is : "+difference);
		    	System.out.println("ciper_to_original_countermode is created and original data obtained after decryption operation is stored in it.\nPlease refresh workspace area.");

				
			}
	
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	
	
}
