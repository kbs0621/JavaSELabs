package workshop.person.entity;

public class PersonEntity {
	//변수 선언
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;

	//기본 생성자
	public PersonEntity() {
		
		
	}


	//overloading constructor
	public PersonEntity(String name, String ssn, String address, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
		
		// ssn이 null이 아닌 경우
		if (ssn != null) {
			// ssn 배열의 7번째 자리 값
			char genderNum = ssn.charAt(6);
			
			// 1이거나 3이면 남자
			if (genderNum == '1' || genderNum == '3') {
				setGender('남');
			}
			// 나머지 2나 4면 여자
			else {
				setGender('여');
			}
		}
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}	


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
