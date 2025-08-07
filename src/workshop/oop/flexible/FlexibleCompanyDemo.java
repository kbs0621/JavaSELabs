package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("철수", 100);
        MereClerk mereClerk2 = new MereClerk("영희", 100);
        Manager manager = new Manager("홍길동", 200);
        
        // 자식 mgr = new 자식
        Manager hrMgr = new Manager("둘리", 200, "HR");
        System.out.println(hrMgr.getName());
        System.out.println(hrMgr.getSalary());
        System.out.println(hrMgr.getDept());
        
        //다형성 (Polymorphism) Poly(다양한) + Morphism(변신)
        Employee itMgr = new Manager("길동", 300, "IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        
//        //Manager(자식)가 가진 getDept() 메서드 호출하기
//        Manager itMgr2 = (Manager)itMgr;
//        System.out.println(itMgr2.getDept());
 
        System.out.println("현재 월급입니다.");
        
        //Heterogeneous Collection Employee 타입의 배열 선언하기
        //emps 변수는 Employee[] 타입, emps[0]는 Employee 타입
        Employee[] emps = new Employee[4];
        emps[0] = new Manager("길동", 300, "IT");
        emps[1] = new Manager("둘리", 200, "HR");
        emps[2] = new MereClerk ("철수", 100);
        emps[3] = new MereClerk ("영희", 200);
        
        for(Employee emp : emps) {

            System.out.println("현재 월급입니다.");
        	System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
        	
              
        }
        System.out.println("");
        
        
        for(Employee emp : emps) {
        	
        	emp.manageSalary(10);
        	System.out.println("올린 후의 월급입니다.");
        	System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
        }
        
        
        
   }
}