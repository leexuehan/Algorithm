package com.study;

/*
 * ��������
 * ˼·��Ҫ��֤��n��֮��ǰn���������ź����
 * �㷨���Ӷȣ� O(n^2)
 * */
public class InsertionSort {
	private static int[] arr = { 34, 8, 64, 51, 32, 21, 2 }; //��������
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; // �ȰѸ����ó���
			int j;
			//System.out.println("Loop : " + i);
			for (j = i; j > 0 && temp < arr[j - 1]; j--) {// ���α��������С���ó������Ǹ�����˳����ǰ��
				//System.out.println("j value: " + j);
				arr[j] = arr[j - 1];
			}
			arr[j] = temp; // �ٰ��ó����������ȥ
		}
	}
	public static void main(String[] args) {
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
