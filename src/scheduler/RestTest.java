package scheduler;

import java.io.IOException;

public class RestTest {

	public static void main(String[] args) throws IOException {
		root testroot = new root();
		ScheduleFunction.clear();
		System.out.println(testroot.post("1"));
		System.out.println(testroot.get("2"));
//		System.out.println(testroot.post("1"));
//		System.out.println(testroot.post("5"));
//		System.out.println(testroot.post("3"));
//		System.out.println(testroot.post("5"));

	}

}
