package jsfsample;

import java.io.Serializable;

@javax.faces.bean.ManagedBean
@javax.faces.bean.SessionScoped
public class UserBean implements Serializable {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
