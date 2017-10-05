/**
 *
 */
package com.sean.testtpg.test;

import org.junit.Test;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q2.SortStudentImpl;
import com.sean.testtpg.q3.MethodTimerByReflect;

/**
 * @author sean
 *
 */
public class TestTimer {
	@Test
	public void foo_correct_method(){
		long time = MethodTimerByReflect.getMethodConsumedTime(Math.class, "random",null,null);
		assert time >0 : "wrong";
		System.out.println(time);

		Double[] d = {2.0,3.0};
		Class<?>[] dtype = {double.class, double.class};
		time = MethodTimerByReflect.getMethodConsumedTime(Math.class, "pow", d, dtype);
		assert time >0 : "wrong";
		System.out.println(time);

		SortStudent sortStudent = new SortStudentImpl();
		
		String[] s = {"src\\main\\resource\\student.txt"};
		time = MethodTimerByReflect.getMethodConsumedTime(sortStudent,"getStudentsFromFile",s,null);
		assert time >0 ;
		System.out.println(time);
		time =  MethodTimerByReflect.getMethodConsumedTime(sortStudent,"sort",null,null);
		assert time >0;
		System.out.println(time);
		time =  MethodTimerByReflect.getMethodConsumedTime(sortStudent,"displayStudents",null,null);
		assert time >0;
		System.out.println(time);
	}
	
	@Test
	public void foo4(){
		long time = MethodTimerByReflect.getMethodConsumedTime(null, "random",null,null);
		assert time ==0 : "wrong";
		System.out.println(time);

		time = MethodTimerByReflect.getMethodConsumedTime(null, "aaa",null,null);
		assert time ==0 : "wrong";
		System.out.println(time);

		Double[] d = {2.0,3.0};
		time = MethodTimerByReflect.getMethodConsumedTime(Math.class, "pow", d, null);
		assert time ==0 : "wrong";
		System.out.println(time);
	}
	

}
