package com.study;

/*希尔排序
 * 最坏情形运行时间为： O(n^2)
 * 希尔排序的平均复杂度的证明非常复杂，未解决
 * 运行时间与选择的增量相关
 * */
public class ShellSort {
	//private static int[] arr = { 34, 8, 64, 51, 32, 21, 2 }; // 测试用例
	private static int[] arr = { 1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7,
			15, 8, 16 }; //最坏情形的一种特例

	public static void Sort(int [] arr) {
		for(int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			for(int i = gap; i < arr.length; i++) {
				int tmp = arr[i];
				int  j;
				for(j = i; j > gap && tmp < arr[j - gap]; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
