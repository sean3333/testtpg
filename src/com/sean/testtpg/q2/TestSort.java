/**
 *
 */
package com.sean.testtpg.q2;

import org.junit.Test;

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
	}
}
