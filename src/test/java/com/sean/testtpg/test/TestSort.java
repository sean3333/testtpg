/**
 *
 */
package com.sean.testtpg.test;

import org.junit.Test;

import com.sean.testtpg.q2.SortStudent;

/**
 * @author sean
 *
 */
public class TestSort {

	@Test
	public void foo_file(){
		String filename = "resource/student.txt";
		SortStudent sortStudent = new SortStudent(filename);
		sortStudent.sort();
		//sortStudent.displayStudents();
		
		sortStudent.getStudents().stream().forEach(s->{
			System.out.println(s.getGpa());
			});
		sortStudent.getStudents().forEach(System.out::println);
	}
}
