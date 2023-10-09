package dsAlgo.array;

public class MergeSort {

    public static void main(String[] args){
        int[] intArray = {20,35,-15,7,55,1,-22};
//        sort(intArray,0,intArray.length);
        sort(intArray,0,intArray.length-1);
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int arr[], int l, int r){
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

//    public static void sort(int[] intArray, int start, int end){
//
//        if(end-start<2){
//            return;
//        }
//
//        int mid = (start+end)/2;
//        sort(intArray,start,mid);
//        sort(intArray,mid,end);
//
//        merge(intArray,start,mid,end);
//    }
//    //{20,35,-15,7,55,1,-22}
//    public static void merge(int[] intArray, int start, int mid, int end){
//        if(intArray[mid-1]<=intArray[mid]){ //optimization
//            return;
//        }
//        int i= start;
//        int j=mid;
//        int tempIndex=0;
//        int[] tempArr= new int[end-start];
//
//        while(i<mid && j<end){
//            tempArr[tempIndex++]=intArray[i]<=intArray[j] ? intArray[i++]:intArray[j++];
//        }
//
//        System.arraycopy(intArray,i,intArray,start+tempIndex,mid-i);
//        System.arraycopy(tempArr,0,intArray,start,tempIndex);
//    }
}
