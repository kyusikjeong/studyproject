package ex1;

import java.util.Arrays;

import java.util.Collections;

public class Ex5_Attrays {
	private String[] arr = {"Z","X","A","C","B"};
	private Integer[] number = {10,3,11,40,22,12};
	public Ex5_Attrays() {
		//오름차순 정렬, 내림차순
		Arrays.sort(arr,Collections.reverseOrder());
		for(String e : arr) {
			System.out.println(e+" ");
		}
		//내림차순 하려면 Arrays.sort(number);
		Arrays.sort(number,Collections.reverseOrder());
		for(int e: number) {
			System.out.println(e+ " ");
		}
	}
	
	public static void main(String[] args) {
		new Ex5_Attrays();
	}
}
