import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void quickSort(long[] arr, int start, int end) {
		if (start >= end)
			return;
		int mid = partition(arr, start, end);
		if (start < mid)
			quickSort(arr, start, mid - 1);
		if (end > mid)
			quickSort(arr, mid + 1, end);
	}

	public static int partition(long[] arr, int start, int end) {
		int pivot = end;
		int i = start - 1;
		int j = end;

		for (;;) {
			while (arr[++i] < arr[pivot] && i < end)
				;
			while (arr[--j] > arr[pivot] && j > start)
				;

			if (i >= j)
				break;
			else {
				swap(arr, i, j);
			}
		}

		swap(arr, i, end);
		return i;

	}

	public static void swap(long[] arr, int index1, int index2) {
		long tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int inputCount = input.nextInt();
		long para = input.nextLong();

		if (inputCount > 100000 || para > 1000000000)
			return;
		int elementCount = 0;
		int tmpCount = 0;
		long tmp = 0;
		long M = 0;// save the max number
		long[] arr = new long[inputCount];
		int k = 0;
		if (input.hasNextLine()) {
			while (k < inputCount) {
				if (input.hasNext()) {
					if((tmp = input.nextLong()) > 1000000000)
						break;
					arr[k++] = tmp;
				} else
					break;
			}
		}
		if (k != inputCount)
			return;
		
		// Sort the array first using quicksort
		//quickSort(arr, 0, arr.length - 1);
		Arrays.sort(arr);
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			M = arr[i];
			while (j < arr.length && arr[j] * para < M)
				j++;
			tmpCount = i - j + 1;
			if (tmpCount > elementCount)
				elementCount = tmpCount;
		}

		System.out.println(elementCount);
	}

}