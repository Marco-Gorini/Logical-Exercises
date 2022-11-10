package com.soprasteria;


public class Main {
	
	public final static int dim = 5;
	
	public static void main(String[] args) {
		
		int[] vect = new int[dim];
		
		initializateVect(vect);
		printVect(vect);
		System.out.println("\n");
		orderVect(vect);
		printVect(vect);
	}
	
	public static void initializateVect(int vect[]) {
		for(int i = 0; i < dim; i++) {
			vect[i] = (int) (Math.random() * 1000 + 1);		
		}
	}
	
	public static void orderVect(int vect[]) {
		for(int i = 0; i < dim; i++) {
			int min = vect[i];
			int indexMin = i;
			for(int j = i; j < dim; j++) {
				if(vect[j] < min) {
					min = vect[j];
					indexMin = j;
				}
			}
			vect[indexMin] = vect[i];
			vect[i] = min;
		}
	}
	
	public static void printVect( int vect[]) {
		for(int i = 0; i < dim; i++) {
			System.out.print(vect[i] + " ");
		}
	}
	
}
