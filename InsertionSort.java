package com.study;

/*
 * 插入排序
 * 思路：要保证第n趟之后，前n个数字是排好序的
 * 算法复杂度： O(n^2)
 * */
public class InsertionSort {
	private static int[] arr = { 34, 8, 64, 51, 32, 21, 2 }; //测试用例
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; // 先把该数拿出来
			int j;
			//System.out.println("Loop : " + i);
			for (j = i; j > 0 && temp < arr[j - 1]; j--) {// 依次遍历，如果小于拿出来的那个数则顺次往前移
				//System.out.println("j value: " + j);
				arr[j] = arr[j - 1];
			}
			arr[j] = temp; // 再把拿出来的数填补上去
		}
	}
	public static void main(String[] args) {
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
