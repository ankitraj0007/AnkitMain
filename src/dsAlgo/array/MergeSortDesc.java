package dsAlgo.array;

public class MergeSortDesc {

    public static void main(String[] args){
        int[] intArray = {20,35,-15,7,55,1,-22};
        sort(intArray , 0, intArray.length);
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int[] intArray, int start, int end){
        //base condition
        if(end-start<2){
            return;
        }

        //mid
        int mid= (start+end)/2;

        //left
        sort(intArray,start,mid);

        //right
        sort(intArray,mid,end);

        //merge
        merge(intArray,start,mid,end);
    }

    //{20,35,-15,7,55,1,-22}
    public static void merge(int[] intArray, int start, int mid, int end){
        if(intArray[mid-1]>=intArray[mid]){ //optimization
            return;
        }
        int i= start;
        int j=mid;
        int tempIndex=0;
        int[] tempArr= new int[end-start];

        while(i<mid && j<end){
            tempArr[tempIndex++]=intArray[i]>=intArray[j] ? intArray[i++]:intArray[j++];
        }

        System.arraycopy(intArray,i,intArray,start+tempIndex,mid-i);
        System.arraycopy(tempArr,0,intArray,start,tempIndex);
    }
}
