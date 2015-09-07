package com.study;

/*
 * ������
 * ʱ�临�Ӷ�: O(NlogN)
 * �ռ临�Ӷȣ�O(N),��Ϊ��Ҫһ����������
 * */
public class HeapSort {
	private static int[] arr = { 0, 81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41,
			23, 100 };

	/* �������ĵ�һ��Ԫ����0����ζ���±��1��ʼ���� */
	public static void Sort(int[] arr, int[] result) {
		int j = arr.length - 1;
		int len = j;
		for (int i = 0; i < arr.length - 1; i++, j--) {
			BuildMaxHeap(arr, len--);
			result[i] = arr[1];
			arr[1] = arr[j];
		}
	}

	public static void BuildMaxHeap(int[] arr, int len) { // �����󶥶�
		for (int i = len / 2; i > 0; i--)
			// �����һ���к��ӵĽڵ㿪ʼ�³�
			percolateDown(i, arr, len);
	}

	public static void percolateDown(int hole, int[] arr, int len) {
		int tmp = arr[hole]; // �ȰѸýڵ��ó���
		int child;
		for (; hole * 2 <= len; hole = child) { // Ҫ����hole�ķ�Χ����ֹ���
			child = 2 * hole; // ���ӽڵ�
			/* �����һ���ڵ�ͬʱ���������ӵ�ʱ�򣬶����Һ��ӵĴ�С */
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
