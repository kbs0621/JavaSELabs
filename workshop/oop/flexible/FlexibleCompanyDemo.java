package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager manager = new Manager("ȫ�浿", 200);
        
        // �ڽ� mgr = new �ڽ�
        Manager hrMgr = new Manager("�Ѹ�", 200, "HR");
//        System.out.println(hrMgr.getName());
//        System.out.println(hrMgr.getSalary());
//        System.out.println(hrMgr.getDept());
        
        //������ (Polymorphism) Poly(�پ���) + Morphism(����)
        Employee itMgr = new Manager("�浿", 300, "IT");
//        System.out.println(itMgr.getName());
//        System.out.println(itMgr.getSalary());
        
        // Manager(�ڽ�)�� ���� getDept() �޼��� ȣ���ϱ�
        // ȣ���ϴ� ������ �θ� Ŭ���������� Dept�� ������ ���� �����ʰ�, �ڽ� Ŭ�������� �������� �����̹Ƿ�
        Manager itMgr2 = (Manager)itMgr;
        System.out.println(itMgr2.getDept());
        //((Manager)itMgr).getDept();
 
        
        //Heterogeneous Collection Employee Ÿ���� �迭 �����ϱ�
        //emps ������ Employee[] Ÿ��, emps[0]�� Employee Ÿ��
        Employee[] emps = new Employee[4];
        emps[0] = new Manager("�浿", 300, "IT");
        emps[1] = new Manager("�Ѹ�", 200, "HR");
        emps[2] = new MereClerk ("ö��", 100);
        emps[3] = new MereClerk ("����", 200);
        
        
        System.out.println("���� �����Դϴ�.");
        printEmployeeInfo(emps);
        
        for(Employee emp:emps) {
        	emp.manageSalary(10);
        }
        
        System.out.println(" ");
    	System.out.println("�ø� ���� �����Դϴ�.");
        printEmployeeInfo(emps);
       
   }

	public static void printEmployeeInfo(Employee[] emps) {
		for(Employee emp : emps) {
			//((Manager)emp).getDept();
			
			//instanceof : emp�� Manager ��ü�� ���� ������� instance ������ üũȮ���ϴ� ������ 
			if (emp instanceof Manager) {
				System.out.print("������ �μ���  = " + ((Manager)emp).getDept() + "");
	
			}
			System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");
        
        }
	}
}