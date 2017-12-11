package BFS;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsClass {
	
	/* 
	 * FirstLineNum: 첫번째 줄에 있는 정점의 갯수
	 * LineNum: 총 간선의 갯수
	 * StartNum: 시작 정점의 번호
	 * 
	 * x, y: 이동을 위한 변수
	 * 
	 * graph: 이동하면서 담을 배열 변수
	 * 
	 * br: BufferedReader를 통해 입력을 받을 변수
	 * bw: BufferdWriter를 통해서 출력할 변수
	 * 
	 * st: String Class를 잘라주는 역할
	
	 
	*/
	
	static int FirstLineNum, LineNum, StartNum;
    static int x, y;
    static ArrayList<Integer> [] graph;
     
    static ArrayList<Integer> bfs;
     
    static boolean [] visit;  //이미 방문한 정점의 정보를 담을 배열
     
    static Queue<Integer> Q;
     
    static BufferedReader br;
    static BufferedWriter bw;
     
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		  
		br = new BufferedReader(new InputStreamReader(System.in));
	    bw = new BufferedWriter(new OutputStreamWriter(System.out));
	         
	    st = new StringTokenizer(br.readLine());
	         
	    FirstLineNum = Integer.parseInt(st.nextToken());
	    
	    LineNum = Integer.parseInt(st.nextToken());
	    
	    //
	    StartNum = Integer.parseInt(st.nextToken());
	         
	    graph = new ArrayList[LineNum + 1];
	        
	    //각 정점의 간선으로 연결되어있는 정점들에 대한 정보를 담을 리스트를 초기화
	    for (int i = 1; i <= LineNum; i++) {
	    	graph[i] = new ArrayList<Integer>();
	    }
	        
	    for (int i = 0; i < LineNum; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        x = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        
	        System.out.println(x + "에서 " + y + "로 이동");
	            
	        //방향성이 없는 그래프이기 때문에 연결되는 양쪽에 서로에 대한 정보를 넣어줌
	        graph[x].add(y);
	        System.out.println("graph[x]: "  + graph[x].toString());
	        
	        graph[y].add(x);
	        System.out.println("graph[y]: "  + graph[y].toString());
	    }
	         
	    //연결된 간선 정보를 정렬
	    for (int i = 1; i <= LineNum; i++){
	    	Collections.sort(graph[i]);	    	
	    }
	    
	    // 
	    bfsSol();
	    
	    // 결과 도출
	    for (int i = 0; i < bfs.size(); i++) {
	    	System.out.print(bfs.get(i)+ " ");
	    }
	}
	
	 private static void bfsSol(){
		 bfs = new ArrayList<Integer>();
		 visit = new boolean [LineNum +1];
		 Q = new LinkedList<Integer>();
	        
		 //시작정점을 큐에 넣어줌
		 Q.add(StartNum);
		 
		 //시작정점을 방문했다는 정보 저장
		 visit[StartNum] = true;
	        
		 //큐에 정점이 없어질 때까지 반복
		 while(!Q.isEmpty()){
	            
			 //큐에서 정점을 poll해서 이동함
			 int q = Q.poll();
	            
			 bfs.add(q);
			 
			 //이동한 정점에서 연결된 정점들을 큐에 넣어주고 visit배열에 체크
			 for(int i : graph[q]){
				 if(!visit[i]){
					 Q.add(i);
					 visit[i] = true;
				 }
			 }
		 }	         
	 }
}
