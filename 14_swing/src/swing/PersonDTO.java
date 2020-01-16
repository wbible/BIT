package swing;

public class PersonDTO {
	private String id, name, pwd, tel;

	public PersonDTO() {
		
	}
	
	public PersonDTO(String id, String name, String pwd, String tel) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
	}
	
	public void setData(String name, String pwd, String tel) {
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
	}

	public PersonDTO(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getTel() {
		return tel;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof PersonDTO) {
			PersonDTO dto = (PersonDTO) o;
			if (name != null) return name.equals(dto.getName()) ? true : false;
		}
		return false;
	}
	
}
