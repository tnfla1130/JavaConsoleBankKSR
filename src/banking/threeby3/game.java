package banking.threeby3;

import java.util.Arrays;
import java.util.Random;

public class game {

	Random random = new Random();
	final int A=1, B=2, C=3, D=4, E=5, F=6, G=7, H=8;
	final char X=0;
	int[][] arr = new int[3][3];
	
	public void start() {
		int[][] arr = {
			{A,B,C},
			{D,E,F},
			{G,H,X}
		};
		int x = 2; 
        int y = 2;
		int[][] directions = {
	            {-1, 0}, // 위
	            {1, 0},  // 아래
	            {0, -1}, // 왼쪽
	            {0, 1}   // 오른쪽
	        };

	    String[] dirNames = {"↑", "↓", "←", "→"};
	    while (true) {
            int dir = random.nextInt(100);
            int rand_dir = dir%3;
            int newX = x + directions[rand_dir][0];
            int newY = y + directions[rand_dir][1];

            if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
                // 값 스왑
                int temp = arr[x][y];
                arr[x][y] = arr[newX][newY];
                arr[newX][newY] = temp;
                
                System.out.println(rand_dir);
                System.out.println("방향: " + dirNames[rand_dir]);
                break;
            }
        }

        // 결과 출력
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

	}
	
	public static void main(String[] args) {
		game game = new game();
		game.start();
		
	}
}
