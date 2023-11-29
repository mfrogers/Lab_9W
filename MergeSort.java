package Lab9;

public class MergeSort {
    
	/*
	 * 
	 * You need to complete the sort method. Note that you can and should
	 * introduce helper methods to implement the merge sort algorithm.
	 * 
	 * 
	 */
	
	
	
	
	
    /**
     * @param input array of integer values
     * @return sorted array
     */
    public static int[] sort(int[] input){
    	int[] returner = new int[input.length];
    	if(input.length<2) {
    		return input;
    	}
    	int splitPoint = input.length-1/2; //2 when length 6
    	int[] subOneArr = new int[splitPoint+1];
    	int[] subTwoArr = new int[input.length-splitPoint+1];
    	subOneArr = getSubArr(input,0,splitPoint);
    	subTwoArr = getSubArr(input,splitPoint+1,input.length+1);
    	
    	
    	returner = order(subOneArr,subTwoArr);
        return returner;
    }
    
    
    
    /**
     * Gets a subsection of an array
     * 
     * 
     * @param input Array to split
     * @param start Index of first element to include
     * @param end Index of last element to include
     * @return Array containing only the elements between and including on start and end indices
     */
    public static int[] getSubArr(int[] input, int start, int end) {
    	if(start<0||end<start||end>input.length-1) {
    		return input;
    	}
    	int split = end - start;
    	int[] subArr = new int[split+1];
    	int subInd = 0;
    	for(int i = start;i<=end;i++) {
    		subArr[subInd] = input[i];
    		subInd++;
    	}
    	return subArr;
    	
    }
    
    
    
    /**
     * 
     * 
     * 
     * 
     */
    public static int[] order(int[] inputA, int[] inputB) {
    	int[] returner = new int[inputA.length+inputB.length];
    	int[] first = new int[];
    	int[] second = new int[];
    	int firstInd = 0;
    	int secondInd = 0;
    	if(inputA.length>inputB.length) {
    		first = inputA;
    		second = inputB;
    	}else {
    		first = inputB;
    		second = inputA;
    	}
    	while(firstInd<first.length||secondInd<second.length) {
    		if(firstInd>first.length) {
    			returner += second[secondInd];
    			secondInd++;
    		}else if(secondInd>second.length) {
    			returner += first[firstInd];
    			firstInd++;
    		}
    		
    		if(first[firstInd]<second[secondInd]) {
    			returner += first[firstInd];
    			firstInd++;
    		}else {
    			returner+= second[secondInd];
    			secondInd++;
    		}
    	}
    	return returner;
    }
    
    
    
    
}
