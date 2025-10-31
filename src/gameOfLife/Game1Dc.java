package gameOfLife;

public class Game1Dc {
	
	static int[] map = new int[50];

	public static void main(String[] args) {
		map = preFill(map);
		printMap(map);
		for(int i = 0; i < 50; i++) {
			delay(0.25);
			map = nextMap(map);
			printMap(map);
		}
	}
	
	/*
	 * Create the next map based on the map given
	 * @param map > starting map
	 * @return nextMap > the next map based on the input map
	 */
	public static int[] nextMap(int[] map) {
		int[] nextMap = new int[map.length];
		for(int i = 1; i < map.length - 1; i++) {
			int numAlive = 0;
			if(map[i-1] > 0) numAlive++;
			if(map[i+1] > 0) numAlive++;
			if(numAlive == 0) {
				if(map[i] != 0) {
					nextMap[i] = map[i] - 1;
				} else {
					nextMap[i] = map[i];
				}
			}
			if(numAlive == 1) {
				if(map[i] != 9) {
					nextMap[i] = map[i] + 1;
				} else {
					nextMap[i] = map[i];
				}
			}
			if(numAlive == 2) {
				if(map[i] != 0) {
					nextMap[i] = map[i] - 1;
				} else {
					nextMap[i] = map[i];
				}
			}
		}
		nextMap[0] = map[0];
		nextMap[map.length - 1] = map[map.length - 1];
		return nextMap;
	}
	
	/* 
	 * Create a new map using random number between 0 or 1
	 * @param map > starting map
	 * @return map > new map with random fill
	 */
	public static int[] preFill(int[] map) {
		for(int i = 0; i < map.length; i++) {
			map[i] = (int) (Math.random() * 6);
		}
		return map;
	}
	
	/*
	 * print the map out in one line
	 * @param map > the map to print out
	 */
	public static void printMap(int[] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.print(map[i]);
			//System.out.print((map[i] > 0)? "$" : " ");
		}
		System.out.println();
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
