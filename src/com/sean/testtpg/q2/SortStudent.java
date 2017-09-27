package com.sean.testtpg.q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * question 2: sort students list 
 * @author sean
 *
 */
public class SortStudent {
	
	private List<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) throws IOException{
		System.out.print("Please enter the filename of students: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename = "";
		filename=br.readLine();
		
		SortStudent sortStudent = new SortStudent(filename);
		sortStudent.sort();
		sortStudent.displayStudents();
	}

	public void displayStudents(){
		System.out.println("\nordered students: \nName\tID");
		students.stream().forEach(s->{
			System.out.println(s.getFirstname() +"\t"+s.getId());
			});
	}
	
	/**
	 * sort students in:
	 * * first: descending order for GPA
	 * * second: alphabetical order for first name
	 * * third: ascending order for ID
	 */
	public void sort(){

		Comparator<Student> comparator = (o1,o2) -> (((Float.compare(o2.getGpa(),o1.getGpa()))!=0)?Float.compare(o2.getGpa(),o1.getGpa())
				:(((o1.getFirstname().compareToIgnoreCase(o2.getFirstname()))!=0)?(o1.getFirstname().compareToIgnoreCase(o2.getFirstname()))
						:(Integer.compare(o1.getId(), o2.getId()))));
		
		/*
		comparator = new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int result =0;
				
				if((result=Float.compare(o2.getGpa(),o1.getGpa()))!=0){
					// descending order for gpa
					return result;
				} else if((result=o1.getFirstname().compareToIgnoreCase(o2.getFirstname()))!=0){
					// alphabetical order for firstname
					return result;
				} else{
					// ascending order for ID
					return Integer.compare(o1.getId(), o2.getId());
				}
			}

		};
		*/
		
		students.sort(comparator);

	}

	public SortStudent(){}

	public SortStudent(String filename){
		getStudentsFromFile(filename);
	}
	/**
	 * get student from a file
	 * @param filename
	 */
	public void getStudentsFromFile(String filename) {
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(filename));

			String line = "";

			while ((line = br.readLine()) != null) {
				String[] info = line.split(" ");
				if(info.length != 3){
					// 3 columns: ID, firstname, GPA
					System.out.println("the line contines error information: "+line);
					continue;
				}
				try{
					Student student = new Student(Integer.parseInt(info[0]),info[1],Float.parseFloat(info[2]));
					students.add(student);
				} catch(Exception e){
					System.out.println("the line contines error information: "+line);
					continue;
				}
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("can not read the file: " + filename 
					+ " with errors: \n" + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}

	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Student> getStudents() {
		return students;
	}
}
