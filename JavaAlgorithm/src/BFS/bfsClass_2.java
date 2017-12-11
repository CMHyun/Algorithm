package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 인접행렬, visit을 이용한 Source

public class bfsClass_2 {

	static int[][] adjacencyMatrix;
    static boolean[] visit;
    static int vertexCount, edgeCount;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		vertexCount = scan.nextInt();
		edgeCount = scan.nextInt();
		adjacencyMatrix = new int[vertexCount+1][vertexCount+1];
        visit = new boolean[vertexCount+1];
        
        for(int i = 0; i < edgeCount; i++){
            int t1, t2;
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            
            adjacencyMatrix[t1][t2] = adjacencyMatrix[t2][t1] = 1;
        }
        
        bfs(1);
	}

	public static void bfs(int i){
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(i);
        visit[i] = true;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp);
            
            for(int j = 1; j <= vertexCount; j++){
                if(adjacencyMatrix[temp][j] == 1 && visit[j] == false){
                    q.offer(j);
                    visit[j] = true;                   // 큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
                    }
                }
            
            }    
    }	
}
