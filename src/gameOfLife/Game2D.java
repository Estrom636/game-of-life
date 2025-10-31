package gameOfLife;

public class Game2D {
	
	static String[][] map = new String[10][10];

	public static void main(String[] args) {
		map = preFill(map);
		printMap(map);
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
				System.out.print(map[i][j]);
				//System.out.print((map[i][j].equals("1")) ? "&" : " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
