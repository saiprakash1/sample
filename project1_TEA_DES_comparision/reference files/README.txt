My project consists of two modules.One module has Tiny encryption algorithm implemented in ciper block chaining mode and counter mode. Another module has DES implementation of ciper block chaining mode and counter mode.

TEA_encryp (Module-1)
 1) It consists of five files. Three java files with names Intermediatefile_cbc.java , Intermediatefile_countermode.java and TEA.java. Two input files with names input_cbc.txt and inputfile_countermode.
 2) Intermediatefile_cbc file consists of ciper block chaining mode implementation of invoking TEA algorithm. It makes use of TEA.java file to invoke the Tea implementation. It has methods to format the data from bytes to integers and vice versa. 
 3) Intermediatefile_countermode file consists of counter mode implementation of invoking TEA algorithm. It makes use of TEA.java file to invoke the Tea implementation.It has methods to format the data from bytes to integers and vice versa.
 4) TEA.java file consists of encryptCBC(), decryptCBC(), encipher() as important methods which are used for CBC encryption, CBC decryption, counter mode encryption and decryption respectively.
 DES_ecnryp (Module-2)
 1) It consists of two files. DESEncryptionImpl.java and source.txt files.
 2) DESEncryptionImpl.java has two methods encrypt() and decrypt() which makes use of Java security libraries and implements DES operations of encryption and decryption.

 Running module-1 (Tiny Encryption Algorithm)
 ==============================
 Using Intermediatefile_cbc.java file 
 ------------------------------------
 1) Open the module-1 project and open intermediatefile_cbc.java .This file has ciper block chaining mode implementation of TEA algorithm. Use "java Intermediatefile_cbc" command to run java class which got created after compiling using "javac Intermediatefile_cbc.java" command.
 2) It prompts for an option and shows the available options.The input file with name "input_cbc" that needs to be encrypted using CBC mode will be taken and a ciper file with name "ciper_output_cbc" will be created.
 3) We need to press number "1" and give enter, so that it performs encryption operation by taking input file which contains plaintext data. 
 4) I have hard coded the key for this mode of operation.It is an integer array with 10,12,13,14 as values.
 4)	Encrypted format of data can be seen in "ciper_output_cbc" file. Refresh the workspace area in-order to view the newly created ciper text file.
 5) Now as input data is taken and encrypted data is created.We are good to go for decryption.
 6) Once again run the Intermediatefile_cbc.java file in order to use the decryption operation.
 7) Enter number "2" for decryption of "ciper_output_cbc.txt" file which will be created after encryption operation. We do not need to give any explicit file name.Ciper output file name is hard coded in the program. 
 8) Once decryption is done, Refresh the workspace area so that newly created file can be seen.
 9) ciper_to_original_cbc.txt file will be created and decrypted form of ciper text which will be original plain text data can be viewed in this file.
 
 
 Using Intermediatefile_countermode.java file 
 --------------------------------------------
 1) Open the module-1 project and open intermediatefile_countermode.java .This file has counter mode implementation of TEA algorithm. Use "java Intermediatefile_countermode" command to run java class which got created after compiling using "javac Intermediatefile_countermode.java" command.
 2) It prompts for an option and shows the available options.The input file with name "inputfile_countermode" that needs to be encrypted using Counter mode will be taken and a ciper file with name "ciperoutputfile_countermode" will be created.
 3) We need to press number "1" and give enter, so that it performs encryption operation by taking input file which contains plaintext data.
 4) Enter key which contains 4-characters. For example : abcd . Give enter. 
 5)	Encrypted format of data can be seen in "ciperoutputfile_countermode". Refresh the workspace area in-order to view the newly created ciper text file.
 6) Now as input data is taken and encrypted data is created.We are good to go for decryption.
 7) Once again run the Intermediatefile_countermode.java file in order to use the decryption operation.
 8) Enter number "2" for decryption of "ciperoutputfile_countermode" file which will be created after encryption operation. We do not need to give any explicit file name.Ciper output file name is hard coded in the program. 
 9) It prompts for the key. Give 4- character key which is supplied to encryption operation.For example: abcd . Give enter.
 10) Once decryption is done, Refresh the workspace area so that newly created file can be seen.
 11) ciper_to_original_coountermode file will be created and decrypted form of ciper text which will be original plain text data can be viewed in this file.
 
 
 Running Module-2 (DES encryption algorithm)
 =========================================
 1) Open DESEncryptionImpl.java and run it using "java DESEncryptionImpl" command.
 2) It prompts for an option showing two modes of implementation.
 3) Enter number "1" for ciper block chaining mode. or number "2" for counter mode implementation.
 4) Key is taken from KeyGenerator class available in java libraries.
 5) In both cases(i.e option 1 or 2) input is taken from source.txt and encrypted form of data is created in ciper.txt. We can view encrypted format of data in ciper.txt.
 6) This program also decrypts the data and file will be created with name source-new.txt in which decrypted form of ciper text (i.e original text) can be seen.
  