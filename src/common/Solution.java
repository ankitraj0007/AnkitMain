package common;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

//        splitArray();
//        duplicateInSets();
//        immutable();
//        anagramString();
        findNumberOfWordsWithSameCharacters();
//        maxSumSubArray();
//        balancedSubArrayLength();
//        combinationWithTargetSum();
//        target();
//        reverseWords();
//        patternRowColumn();
//        balancedBrackets();
//        System.out.println(fibonacciUsingRecursion(4));
//        System.out.println(isOnlyOdd(new int[]{1, 5, 7, 9, 2}));
    }



    /* int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int splitSize = 3;
    expected Output
    [0, 1, 2]
    [3, 4, 5]
    [6, 7, 8]
    [9]
    */
    public static List<Integer[]> splitArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int splitSize = 3;

        List<Integer[]> finallist = new ArrayList<>();

        int startIndex = 0;
        int numberOfArrays = 0;
        int numberOfElementInLastArray = splitSize;

        if (array.length % splitSize == 0) {
            numberOfArrays = array.length / splitSize;
        } else {
            numberOfArrays = array.length / splitSize + 1;
            numberOfElementInLastArray = array.length % splitSize;
        }

        for (int i = 1; i <= numberOfArrays; i++) {
            int arrSize = splitSize;
            if(i == numberOfArrays){
                arrSize = numberOfElementInLastArray;
            }
            Integer[] intArr = new Integer[arrSize];

            for (int j = 0; j < arrSize; j++) {
                intArr[j] = array[startIndex++];
            }
            finallist.add(intArr);
        }

        finallist.forEach(arr -> System.out.println(Arrays.toString(arr)));
        return finallist;
    }

    //number of duplicate/more than 1 occurrence in multiple sets
    //[1,2,3,4] [1,2,5,6] [1,7,8,9]
    public static void duplicateInSets(){

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(5);
        set2.add(6);

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(7);
        set3.add(8);
        set3.add(9);

        List<Set<Integer>> setList = new ArrayList<>();
        setList.add(set1);
        setList.add(set2);
        setList.add(set3);

        //solution
        Set<Integer> result = new HashSet<>();
        AtomicInteger count = new AtomicInteger();

        setList.forEach(set -> {
            set.forEach(integer -> {
                if(!result.add(integer)){
                    count.getAndIncrement();
                }
            });
        });

        System.out.println(count.get());
    }

    //mutable class with list and map
    public static void immutable(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"ankit");
        List<String> list = new ArrayList<>();
        list.add("raj");
        MyImmutable myImmutable = new MyImmutable(1,"ankit",map,list);
        System.out.println(myImmutable.getList());
        List<String> list1 = myImmutable.getList();
        list1.add("rahul"); // will not get added in list
        System.out.println(myImmutable.getList());
    }

    //strings with same characters, aka anagram
    // silent listen
    public static void anagramString(){
        String str1 = "silent";
        String str2 = "listen";

        if(str1.length()!=str2.length()){
            System.out.println(false);
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character chr : str1.toCharArray()){
            if(map.containsKey(chr)){ // if character appears more than once
                map.put(chr,map.get(chr)+1);
            }else {
                map.put(chr,1);
            }
        }

        for (Character chr : str2.toCharArray()){
            if(map.containsKey(chr)){
                if(map.get(chr) > 1){
                    map.put(chr, map.get(chr)-1);
                }else {
                    map.remove(chr);
                }
            }else {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }

    //String[] arr = {"Hello", "world", "heoll", "hlole", "dlr", "dlrow"};
    //{dlorw=2, dlr=1, ehllo=3}
    public static void findNumberOfWordsWithSameCharacters(){
        String[] arr = {"Hello", "world", "heoll", "hlole", "dlr", "dlrow"};

        Map<String,Integer> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            char[] chr = arr[i].toLowerCase().toCharArray();
            Arrays.sort(chr);
            String str = String.valueOf(chr);

            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else {
                map.put(str,1);
            }
        }
        System.out.println(map);
    }

    //find the series of contiguous elements with the maximum sum in any given array.
    public static void maxSumSubArray(){
        int[] arr = {-3,1,-8,4,-1,2,1,-5,5};

        int start =0; int end=0;
        int maxSoFar = arr[0];
        int max = arr[0];

        for (int i = 1; i<arr.length; i++){

            if(arr[i] > arr[i]+max){
                max = arr[i]; //1->1, 3->4
                start = i;
            }else {
                max=arr[i]+max; //2->-7, 4->3, 5->5, 6->6, 7->1, 8->6
            }

            if(maxSoFar<max){
                maxSoFar=max; // 1->1, 3->4, 5->5, 6->6
                end = i;
            }
        }

        System.out.println("max: "+max +" start: "+ start+" end: "+ end);
    }

    //You have given a string that contains the braces (brackets), both opening and closing braces. You have to find the length of the longest balanced subarray.
    //input: {}{}{() output: 4
    //input: (({}[]()((}}{}{} output: 6
    public static void balancedSubArrayLength(){
        String str = "(({}[]()((}}{}{}";

        char[] charArray = str.toCharArray();

        char openCurl = '{';
        char closeCurl = '}';

        char openBrac = '[';
        char closeBrac = ']';

        char openPara = '(';
        char closePara = ')';

        int balanced = 0;
        int maxBalanced = 0;

        for (int i =0; i< charArray.length; i++){
            if(balanced > maxBalanced){
                maxBalanced = balanced;
            }
            if((charArray[i] == openCurl && charArray[i+1] == closeCurl)
                    || (charArray[i] == openBrac && charArray[i+1] == closeBrac)
                    || (charArray[i] == openPara && charArray[i+1] == closePara)){
                i++;
                balanced = balanced+2;
            }else {
                balanced = 0;
            }
        }
        System.out.println(maxBalanced);
    }

    // target with more than 2 elements combination
    public static void combinationWithTargetSum(){
        int[] arr = new int[]{19,1,3,5,7,10}; // 13-> 3,10  1,5,7
        int target = 13;
        printArray(arr);

        Arrays.sort(arr);
        printArray(arr);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = arr.length -1 ; i >= 0 ; i--){
            if(arr[i] > target){
                continue;
            }

            int sum = arr[i];
            List<Integer> combination = new ArrayList<>();
            combination.add(arr[i]);

            for(int j = i - 1 ; j >= 0 ; j--){
                if(sum + arr[j] <= target){
                    sum = sum + arr[j];
                    combination.add(arr[j]);

                    if(sum == target){
                        list.add(combination);
                        break;
                    }
                }
            }
        }

        System.out.println(list);
    }

    //find pair with target sum
    //int arr[] = {1, 3, 4, 7, 14, 16, 20};
    //int target = 24;
    //sol: indexes -> 2,6
    public static void target() {
        int[] arr = new int[]{1, 3, 4, 7, 14, 16, 20};
        int target = 24;
        printArray(arr);
        System.out.println("target: "+target);

        int firstElement = arr[0];
        int secondElement = arr[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int desiredPair = target - arr[i];
            if(map.containsValue(arr[i])){
                secondElement = arr[i];
                firstElement = desiredPair;
            }else {
                map.put(arr[i], target - arr[i]);
            }
        }

        System.out.println(map);
        if (firstElement+secondElement == target){
            System.out.println("firstElement: "+firstElement+", secondElement: "+secondElement);
        }else {
            System.out.println("no pair found");
        }


//        for (int i = 0; i < arr.length; i++) {
//            if (map.containsValue(arr[i])) {
//                System.out.println(i);
//            }
//        }

        //n2 solution
//        for(int i=0; i<arr.length; i++){
//            for(int j=i+1;j<arr.length; j++){
//                if(arr[i]+arr[j]==target){
//                    System.out.println("found :"+i+" , "+j);
//                    break;
//                }
//            }
//        }
    }

    //String s = "Java spring boot REST APIs";
    //o/p -> "avaJ gnirps toob TSER sIPA"
    public static void reverseWords() {
        String s = "Java spring boot REST APIs";

        String[] stringArr = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringArr.length; i++) {
            char[] chars = stringArr[i].toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int j = chars.length - 1; j >= 0; j--) {
                builder.append(chars[j]);
            }
            result.append(builder);
            result.append(" ");
        }

        System.out.println(result);
    }

    //Write the program printing pattern which has 20 rows and 15 columns like below
    //1 3 6 9 12 15 ........
    //3 6 9 12 15 18 .....
    //6 9 12 15 18 21 ....
    public static void patternRowColumn() {
        int start = 1;
        int multiplicationFactor = 3;
        int rowNum = 1;
        int startFactor = 0;

        for (int i = rowNum; i <= 20; i++) {
            for (int j = startFactor; j < 15 + startFactor; j++) {
                if (i == 1 && j == 0) {
                    System.out.print(1 + " ");
                } else {
                    int num = j * multiplicationFactor;
                    System.out.print(num + " ");
                }
            }
            startFactor++;
            rowNum++;
            System.out.println();
        }
    }

    //Brackets balanced? Sample I/p can be ({[]}), {[(])}, ([{})] [()()]{} ((((]])) ((((]]))]
    public static void balancedBrackets() {
        String s = "[()()]{}";
        if (s.length()%2 != 0){
            System.out.println(false);
            return;
        }
        char[] chr = s.toCharArray();
        char para = '(';
        char oppPara = ')';
        char cur = '{';
        char oppCur = '}';
        char brak = '[';
        char oppBrak = ']';

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chr.length; i++) {
            if (i == 0) {
                stack.push(chr[i]);
            } else {
                if ((chr[i] == oppPara && stack.peek() == para)
                        || (chr[i] == oppCur && stack.peek() == cur)
                        || (chr[i] == oppBrak && stack.peek() == brak)) {
//                if (chr[i] == para && stack.peek() == oppPara || chr[i] == cur && stack.peek() == oppCur || chr[i] == brak && stack.peek() == oppBrak || chr[i] == oppPara && stack.peek() == para || chr[i] == oppCur && stack.peek() == cur || chr[i] == oppBrak && stack.peek() == brak) {
                    stack.pop();
                } else {
                    stack.push(chr[i]);
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    //	for(int i=0;i<4;i++) {
//		System.out.print(fibonacciUsingRecursion(i)+", ");
//	}
    public static int fibonacciUsingRecursion(int count) {
        if (count <= 1) {
            return count;
        } else {
            return fibonacciUsingRecursion(count - 1) + fibonacciUsingRecursion(count - 2);
        }
    }

    //int[] arr= {1,5,7,9,2};
    //System.out.println(isOnlyOdd(arr));
    public static boolean isOnlyOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindromeString(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    //binary search only applicable for sorted array
//		int[] arr= {-111,-15,1,70,88,99,100};
//		System.out.println(iterativeBinarySearch(arr, 1));
//		System.out.println(iterativeBinarySearch(arr, 20));
//		System.out.println(iterativeBinarySearch(arr, 200));
//
//		System.out.println("-------------");
//
//		System.out.println(recursiveBinarySearch(arr, 1));
//		System.out.println(recursiveBinarySearch(arr, 20));
//		System.out.println(recursiveBinarySearch(arr, 200));
    //binary search using iteration (i.e while loop)
    public static int iterativeBinarySearch(int[] arr, int item) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == item) {
                return mid;
            } else if (arr[mid] > item) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    //binary search using recursion
    public static int recursiveBinarySearch(int[] arr, int item) {
        return recursiveBinarySearch(arr, 0, arr.length, item);
    }

    //{-111,-15,1,70,88,99,100}
    private static int recursiveBinarySearch(int[] arr, int start, int end, int item) {
        if (start >= end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == item) {
            return mid;
        } else if (item > arr[mid]) {
            return recursiveBinarySearch(arr, mid + 1, end, item);
        } else {
            return recursiveBinarySearch(arr, start, mid, item);
        }
    }

    public void reverseString() {
        String str1 = "My name is  Ankit";

        char[] char1 = str1.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int i = char1.length - 1; i >= 0; i--) {
            builder.append(char1[i]);
        }

        System.out.println(builder);
    }

    public void swapIntWithoutUsingThirdVariable() {
        int a = 10;
        int b = 20;
        System.out.println("a=" + a + " b=" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a + " b=" + b);
    }

    public void hasViwel() {
        String str1 = "ankit";

        boolean hasVowel = str1.matches(".*[aeiou].*") ? true : false;
        System.out.println(hasVowel);
    }

    public void isPrime() {
        int i = 19;

        int half = i / 2;
        boolean isPrime = true;

        for (int j = 2; j < half; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime);
    }

    public void fibonacciUsingLoop() {
        int count = 10;
        int curr = 0;
        int past = 0;
        int pastToPast = 0;

        for (int i = 0; i < count; i++) {
            if (i == 0 || i == 1) {
                System.out.print(i + ", ");
                past = i;
            } else {
                curr = past + pastToPast;
                System.out.print(curr + ", ");
                pastToPast = past;
                past = curr;
            }
        }
    }

    public void removeSpaceFromString() {
        String str = "i am ankit";

        //remove space
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ' ') {   //also can use Character.isWhitespace()
                sb.append(c);
            }
        }

        System.out.println(sb);
    }

    public void trimSpaceFromStartAndEnd() {
        String str = "  i am ankit     ";
        System.out.println(str);

        char[] chr = str.toCharArray();
        int startIndex = 0;

        for (int i = 0; i < chr.length; i++) {
            if (chr[i] != ' ') {
                startIndex = i;
                break;
            }
        }

        int endIndex = chr.length - 1;

        for (int i = chr.length - 1; i > 0; i--) {
            if (chr[i] != ' ') {
                endIndex = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(chr, startIndex, endIndex - 1);

        System.out.println("startIndex: " + startIndex + " , endIndex: " + endIndex);
        System.out.println(sb);

        //also can use strip or trim methods
        String str1 = str.strip();
        System.out.println(str1);
    }

    //PriorityQueue is the jdk implementation of min heap
    public void heap() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(90);
        pq.add(8);
        pq.add(-81);
        pq.add(87);
        pq.add(-9);

//		System.out.println(pq.peek());
//		System.out.println(pq.remove());
//		System.out.println(pq.peek());
//		System.out.println(pq.poll());
//		System.out.println(pq.remove(87));
//		System.out.println(pq.peek());

        Arrays.stream(pq.toArray()).forEach((a) -> System.out.print(a + ", "));
    }

    public void findCharOccurence() {
        String str = "a,b,c,a,a,b,d,d";

        char[] chr = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chr.length; i++) {
            if (chr[i] != ',') {
                if (!map.containsKey(chr[i])) {
                    map.put(chr[i], 1);
                } else {
                    int j = map.get(chr[i]);
                    map.put(chr[i], j + 1);
                }
            }
        }

        System.out.println(map);

        //java8
        Map<String, Long> charCount = str.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        charCount.remove(",");
        System.out.println(charCount);
    }

    public void reverseALinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList);

        Stack<Integer> stack = new Stack<>();
        for (int i : linkedList) {
            stack.push(i);
        }

        List<Integer> linkedList1 = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList1.add(stack.pop());
        }
        System.out.println(linkedList1);

        //2nd way
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList.descendingIterator().forEachRemaining(linkedList2::add);
        System.out.println(linkedList2);
    }

    public static void printArray(int[] arr){
        for (int i =0 ; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
