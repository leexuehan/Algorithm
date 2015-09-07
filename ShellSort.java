package com.study;

/*ϣ������
 * ���������ʱ��Ϊ�� O(n^2)
 * ϣ�������ƽ�����Ӷȵ�֤���ǳ����ӣ�δ���
 * ����ʱ����ѡ����������
 * */
public class ShellSort {
	//private static int[] arr = { 34, 8, 64, 51, 32, 21, 2 }; // ��������
	private static int[] arr = { 1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7,
			15, 8, 16 }; //����ε�һ������

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
