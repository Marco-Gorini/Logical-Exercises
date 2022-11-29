package com.soprasteria;

import java.util.Scanner;



public class Main {
	
	public final static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int rows;
		int columns;
		int numberBigPolis;
		int numberSmallPolis;
		int numberOfIterations;
		
		System.out.println("Here is the game!");
		System.out.print("Insert the number of rows of the matrix: ");
		rows = in.nextInt();
		in.nextLine();
		System.out.print("Insert the number of columns of the matrix: ");
		columns = in.nextInt();
		in.nextLine();
		System.out.print("Insert the number of big polis: ");
		numberBigPolis = in.nextInt();
		in.nextLine();
		System.out.print("Insert the number of small polis: ");
		numberSmallPolis = in.nextInt();
		in.nextLine();
		System.out.print("Insert the number of iterations you want to do: ");
		numberOfIterations= in.nextInt();
		in.nextLine();
		System.out.println();
		
		char[][] tableGame = new char[rows][columns];
		
		initializateTheGame(tableGame, rows, columns, numberBigPolis, numberSmallPolis);
		printTableGame(tableGame, rows, columns);
		
		int[] scores = calculateTheScore(tableGame, numberOfIterations, rows, columns, numberBigPolis);
		
		for(int i = 0; i < numberBigPolis; ++i) {
			int bigPolisToAdd = scores[i] / 10;
			addBigPolis(tableGame, bigPolisToAdd, rows, columns);
			System.out.println("Score Polis " + (i + 1) + ": " + scores[i]);
		}
		printTableGame(tableGame, rows, columns);
	}
	
	
	public static void initializateTheGame(char tableGame[][],int rows,int columns,int numberBigPolis,int numberSmallPolis) {
		int numberOfIterations = 0;
		while(true) {
			int indexRowBigPolis = (int) (Math.random() * rows);
			int indexColumnBigPolis = (int) (Math.random() * columns);
			
			if(tableGame[indexRowBigPolis][indexColumnBigPolis] !=  'P') {
				tableGame[indexRowBigPolis][indexColumnBigPolis] =  'P';
				++numberOfIterations;
			}
			if(numberOfIterations == numberBigPolis) {
				break;
			}
		}
		
		
		numberOfIterations = 0;
		while(true) {
			int indexRowSmallPolis = (int) (Math.random() * rows);
			int indexColumnSmallPolis = (int) (Math.random() * columns);
			
			if(tableGame[indexRowSmallPolis][indexColumnSmallPolis] !=  's' && tableGame[indexRowSmallPolis][indexColumnSmallPolis] !=  'P') {
				tableGame[indexRowSmallPolis][indexColumnSmallPolis] =  's';
				++numberOfIterations;
			}
			if(numberOfIterations == numberSmallPolis) {
				break;
			}
		}
		
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < columns; ++j) {
				if(tableGame[i][j] != 'P' && tableGame[i][j] != 's') {
					tableGame[i][j] = '_';
				}
			}
		}
	}
	
	
	public static void printTableGame(char tableGame[][], int rows, int columns) {
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < columns; ++j) {
				System.out.print(tableGame[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static int[] calculateTheScore(char tableGame[][], int numberOfIterations, int rows, int columns, int numberOfBigPolis) {
		int[] scores = new int[numberOfBigPolis];
		int count = 0;
		for(int rowBigPolis = 0; rowBigPolis < rows; ++rowBigPolis) {
			for(int columnBigPolis = 0; columnBigPolis < columns; ++columnBigPolis) {
				if(tableGame[rowBigPolis][columnBigPolis] == 'P') {
					int score = 0;
					for(int iterations = 0; iterations < numberOfIterations; ++iterations) {
						for(int i = rowBigPolis - 1; i <= rowBigPolis + 1; ++i) {
							for(int j = columnBigPolis - 1; j <= columnBigPolis + 1; ++j) {
								if(i >= 0 && j >= 0 && i < rows && j < columns) {
									if(tableGame[i][j] == 's') {
										score += 2;
									}
									else if (tableGame[i][j] == '_') {
										score += 1;
									}
								}
							}
						}
					}
					scores[count] = score;
					++count;
				}
			}
		}
		return scores;
	}
	
	public static void addBigPolis(char tableGame[][], int bigPolisToAdd, int rows, int columns) {
		for(int rowBigPolis = 0; rowBigPolis < rows; ++rowBigPolis) {
			for(int columnBigPolis = 0; columnBigPolis < columns; ++columnBigPolis) {
				if(tableGame[rowBigPolis][columnBigPolis] == 'P') {
					int clocks = (bigPolisToAdd / 8) + 1;
					int counterPolisAdded = 0;
					int rowToAdd = 1;
					for(int clock = 0; clock < clocks; ++clock)	{
						int counterRow = rowBigPolis - rowToAdd;
						int counterColumn = columnBigPolis;
						int trackRow = 0;
						int trackColumn = 1;
						while(counterPolisAdded < bigPolisToAdd) {
							if(counterRow == rowBigPolis - rowToAdd && counterColumn == columnBigPolis + rowToAdd) {
								trackColumn = 0;
								trackRow = 1;
							}
							else if(counterRow == rowBigPolis + rowToAdd && counterColumn == columnBigPolis + rowToAdd) {
								trackColumn = -1;
								trackRow = 0;
							}
							else if(counterRow == rowBigPolis + rowToAdd && counterColumn == columnBigPolis - rowToAdd) {
								trackRow = -1;
								trackColumn = 0;
							}
							else if(counterRow == rowBigPolis - rowToAdd && counterColumn == columnBigPolis - rowToAdd) {
								if(tableGame[counterRow][counterColumn] != 's') {
									tableGame[counterRow][counterColumn] = 'p';
									++counterPolisAdded;
								}
								break;
							}
							if(counterRow >= 0 && counterColumn >= 0 && counterRow < rows && counterColumn < columns) {
								if(tableGame[counterRow][counterColumn] != 's' && tableGame[counterRow][counterColumn] != 'P') {
									tableGame[counterRow][counterColumn] = 'p';
								}
								else {
									counterRow += trackRow;
									counterColumn += trackColumn;
									continue;
								}
							}
							counterRow += trackRow;
							counterColumn += trackColumn;
							++counterPolisAdded;
						}
						++rowToAdd;
					}
				}
			}
		}
	}
}
