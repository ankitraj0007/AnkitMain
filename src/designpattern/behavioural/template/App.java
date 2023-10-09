package designpattern.behavioural.template;

public class App {

	public static void main(String[] args) {
		//template design pattern is mainly creating a template in the form of abstract class
		//put some protected variable
		//initialize using child object


		int[] nums = {1, 5, 3, -2, 10, 12, 8, 6, 5};
		
		SortAlgorithm sorting = new SelectionSort(nums);
		sorting.sort();

		System.out.println();
		Game game = new Football();
		game.play();
	}
}
