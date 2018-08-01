import java.util.Arrays;

public class SortingAnalysis {

	public static void main(String[] args) {

		ReadFiles file1 = new ReadFiles();

		int[] numbers = file1.readFileToArray("D:\\Programming\\Eclipse Workspace\\Sorting Analysis\\Files\\50000_ascending_order.txt");
		System.out.println(Arrays.toString(numbers));

//------------------------ Insertion Sort Call --------------------------------------------
		long insertionStart = System.currentTimeMillis();
		
		insertionSort(numbers, 5000);
		System.out.println("Sorted result: ");
		for (int i = 0; i < 5000; i++) {
			System.out.println(numbers[i] + " ");
		}
		
		long insertionFinish = System.currentTimeMillis();
		long totalInsertionTime = insertionFinish - insertionStart;
		
		System.out.println("Total running time of the insertion sort algorithm: " + totalInsertionTime);
		
//------------------------ Merge Sort Call --------------------------------------------
		long mergeStart = System.currentTimeMillis();
		
		mergeSort(numbers, 0, 49999);
		System.out.println("Sorted result: ");
		for (int i = 0; i < 50000; i++) {
			System.out.println(numbers[i] + " ");
		}
		
		long mergeFinish = System.currentTimeMillis();
		long totalMergeTime = mergeFinish - mergeStart;

		System.out.println("Total running time of the merge sort algorithm: " + totalMergeTime);	
	}
	
	
	

//	------------------------ Insertion Sort Algorithm Implementation --------------------------------------------
	
		public static void insertionSort(int[]numberList, int arraySize) {
			
			int i = 0;
			int j = 0;
			int temp = 0;
			
			for(i = 1; i < arraySize; i++){
				j = i;
				while(j > 0 && numberList[j] < numberList[j-1]) {
					temp = numberList[j];
					numberList[j] = numberList[j-1];
					numberList[j-1] = temp;
					j--;
				}
			}
		}
		
		
		
		
//	------------------------ Merge Sort Algorithm Implementation -------------------------------------------

	public static void mergeSort(int[] array, int lowIndex, int highIndex) {
		
		if (lowIndex >= highIndex) {
			return;
		}
		else {
			int middleIndex = (lowIndex + highIndex) / 2;
			mergeSort(array, lowIndex, middleIndex);
			mergeSort(array, middleIndex + 1, highIndex);
			
			finalMerge(array, lowIndex, middleIndex, highIndex);
		}
	}
	
	public static void finalMerge(int[] array, int lowIndex, int middleIndex, int highIndex) {
		int mergedSize = highIndex - lowIndex + 1;
		int mergedNumbers[] = new int[mergedSize];
		
		int mergedPosition =0;
		int leftPosition = 0;
		int rightPosition = 0;
		
		leftPosition = lowIndex;
		rightPosition = middleIndex + 1;
		
		while (leftPosition <= middleIndex && rightPosition <= highIndex) {
			if(array[leftPosition] < array[rightPosition]) {
				mergedNumbers[mergedPosition] = array[leftPosition];
				leftPosition++;
			}
			else {
				mergedNumbers[mergedPosition] = array[rightPosition];
				rightPosition++;
			}
			mergedPosition++;
		}
		
		while(leftPosition <= middleIndex) {
			mergedNumbers[mergedPosition] = array[leftPosition];
			leftPosition++;
			mergedPosition++;
		}
		
		while(rightPosition <= highIndex) {
			mergedNumbers[mergedPosition] = array[rightPosition];
			rightPosition++;
			mergedPosition++;
		}
		
		for (int i = 0; i < mergedSize; i++) {
			array[lowIndex + i] = mergedNumbers[i];
		}
		
		
	}

}
