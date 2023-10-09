package dsAlgo.array;

public class CountingSort {

    public static void main(String[] args){
        int[] intArray = {2,5,9,8,2,3,4,10,8,7};
        sort(intArray,1,10);
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int[] intArray, int min, int max){
        int[] countArr= new int[max-min+1];
        for(int i=0; i<intArray.length; i++){
            countArr[intArray[i]-min]++;
        }

        int a=0;
        for(int j=0;j<max-min+1;j++){
            for(int i=a;i<intArray.length;i++){

                if(countArr[j]==0){
                    break;
                } else{
                    intArray[i]=min+j;
                    countArr[j]--;
                    a++;
                }
            }

        }


    }
}
