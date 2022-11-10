package com.soprasteria;


public class Main {
	
	public final static int dim = 10;
	
	
	public static void main(String[] args) {
		
		int vet[] = new int[dim];
		int counter = 0;
		int sum = 0;
		
		initArray(vet);
		printArray(vet);
		System.out.println("\n" + sumVec(vet,counter,sum));
	}
	
	public static int sumVec(int vect[],int i, int sum) {
		if(i == dim - 1) {
			return sum;
		}
		sum += vect[i];
		return sumVec(vect,++i,sum);
	}
	
	public static void initArray(int vect[]) {
		for(int i = 0; i < dim; ++i) {
			vect[i] = (int)(Math.random()*5);
		}
	}
	
	public static void printArray(int vect[]) {
		for(int i = 0; i < dim; i++) {
			System.out.print(vect[i] + " ");
		}
	}
}

