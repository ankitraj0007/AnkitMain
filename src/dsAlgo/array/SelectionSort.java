package dsAlgo.array;

public class SelectionSort {

    public static void main(String[] args){
        int[] intArray = new int[7];
        intArray[0]=20;
        intArray[1]=35;
        intArray[2]=-15;
        intArray[3]=7;
        intArray[4]=55;
        intArray[5]=1;
        intArray[6]=-22;

        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }

        int lastUnsortedIndex=intArray.length-1;
        int buffer;
        for(int a=0;a<intArray.length-1;a++){
            int largest=0;
            for(int b=0;b<=lastUnsortedIndex;b++){
                if(intArray[b]>intArray[largest]){
                    largest=b;
                }
            }
            buffer=intArray[lastUnsortedIndex];
            intArray[lastUnsortedIndex]=intArray[largest];
            intArray[largest]=buffer;
            lastUnsortedIndex--;
        }

        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}
