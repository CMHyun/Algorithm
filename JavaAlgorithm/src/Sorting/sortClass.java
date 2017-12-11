package Sorting;
import java.util.Scanner;


public class sortClass {

	static int array[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용할 배열의 크기: ");
		int arraySize = sc.nextInt();
		
		//System.out.println("사용자가 입력한 배열의 크기: " + arraySize);
		
		array = new int[arraySize];
		
		
		for (int i = 0; i < array.length; i++) {
			int random = (int)(Math.random()*100) +1;
			//System.out.println(random);
			
			array[i] = random;
		}
		
		

		// 버블 정렬		
		// BubbleSorting(array, array.length);
		
		// 삽입 정렬
		// InsertionSorting(array, array.length);
		
		// 퀵 정렬
		QuickSorting(array, 0, array.length-1);
		

		// 배열에 들어간 숫자를 확인을 위한 부분
		PrintArray(array);

	}
	
	
	
	public static void PrintArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	
	
	
	// 데이터를 차례대로 정렬하는 기법
	public static void BubbleSorting(int array[], int length) {
		
		int temp = 0;
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-(i+1); j++) {
				if(array[j] > array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		
	}	
	
	
	
	// 정렬할 데이터를 추출하여 앞으로 삽입하는 정렬 기법
	public static void InsertionSorting(int array[], int length) {
		
		// standardvalue: 기준이 되는 값
		int standardvalue = 0;
		
		// compare: 비교할 대상의 위치
		int  compare = 0;
		
		for (int i = 0; i < array.length; i++) {
			standardvalue = array[i];
			compare = i-1;
			
			//System.out.println("standardvalue= " + standardvalue);
			//System.out.println("compare= " + compare);
			//System.out.println("i= " + i);
			
			// 비교 대상의 위치가 0보다 앞이면서 기준값이 배열의 비교 대상의 값보다 큰 경우
			while(compare >= 0 && standardvalue < array[compare]) {
				//System.out.println("array[compare + 1]: " + array[compare + 1] + " / array[compare]: " + array[compare]);
				array[compare + 1] = array[compare];
				compare --;
			}
			
			array[compare + 1] = standardvalue;			
		}
	}
	
	
	// QuickSorting
	// 기준값을 기준으로 작은값은 좌측에 큰값은 우측에 정렬하는 기법
	public static int Partition(int array[], int left, int right) {

		//기준값		
		int pivot = array[(left+right)/2];
		
		while(left < right) {			
			while((array[left] < pivot) && (left < right)) 
				left++;
			
			while((array[right] > pivot) && (left < right))
				right--;
			
			// 좌측 위치가 우측 위치보다 작거나 같은 경우
			if(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}			
		}
		
		return left;
	}
	
	public static void QuickSorting(int array[], int left, int right) {
		
		System.out.println("left: " + left + " / right: " + right);
		
		if(left < right) {
			int pivotIndex = Partition(array, left, right);
			
			QuickSorting(array, left, pivotIndex-1);
			QuickSorting(array, pivotIndex+1, right);
		}
	}
	
	
	
	

}
