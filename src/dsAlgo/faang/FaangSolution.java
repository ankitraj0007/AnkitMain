package dsAlgo.faang;

import dsAlgo.linkedlist.LinkedListSolution;
import dsAlgo.linkedlist.MyLinkedList;
import dsAlgo.linkedlist.MyNode;

import java.util.*;
import java.util.regex.Pattern;

public class FaangSolution {

    public static void main(String[] args) {
//        partialReverseLinkedList(3,5);
//        reverseLinkedList();
//        System.out.println(almostPalindrome());
//        System.out.println(palindrome());
//        longestSubstringWithoutRepeatingChar();
//        backspaceStringCompare();
        trappingRainWater();
//        maxAreaInTank();
//        System.out.println(findTargetPair(new int[]{1,3,4,5,6,8},10));
    }

    //revert a linked list from m to n
    public static void partialReverseLinkedList(int m, int n){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 7; i++){
            myLinkedList.addInLast(i);
        }
        myLinkedList.print();

        int position = 1;
        MyNode initialSegmentEndNode = null;
        MyNode currentNode = myLinkedList.getHead();
        while (position < m){
            initialSegmentEndNode = currentNode;
            currentNode = currentNode.getNext();
            position++;
        }

        MyNode pointer1 = currentNode;
        MyNode start = currentNode;
        MyNode pointer2 = currentNode.getNext();
        MyNode buff = null;
        //1,2,3,4,5,6,7
        while (position >= m && position <n){
            buff = pointer2.getNext();

            pointer2.setNext(pointer1);
            pointer1 = pointer2;
            pointer2 = buff;

            position++;
        }
        initialSegmentEndNode.setNext(pointer1);
        start.setNext(pointer2);
        System.out.println("========");
        myLinkedList.print();

    }

    //reverse a linked list
    public static void reverseLinkedList(){
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 1; i <= 7; i++){
            linkedList.addInLast(i);
        }
        linkedList.print();

        //solution
        MyNode prevNode = null;
        MyNode currentNode = linkedList.getHead(); //1

        //1,2,3,4,5,6,7
        while (currentNode != null){
            MyNode nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        linkedList.setHead(prevNode);
        linkedList.print();
    }

    // by removing a char can string be made a palindrome
    public static boolean almostPalindrome(){
        String s = "race a car";
        String replace = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(replace);

        int left = 0;
        int right = replace.length() - 1;

        while (left <= right){
            if(replace.charAt(left) != replace.charAt(right)){
                return checkForSubPalindrome(replace, left+1, right) || checkForSubPalindrome(replace, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkForSubPalindrome(String s, int left, int right){
        while (left <= right) {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean palindrome(){
        String s = "A man, a plan, a canal : Panama";
        String replace = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(replace);

        int left = 0;
        int right = replace.length() - 1;
        while (left <= right) {
            if(replace.charAt(left) != replace.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void longestSubstringWithoutRepeatingChar(){
        String str = "abcbdaac"; //cbda -> 4

        int length = str.length();
        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (rightPointer < length){

            if(map.containsKey(str.charAt(rightPointer)) && map.get(str.charAt(rightPointer)) > leftPointer){
                leftPointer = map.get(str.charAt(rightPointer)) + 1;
            }

            if(maxLength < rightPointer - leftPointer + 1){
                maxLength = rightPointer - leftPointer + 1;
            }

            map.put(str.charAt(rightPointer),rightPointer);
            rightPointer++;
        }

        System.out.println(maxLength);



    }

    // backspace string compare
    // consider # will remove the previous character in the string
    // compare two string if same or not
    public static void backspaceStringCompare(){
        String str1 = "a#zc";
        String str2 = "b#a#zz#c";

        StringBuilder sb1 = buildString(str1);
        StringBuilder sb2 = buildString(str2);

        if(sb1.length() != sb2.length()){
            System.out.println(false);
        }else{ // also can use string equals method instead of for loop
//            System.out.println(sb1.toString().equals(sb2.toString()));
            for(int i = 0; i < sb1.length(); i++){
                if(sb1.charAt(i) != sb2.charAt(i)){
                    System.out.println(false);
                    return;
                }
            }
            System.out.println(true);
        }

        //optimized
//        int len1 = str1.length() - 1;
//        int len2 = str2.length() - 1;
//
//
//        while (len1 >= 0 || len2 >=0){
//
//            if(str1.charAt(len1) == '#' || str2.charAt(len2) == '#'){
//                if(str1.charAt(len1) == '#'){
//                    int backCount = 2;
//                    while (backCount > 0){
//                        len1--;
//                        backCount--;
//                        if(str1.charAt(len1) == '#'){
//                            backCount = backCount + 2;
//                        }
//                    }
//                }else{
//                    int backCount = 2;
//                    while (backCount > 0){
//                        len2--;
//                        backCount--;
//                        if(str2.charAt(len2) == '#'){
//                            backCount = backCount + 2;
//                        }
//                    }
//                }
//            }
//
//            else {
//                if(str1.charAt(len1) != str2.charAt(len2)){
//                    System.out.println(false);
//                    return;
//                }else {
//                    len1--;
//                    len2--;
//                }
//            }
//
//        }
//
//        System.out.println(true);
    }

    public static StringBuilder buildString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                if(stringBuilder.length()>0){
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder;
    }

    //trappingRainWater, entries are block
    public static void trappingRainWater(){
        int[] arr = {0,1,0,2,1,0,3,1,0,1,2};//0+0+1+0+1+2+0+1+2+1+0
        int waterAccumulated = 0;

        int leftPointer = 0;
        int rightPointer = arr.length-1;
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];

        //{0,1,0,2,1,0,3,1,0,1,2};//0+0+1+0+1+2+0+1+2+1+0
        while(leftPointer < rightPointer){

            if(arr[leftPointer] <= arr[rightPointer]){
                if (arr[leftPointer] >= leftMax ){
                    leftMax = arr[leftPointer];
                }else {
                    int volume = leftMax - arr[leftPointer];
                    waterAccumulated = waterAccumulated + volume;
                }
                leftPointer++;
            }else{
                if(arr[rightPointer] >= rightMax){
                    rightMax = arr[rightPointer];
                }else {
                    int volume = rightMax - arr[rightPointer];
                    waterAccumulated = waterAccumulated + volume;
                }
                rightPointer--;
            }
        }
        System.out.println(waterAccumulated);

        //n2 solution
//        for (int i = 1; i <= arr.length-2; i++){
//
//            //back support wall
//            int backSupport = arr[i-1];
//            for(int j = i-1; j > 0; j--){
//                if(arr[j]>backSupport){
//                    backSupport = arr[j];
//                }
//            }
//
//            //front support wall
//            int frontSupport = arr[i+1];
//            for(int j = i+2; j<arr.length; j++){
//                if(arr[j]>frontSupport){
//                    frontSupport = arr[j];
//                }
//            }
//
//            //0+0+1+0+1+2+0+1+2+1+0
//            if(frontSupport > arr[i] && backSupport > arr[i]){
//                int volume = backSupport < frontSupport ? backSupport-arr[i] : frontSupport-arr[i];
//                waterAccumulated = waterAccumulated + volume;
//            }
//
//
//        }
//        System.out.println(waterAccumulated);

    }

    // {1,8,6,2,9,4} each represents line
    // find max area that can be formed
    public static void maxAreaInTank(){
        //two shifting pointers
        int[] arr = {1,8,6,2,9,4};
        int maxArea =0 ;
        int start = 0;
        int end = arr.length-1;
        int leftPointer = 0;
        int rightPointer = arr.length-1;
        while(leftPointer < rightPointer){
            int height = arr[leftPointer] < arr[rightPointer] ? arr[leftPointer] : arr[rightPointer];
            int area = height * (rightPointer-leftPointer);

            if(maxArea < area){
                maxArea = area;
                start=leftPointer;
                end=rightPointer;
            }

            //moving lesser value as bigger value is likely to keep area more
            if(arr[leftPointer] < arr[rightPointer]){
                leftPointer++;
            }else {
                rightPointer--;
            }
        }
        System.out.println("maxArea: "+maxArea + ", start: "+ start+", end: "+end);

        //n2 solution
//        int[] arr = {1,8,6,2,9,4};
//
//        int maxArea = 0;
//        int start = 0;
//        int end = 0;
//        int height;
//
//        for(int i =0; i<arr.length; i++){
//            for (int j = i+1; j<arr.length; j++){
//                height = arr[i]<arr[j] ? arr[i] : arr[j];
//                int area = (j-i)*height;
//                if(maxArea<area){
//                    maxArea=area;
//                    start=i;
//                    end=j;
//                }
//            }
//        }
//        System.out.println("maxArea: "+maxArea + ", start: "+ start+", end: "+end);

    }

    //{1,3,4,5,6,8} -> 10
    //optimized solution to find if 10 is sum of 2 element in the arr
    public static int[] findTargetPair(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0 ; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int[] resultArr = new int[2];
                resultArr[0]=map.get(arr[i]);
                resultArr[1]= target - arr[i];
                System.out.println(arr[i]+", "+(target - arr[i]));
                return resultArr;
            }
            int pairToBe = target - arr[i];
            map.put(pairToBe,i);
        }
        return null;

        //n2 solution
//        int[] resultArr = new int[2];
//        for(int i = 0; i<arr.length; i++){
//            for (int j = i+1; j<arr.length; j++){
//                if(arr[i]+arr[j] == target){
//                    resultArr[0]=i;
//                    resultArr[1]=j;
//                    return resultArr;
//                }
//            }
//        }
//        return null;
    }
}
