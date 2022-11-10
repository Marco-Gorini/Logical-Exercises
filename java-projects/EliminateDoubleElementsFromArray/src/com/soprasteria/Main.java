package com.soprasteria;

public class Main {
	
	public final static int dim = 10;
	
	public static void main(String[] args) {
		
		int vect[] = new int[dim];
		int vectRes[] = new int[dim];
		
		initializateVect(vect);
		printVect(vect);
		System.out.println("\n");
		removeDouble(vect, vectRes);
		
	}
	
	public static void removeDouble(int vect[], int vectRes[]) {
		vectRes[0] = vect[0];
		int counter = 1;
		for(int i = 0; i < dim; ++i) {
			boolean notInVect = true;
			for(int j = 0; j < counter; j++) {
				if(vect[i] == vectRes[j]) {
					notInVect = false;
				}
			}
			if(notInVect) {
				vectRes[counter] = vect[i];
				counter++;
			}
		}
		for(int i = 0; i < counter; ++i) {
			System.out.print(vectRes[i] + " ");
		}
	}
	
	public static void initializateVect(int vect[]) {
		for(int i = 0; i < dim; i++) {
			vect[i] = (int) (Math.random() * 8 + 1);		
		}
	}
	
	public static void printVect( int vect[]) {
		for(int i = 0; i < dim; i++) {
			System.out.print(vect[i] + " ");
		}
	}
	
}
