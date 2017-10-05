/**
 *
 */
package com.sean.testtpg.test;

import org.junit.Test;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q2.SortStudentImpl;

/**
 * @author sean
 *
 */
public class TestSort {

	@Test
	public void foo_file(){
		String filename = "src\\main\\resource\\student.txt";
		SortStudent sortStudent = new SortStudentImpl(filename);
		sortStudent.sort();
		sortStudent.displayStudents();

	}
}
