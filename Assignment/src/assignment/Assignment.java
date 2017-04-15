/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author SAI
 */
public class Assignment {

	
    public static void printArray(int[] array){
        System.out.println("sorted array is");
        for(int i : array) {
            System.out.printf("%d ", i);
        }
    }

	
	public static void divideSort(int[] array) {
		if(array.length < 2) {
			return;
		}
		
		int step = 1;
		int sL, sR;

		while(step < array.length) {
                 
			sL = 0;
			sR = step;
			while(sR + step <= array.length) {
                      
				combineArrays(array, sL, sL + step, sR, sR + step);
				
				sL = sR + step;
				sR = sL + step;
			}
			
			if(sR < array.length) {
				combineArrays(array, sL, sL + step, sR, array.length);
				
			}
			step *= 2;
		}
	}

	
	public static void combineArrays(int[] array, int sL, int stopL,
		int startR, int stopR) {
            
		int[] temp_right = new int[stopR - startR + 1];
		int[] temp_left = new int[stopL - sL + 1];

		for(int i = 0, k = startR; i < (temp_right.length - 1); ++i, ++k) {
			temp_right[i] = array[k];
		}
		for(int i = 0, k = sL; i < (temp_left.length - 1); ++i, ++k) {
			temp_left[i] = array[k];
		}

		temp_right[temp_right.length-1] = Integer.MAX_VALUE;
		temp_left[temp_left.length-1] = Integer.MAX_VALUE;

	
		for(int k = sL, m = 0, n = 0; k < stopR; ++k) {
			if(temp_left[m] <= temp_right[n]) {
				array[k] = temp_left[m];
                        	m++;
			}
			else {
				array[k] = temp_right[n];
                                n++;
			}
		}
	}

	public static void main(String[] args) {
		
                 System.out.println("Please enter the list of elements,one element saperated by spaces");
      
                Scanner sc= new Scanner(System.in);
                String temp=sc.nextLine();
              
String[] tokens = temp.split(" ");
int[] ary = new int[tokens.length];

int i = 0;
for (String token : tokens){
    ary[i++] = Integer.parseInt(token); 
}
		divideSort(ary);
		printArray(ary);
	}
}