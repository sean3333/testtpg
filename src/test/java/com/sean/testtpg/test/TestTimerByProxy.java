/**
 *
 */
package com.sean.testtpg.test;

import org.junit.Test;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q2.SortStudentImpl;
import com.sean.testtpg.q3.MethodTimerByProxy;
import com.sean.testtpg.q3.MethodTimerByReflect;

/**
 * @author sean
 *
 */
public class TestTimerByProxy {
	@Test
	public void foo_correct_method(){


		SortStudent sortStudent =  (SortStudent) MethodTimerByProxy.getInstanct(new SortStudentImpl());
		
		sortStudent.getStudentsFromFile("src\\main\\resource\\student.txt");
		
		sortStudent.sort();
		
		sortStudent.displayStudents();


	}
	
}
