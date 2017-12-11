package Janggi;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

	public class JanggiClass {
		 
		// 좌표를 입력받기 위한 Class
		static class Point {
			   
				public int x;
				public int y;
							
				// Constructor
				public Point(int x, int y) {
					super();
					this.x = x;
					this.y = y;
				}				
				
				// Getter와 Setter
				public int getX() {
					return x;
				}
				
				public void setX(int x) {
					this.x = x;
				}
				
				public int getY() {
					return y;
				}
				
				public void setY(int y) {
					this.y = y;
				}				
		}
	
 
		@SuppressWarnings("resource")
		public static void main(String[] args) {
			
			/*
				입력 - N M (장기판)
				R C S K (말, 졸의 위치)
			*/
			
			int N, M, R, C, S, K;
			
			Queue<Point> queue = new LinkedList<Point>();
			
			Scanner sc = new Scanner(System.in);
			
			Point mal, zol;
			
			int[] x = {2, 2, -2, -2, 1, 1, -1, -1};
			int[] y = {-1, 1, -1, 1, -2, 2, -2, 2};
 
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			S = sc.nextInt();
			K = sc.nextInt();
   
			mal = new Point(R-1, C-1);
			zol = new Point(S-1, K-1);
   
			int[][] map = new int[N][M];
			
			for(int i = 0 ; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					map[i][j] = -1;
				}
			}
 
			map[mal.x][mal.y] = 0;  //말의 위치
			map[zol.x][zol.y] = -2; //졸의 위치
 
			queue.add(mal);
			
			while(!queue.isEmpty()) {
				
				Point st, end;
				st = (Point) queue.remove();
				//시작점이 됨.
   
				//8방향
				for(int i = 0 ; i < 8; ++i) {
					int xMap = st.x + x[i];
					int yMap = st.y + y[i];
     
					if(xMap < 0 || xMap >= N || yMap < 0 || yMap >= M) //바운더리 처리
						continue;
 
				//한번 방문한 곳은 한번만
				if(map[xMap][yMap] != 0 && map[xMap][yMap] != -1 && map[xMap][yMap] != -2) continue;
     
				end = new Point(xMap, yMap);
 
				//이 지점을 방문한 적이 없다면
				if(map[xMap][yMap] == -1) {
					//이전 인덱스 + 1
					map[xMap][yMap] = map[st.x][st.y] + 1;
				}
				
				//이 지점이 목표 지점이라면
				else if(map[xMap][yMap] == -2) {
					map[xMap][yMap] = map[st.x][st.y] + 1;//이전 인덱스 + 1
					System.out.println(map[xMap][yMap]);
					return;
				}
				
//    else //지나갔던 지점이라면
//    {
//     if(map[xMap][yMap] > map[st.x][st.y] + 1) //더 빠른 경로로 올 수 있다면.
//      map[xMap][yMap] = map[st.x][st.y] + 1;
//    }
				queue.add(end);
				}
			}
		} 
}