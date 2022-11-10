package com.soprasteria;



public class Main {
	
	public final static int dim = 4;
	
	public static void main(String[] args) {
		
		
		int mat[][] = new int[dim][dim];
		initializateMatrix(mat);
		printMatrix(mat);
		getDiagonalsSum(mat);
	}
	
	public static void initializateMatrix(int mat[][]) {
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				mat[i][j] = (int) (Math.random() * 5);
			}
		}
	}
	
	public static void getDiagonalsSum(int mat[][]) {
		int sumLeftFromRight = 0;
		int sumRightFromLeft = 0;
		int counter = dim;
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				if(i == j) {
					sumLeftFromRight += mat[i][j];
				}
			}
			counter--;
			sumRightFromLeft += mat[i][counter];
		}
		int sum = sumLeftFromRight + sumRightFromLeft;
		System.out.println("Sum diagonals: " + sum);
	}
	
	public static void printMatrix(int mat[][]) {
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("\n");;
		}
	}

}

