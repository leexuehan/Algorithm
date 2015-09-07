package com.study;
import java.util.Random;
/*快速排序
 * 平均复杂度：O(NlogN)
 * 最坏情况时间复杂度： O(NlogN)
 * 空间复杂度： O(logN) ~  O(N)
 * 最坏情况： O(N)
 * 平均： O(logN)
 * */
public class QuickSort {
	// private static int[] arr = { 81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41,
	// 23 };  
	//private static int[] arr = { 1, 2, 2, 3, 5, 5, 6, 4, 4, 8 };
	// private static int[] arr = { 10, 15, 9, 5, 6, 8, 11 };
	private static int[] arr = {1,2,1,1,1,1,2,1};

	public static void Sort(int[] arr, int s_index, int t_index) {
		if (s_index == t_index)
			return;
		if(s_index < t_index) {
			int mid = Partition(arr, s_index, t_index);
			if (s_index < mid)
				Sort(arr, s_index, mid - 1);
			if (t_index > mid)
				Sort(arr, mid + 1, t_index);
		}
	}

	public static int Partition(int[] arr, int start, int end) {
		int index = new Random().nextInt(end - start) + start; //
		// 产生[start,end)区间的随机数
		/*System.out.println("index is :" + index + ";  indexNumber is: "
				+ arr[index]);*/
		int pivot = arr[index];
		swap(arr, index, end);
		int i = start - 1;
		int j = end;
		for (;;) {
			while (arr[++i] < pivot && i < end)
				;
			while (arr[--j] > pivot && j > start)
				;
			if (i < j)
				swap(arr, i, j);
			else
				break;
		}
		swap(arr, i, end);
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
		return i;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Sort(arr, 0, arr.length - 1);
		System.out.println("after been sorted");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
