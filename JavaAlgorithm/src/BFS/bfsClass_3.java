package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 인접List, HashMap을 이용한 Source

public class bfsClass_3 {

	static ArrayList<ArrayList<Integer>> ad;
    static boolean[] visit;
    static int Ne, Nv;

    
    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        
        q.offer(i);
        
        while(!q.isEmpty()){
            int temp = q.poll();
            visit[temp] = true;
            System.out.print(temp);
            
            for(int j : ad.get(temp)){
                if(visit[j] == false && !hash.containsKey(j)){
                    q.offer(j);
                    hash.put(j, true);
                }
            }
        }        
    }
    
    public static void main(String[] args) {
        
    	// Scanner를 통해 Console창에서 입력을 받는다.
    	Scanner scan = new Scanner(System.in);
        
    	System.out.print("Nv를 입력하시오: ");
    	Nv = scan.nextInt();
    	
    	System.out.print("Ne를 입력하시오: ");
        Ne = scan.nextInt();
        
        ad = new <ArrayList<Integer>> ArrayList(Nv+1);
        
        // Nv보다 +1한 크기의 boolean 배열을 생성한다.
        visit = new boolean[Nv+1];
        
        for(int i = 0; i <= Nv+1; i++){
            ad.add(new ArrayList());
        }
        
        for(int i = 0; i < Ne; i++){
            int t1, t2;
            
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            
            ad.get(t1).add(t2);
            ad.get(t2).add(t1);    
        }
        
        bfs(1);
    }	
}
