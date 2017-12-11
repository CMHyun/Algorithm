package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsClass_1 {

	// 인접 행렬
	static int[][] adjacencyMatrix;
	
	// 방문 확인
	static boolean[] isVisits;
	
	// 정점의 수
	static int vertexCount;
	
	// 간선의 수
	static int edgeCount;
	
	// Queue
	static Queue<Integer> queue;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		queue = new LinkedList<Integer>();
		
		System.out.print("정점의 수를 입력해주세요: ");
		vertexCount = sc.nextInt();
		System.out.println();
		
		System.out.print("간선의 수를 입력해주세요: ");
		edgeCount = sc.nextInt();
		
		adjacencyMatrix = new int[vertexCount][vertexCount];
		
		isVisits = new boolean[vertexCount];
		
		System.out.println("이어진 간선을 입력해주세요. "
				+ "입력 양식은 '1 3' 혹은 '2 4' 같이 띄어쓰기로 구분해주세요.");
		
		for (int i = 0; i < edgeCount; i++) {			
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			
			System.out.println("t1: " + t1 + " / t2: " + t2);
			
			adjacencyMatrix[t1-1][t2-1] = 1;
		}
		
		bfs(1);
	}
	
	public static void bfs(int v) {
		
		isVisits[v-1] = true;
				
		// Queue에 v를 넣는 부분
		queue.add(v);
		
		while(!queue.isEmpty()) {
			
			// queue에 있는 값을 꺼내어 v에 대입하는 부분
			v = (int)queue.poll();
						
			for (int i = 1; i < vertexCount+1; i++) {
				if(adjacencyMatrix[v-1][i-1] == 1 && !isVisits[i-1]) {
					//System.out.println(v + "에서 " + i + "로 이동하였습니다.");
					isVisits[i-1] = true;
					
					// Queue에 i를 넣는 부분
					queue.add(i);
				}
			}
			
			System.out.print(v + " ");
		}
	}

}
