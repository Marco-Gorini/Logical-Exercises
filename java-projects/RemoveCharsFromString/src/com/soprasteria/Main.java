package com.soprasteria;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String string1 = new String();
		String string2 = new String();
		
		//Init the string and convert in array
		System.out.println("Algorithm: ");
		string1 = in.nextLine();
		string2 = in.nextLine();
		char[] stringToRemove = string1.toCharArray();
		char[] stringToCompare = string2.toCharArray();
		
		//Algorithm
		setString(stringToRemove, stringToCompare);
		
	}
	
	public static void setString(char stringToRemove[], char stringToCompare[]) {
		int dimToReduce = stringToRemove.length;
		int dim = stringToCompare.length;
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dimToReduce; j++) {
				if(stringToCompare[i] == stringToRemove[j]) {
					for(int k = j; k < dimToReduce; k++) {
						if(k != dimToReduce - 1) {
							stringToRemove[k] = stringToRemove[k + 1];
						}
					}
					dimToReduce--;
					j--;
				}
			}
		}
		for(int i = 0; i < dimToReduce; i++) {
			System.out.print(stringToRemove[i]);
		}
	}
	
}
