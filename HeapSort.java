package com.study;

/*
 * 堆排序
 * 时间复杂度: O(NlogN)
 * 空间复杂度：O(N),因为需要一个辅助数组
 * */
public class HeapSort {
	private static int[] arr = { 0, 81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41,
			23, 100 };

	/* 这个数组的第一个元素是0，意味着下标从1开始排序 */
	public static void Sort(int[] arr, int[] result) {
		int j = arr.length - 1;
		int len = j;
		for (int i = 0; i < arr.length - 1; i++, j--) {
			BuildMaxHeap(arr, len--);
			result[i] = arr[1];
			arr[1] = arr[j];
		}
	}

	public static void BuildMaxHeap(int[] arr, int len) { // 构建大顶堆
		for (int i = len / 2; i > 0; i--)
			// 从最后一个有孩子的节点开始下沉
			percolateDown(i, arr, len);
	}

	public static void percolateDown(int hole, int[] arr, int len) {
		int tmp = arr[hole]; // 先把该节点拿出来
		int child;
		for (; hole * 2 <= len; hole = child) { // 要限制hole的范围，防止溢出
			child = 2 * hole; // 孩子节点
			/* 在最后一个节点同时有两个孩子的时候，断左右孩子的大小 */
			if (child != arr.length - 1 && arr[child] < arr[child + 1])
				child++;
			if (tmp < arr[child])
				arr[hole] = arr[child];
			else
				break;
		}
		arr[hole] = tmp;
	}

	public static void main(String[] args) {
		int[] result = new int[arr.length - 1];
		Sort(arr, result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
