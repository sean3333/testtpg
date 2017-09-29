/**
 *
 */
package com.sean.testtpg.test;

import org.junit.Test;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q3.MethodTimer;

/**
 * @author sean
 *
 */
public class TestTimer {
	@Test
	public void foo_correct_method(){
		long time = MethodTimer.getMethodConsumedTime(Math.class, "random",null,null);
		assert time >0 : "wrong";
		System.out.println(time);

		Double[] d = {2.0,3.0};
		Class<?>[] dtype = {double.class, double.class};
		time = MethodTimer.getMethodConsumedTime(Math.class, "pow", d, dtype);
		assert time >0 : "wrong";
		System.out.println(time);

		SortStudent sortStudent = new SortStudent();
		
		String[] s = {"bin/student.txt"};
		time = MethodTimer.getMethodConsumedTime(sortStudent,"getStudentsFromFile",s,null);
		assert time >0 : "wrong";
		System.out.println(time);
		time =  MethodTimer.getMethodConsumedTime(sortStudent,"sort",null,null);
		assert time >0 : "wrong";
		System.out.println(time);
		time =  MethodTimer.getMethodConsumedTime(sortStudent,"displayStudents",null,null);
		assert time >0 : "wrong";
		System.out.println(time);
	}
	
	@Test
	public void foo4(){
		long time = MethodTimer.getMethodConsumedTime(null, "random",null,null);
		assert time ==0 : "wrong";
		System.out.println(time);

		time = MethodTimer.getMethodConsumedTime(null, "aaa",null,null);
		assert time ==0 : "wrong";
		System.out.println(time);

		Double[] d = {2.0,3.0};
		time = MethodTimer.getMethodConsumedTime(Math.class, "pow", d, null);
		assert time ==0 : "wrong";
		System.out.println(time);
	}
	

}
