package com.wrox.algorithms.wmatch;

import java.util.Arrays;

public class LevenshteinWordDistanceCalculator {

	public static final LevenshteinWordDistanceCalculator DEFAULT = 
			new LevenshteinWordDistanceCalculator(1, 1, 1);
	
	private final int costOfSubstitution;
	private final int costOfDeletion;
	private final int costOfInsertion;

	public LevenshteinWordDistanceCalculator(int costOfSubstitution, 
											int costOfDeletion, 
											int costOfInsertion) {
		// TODO Auto-generated constructor stub
		assert costOfSubstitution >= 0 : "costOfSubstitution can’t be < 0";
		assert costOfDeletion >= 0 : "costOfDeletion can’t be < 0";
		assert costOfInsertion >= 0 : "costOfInsertion can’t be < 0";
		this.costOfSubstitution = costOfSubstitution;
		this.costOfDeletion = costOfDeletion;
		this.costOfInsertion = costOfInsertion;
	}

	public int calculate(CharSequence source, CharSequence target) {
		// TODO Auto-generated method stub
		assert source != null : "source can’t be null";
		assert target != null : "target can’t be null";
		
		int sourceLength = source.length();
		int targetLength = target.length();
		
		int[][] grid = new int[sourceLength + 1][targetLength + 1];
		grid[0][0] = 0;
		
		for (int row = 1; row <= sourceLength; row++) {
			grid[row][0] = row;
		}
		
		for (int col = 1; col <= targetLength; col++) {
			grid[0][col] = col;
		}
		
		for(int row = 1; row <= sourceLength; row ++){
			for(int col = 1; col <= targetLength; col ++){
				grid[row][col] = minCost(source, target, grid, row, col);
			}
		}
		prinGrid(grid);
		return grid[sourceLength][targetLength];
	}

	private int minCost(CharSequence source, CharSequence target, int[][] grid, 
			int row, int col) {
		// TODO Auto-generated method stub
		return min(
				substitutionCost(source, target, grid, row, col),
				deleteCost(grid, row, col),
				insertCost(grid, row, col)
				);
	}

	private int min(int a, int b, int c) {
		// TODO Auto-generated method stub
		return Math.min(a, Math.min(c, b));
	}

	private int insertCost(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		return grid[row][col - 1] + this.costOfInsertion;
	}

	private int deleteCost(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		return grid[row - 1][col] + this.costOfDeletion;
	}

	private int substitutionCost(CharSequence source, CharSequence target, 
			int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		int cost = source.charAt(row - 1) == target.charAt(col - 1) ? 0 : costOfSubstitution;
		return grid[row - 1][col -1] + cost;
	}
	
	private void prinGrid(int[][] grid){
		for(int i = 0; i < grid.length; i ++){
			System.out.println(Arrays.toString(grid[i]));
		}
	}

}
