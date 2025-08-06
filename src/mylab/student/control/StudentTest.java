package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;


public class StudentTest {
	public static void main(String[] args) {
	
		try {
			Student s1 = new Student("123456", "��μ�", "��ǻ�� ����", 3);
			s1.printStudentInfo();
			
			System.out.println("5�г����� ����");
			s1.setGrade(5);
			
			s1.printStudentInfo();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
