package gameOfLife;

public class Game2D {
	
	static String[][] map = new String[1000][1000];

	public static void main(String[] args) {
		map = preFill(map);
		String[][] firstMap = map;
		printMap(map);
		for(int i = 0; i < 167; i++) {
			delay(0.1);
			map = nextMap(map);
			printMap(map);
		}
		printStats(firstMap);
		printStats(map);
	}
	
	public static String[][] nextMap(String[][] map){
		int[][] mapI = toInt(map);
		String[][] nextMap = new String[map.length][map[0].length];
		int rows = map.length;
		int cols = map[0].length;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				int count = 0;
				for(int di = -1; di <= 1; di++) {
					for(int dj = -1; dj <= 1; dj++) {
						if(!(di == 0 && dj == 0)) {
							int ni = (i + di + rows) % rows;
							int nj = (j + dj + cols) % cols;
							if(mapI[ni][nj] == 1) {
								count++;
							}
						}
					}
				}
				if(mapI[i][j] == 1) {
					if(count == 2 || count == 3) {
						nextMap[i][j] = "1";
					} else {
						nextMap[i][j] = "0";
					}
				} else {
					if(count == 3) {
						nextMap[i][j] = "1";
					} else {
						nextMap[i][j] = "0";
					}
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
	public static String[][] preFill(String[][] map){
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				int value = (int) (Math.random() * 2) - 0;
				if(value < 0) value = 0;
				map[i][j] = Integer.toString(value);
			}
		}
		return map;
	}
	
	/*
	 * print the map out in one line
	 * @param map > the map to print out
	 */
	public static void printMap(String[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				//System.out.print(map[i][j]);
				System.out.print((map[i][j].equals("1")) ? "@" : " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/*
	 * Convert the given map from int to string
	 * @param map > the map to convert
	 * @return newMap > the converted map
	 */
	public static int[][] toInt(String[][] map){
		int[][] newMap = new int[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				newMap[i][j] = Integer.parseInt(map[i][j]);
			}
		}
		return newMap;
	}
	
	/*
	 * Convert the given map from int to string
	 * @param map > the map to convert
	 * @return newMap > the converted map
	 */
	public static String[][] toString(int[][] map){
		String[][] newMap = new String[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				newMap[i][j] = Integer.toString(map[i][j]);
			}
		}
		return newMap;
	}
	
	/*
	 * prints out the statistics of the given map
	 * stats: number alive, number dead, percent alive
	 * @param map > the map for statistics
	 */
	public static void printStats(String[][] map) {
		int numAlive = 0;
		int numDead = 0;
		int percentAlive = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				int num = Integer.parseInt(map[i][j]);
				if(num == 0) numDead++;
				if(num == 1) numAlive++;
			}
		}
		
		percentAlive = (int) (((double)numAlive / (map.length * map[0].length)) * 100);
		
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
