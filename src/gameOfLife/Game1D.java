package gameOfLife;

import java.util.Arrays;

public class Game1D {
	
	static String[] map = new String[50];
	
	public static void main(String arg[]) {
		map = preFill(map);
		String[] firstMap = map;
		printMap(map);
		String[] map2 = map;
		String[] map3;
		for(int i = 0; i < 100; i++) {
			delay(0.1);
			map = nextMap(map);
			printMap(map);
			map3 = map2;
			map2 = map;
			if(Arrays.equals(map, map3)) {
				break;
			}
		}
		printStats(firstMap);
		printStats(map);
	}
	
	/*
	 * Create the next map based on the map given
	 * @param map > starting map
	 * @return nextMap > the next map based on the input map
	 */
	public static String[] nextMap(String[] map) {
		String[] nextMap = new String[map.length];
		for(int i = 0; i < map.length; i++) {
			int numAlive;
			if(i == 0) {
				numAlive = Integer.parseInt(map[map.length-1]) + Integer.parseInt(map[i+1]);
			} else if(i == map.length - 1) {
				numAlive = Integer.parseInt(map[i-1]) + Integer.parseInt(map[map.length-1]);
			} else {
				numAlive = Integer.parseInt(map[i-1]) + Integer.parseInt(map[i+1]);
			}
			if(map[i].equals("1")) { 
				if(numAlive == 0) { 
					nextMap[i] = "0"; 
				}
				if(numAlive == 1) { 
					nextMap[i] = "1"; 
				}
				if(numAlive == 2) { 
					nextMap[i] = "0";
				} 
			} else { 
				if(numAlive == 2) { 
					nextMap[i] = "1"; 
				} else { 
					nextMap[i] = "0"; 
				} 
			}
		}
		return nextMap;
	}
	
	/* 
	 * Create a new map using random number between 0 or 1
	 * @param map > starting map
	 * @return map > new map with random fill
	 */
	public static String[] preFill(String[] map) {
		for(int i = 0; i < map.length; i++) {
			int value = (int) (Math.random() * 2);
			if(value < 0) value = 0;
			map[i] = Integer.toString(value);
		}
		return map;
	}
	
	/*
	 * print the map out in one line
	 * @param map > the map to print out
	 */
	public static void printMap(String[] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.print((map[i].equals("1")) ? "&" : " ");
		}
		System.out.println();
	}
	
	/*
	 * prints out the statistics of the given map
	 * stats: number alive, number dead, percent alive
	 * @param map > the map for statistics
	 */
	public static void printStats(String[] map) {
		int numAlive = 0;
		int numDead = 0;
		int percentAlive = 0;
		
		for(int i = 0; i < map.length; i++) {
			int num = Integer.parseInt(map[i]);
			if(num == 0) numDead++;
			if(num == 1) numAlive++;
		}
		
		percentAlive = (int) (((double)numAlive / map.length) * 100);
		
		System.out.print("Number Alive: " + numAlive);
		System.out.print(" Number Dead: " + numDead);
		System.out.println(" Percent Alive: " + percentAlive + "%");
	}
	
	/*
	 * time delay based on input
	 * @param sec > delay time in seconds
	 */
	public static void delay(double sec) {
		long milliseconds = (long)(sec * 1000);
		try {
		    Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
}
