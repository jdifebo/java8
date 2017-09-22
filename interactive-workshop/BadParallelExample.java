import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Don't use parallel streams like this!
 * 
 * @author jdifebo
 *
 */
public class BadParallelExample {

	static int n = 0;

	/**
	 * Increment the static variable n 100,000 times, then print out the value
	 */
	public static void main(String[] args) {
		IntStream.range(0, 100000).parallel().forEach(i -> n++);
		System.out.println(n);
	}

}
