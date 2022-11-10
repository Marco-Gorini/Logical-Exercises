package com.soprasteria;

public class Main {

	public final static int dim = 3;
	
	public static void main(String[] args) {
		
		int[][] mat1 = new int[dim][dim];
		int[][] mat2 = new int[dim][dim];
		int[][] matProd = new int[dim][dim];
		
		initializateMatrix(mat2);
		initializateMatrix(mat1);
		productMatrix(mat1, mat2, matProd);
		System.out.println("Matrix 1: ");
		printMatrix(mat1);
		System.out.println("Matrix 2: ");
		printMatrix(mat2);
		System.out.println("Product of Matrix: ");
		printMatrix(matProd);
	}
	
	public static void initializateMatrix(int mat[][]) {
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				mat[i][j] = (int)(Math.random()*5);
			}
		}
	}
	
	public static void productMatrix(int mat1[][], int mat2[][], int matProd[][]) {
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				int sum = 0;
				for(int k = 0; k < dim; k++) {
					sum += mat1[i][k]*mat2[k][j];
				}
				matProd[i][j] = sum;
			}
		}
	}
	
	public static void printMatrix(int mat[][]) {
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
