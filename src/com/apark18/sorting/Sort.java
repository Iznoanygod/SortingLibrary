package com.apark18.sorting;

public class Sort {
	public static void bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
  
  public static void combSort(int[] array) {
		int gap = array.length;
		boolean swapped = true; 
		int i;
		while (gap > 1 || swapped) {
			if (gap > 1) 
				gap = (int)(gap / 1.3);
			if (gap == 9 || gap == 10) 
				gap = 11;
			i = 0;
			swapped = false;
			while (i + gap < array.length) {
				if (array[i] > array[i+gap]) {
					swapC(array, i, i+gap);
					swapped = true;
				}
				i++;
			}
		} 
	}
	public static void swapC(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
  
  public static void insertionSort(int[] array){
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int possibleIndex = i;
			while(possibleIndex > 0 && temp < array[possibleIndex - 1]){
				array[possibleIndex] = array[possibleIndex - 1];
				possibleIndex--;
			}
			array[possibleIndex] = temp;
		}
	}
  
  public static void mergeSort(int [] array) {
		if (array.length <= 1) {
			return;
		}
		int[] first = new int[array.length / 2];
		int[] second = new int[array.length - first.length];
		System.arraycopy(array, 0, first, 0, first.length);
		System.arraycopy(array, first.length, second, 0, second.length);
		mergeSort(first);
		mergeSort(second);
		merge(first, second, array);
	}
	    
	private static void merge(int[] first, int[] second, int [] result) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				result[j] = first[iFirst];
				iFirst++;
			} else {
				result[j] = second[iSecond];
				iSecond++;
	            	}
	            j++;	
	        }	
		System.arraycopy(first, iFirst, result, j, first.length - iFirst);
		System.arraycopy(second, iSecond, result, j, second.length - iSecond);
	}
  
  private static int arr[];
	public static void quickSort(int[] array){
		arr = array;
		int left = 0;
		int right = arr.length-1;
			
		quickSort(left, right);
	}
	private static void quickSort(int left, int right){
		
		if(left >= right)
			return;
		
		int pivot = arr[right];
		int partition = partition(left, right, pivot);
		
		quickSort(0, partition-1);
		quickSort(partition+1, right);
	}
	private static int partition(int left,int right,int pivot){
		int leftCursor = left-1;
		int rightCursor = right;
		while(leftCursor < rightCursor){
                while(arr[++leftCursor] < pivot);
                while(rightCursor > 0 && arr[--rightCursor] > pivot);
			if(leftCursor >= rightCursor){
				break;
			}else{
				swapQ(leftCursor, rightCursor);
			}
		}
		swapQ(leftCursor, right);
		return leftCursor;
	}
	public static void swapQ(int left,int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
  
  public static void selectionSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int minIndex = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
    
    public static void shellSort(int[] array) {
		int inner, outer;
		int temp;
		int h = 1;
		while (h <= array.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (outer = h; outer < array.length; outer++) {
				temp = array[outer];
				inner = outer;
				while (inner > h - 1 && array[inner - h] >= temp) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
	}
}