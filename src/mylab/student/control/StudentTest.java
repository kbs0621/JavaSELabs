package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;


public class StudentTest {
	public static void main(String[] args) {
	
		try {
			Student s1 = new Student("123456", "김민수", "컴퓨터 공학", 3);
			s1.printStudentInfo();
			
			System.out.println("5학년으로 변경");
			s1.setGrade(5);
			
			s1.printStudentInfo();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
