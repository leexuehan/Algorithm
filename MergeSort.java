package com.study;

/*归并排序
 * 基本思路：合并两个已经排序的表
 * */
public class MergeSort {
	private static int[] arr = { 24, 13, 26, 1, 2, 27, 38, 15 };

	public static void sort(int[] arr, int[] temp, int start, int end) {
		System.out.println("Start is :" + start + ", End is:" + end);
		if (start == end)
			return;
		int mid = (start + end) / 2;
		sort(arr, temp, start, mid);
		sort(arr, temp, mid + 1, end);

		/* 合并排序表 */
		merge(arr, temp, start, mid, end);
	}

	public static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		if (start >= end)
			return;

		int i = start;
		int j = mid + 1;
		int k = start;

		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		/* 将剩下的按顺序拷贝进去临时数组 */
		if (i > mid) {
			while (j <= end)
				temp[k++] = arr[j++];
		}

		if (j > end) {
			while (i <= mid)
				temp[k++] = arr[i++];
		}

		/* 再将临时数组中排好序的数据拷贝到原始数组中 */

		for (i = 0, k = 0; i <= end; i++, k++) {
			System.out.print("temp[i] is : " + temp[i] + " ");
			arr[k] = temp[i];
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] temp = new int[arr.length];
		sort(arr, temp, 0, arr.length - 1);
		System.out.println("after been sorted");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
