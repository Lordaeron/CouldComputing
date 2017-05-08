package appdatabase;

public class appdb {
	
	String app_id;
	String name;
	String own_email;
	String url;
	String about;
	
	public void setAppdb(String app_id, String name, String own_email, String url, String about){
		this.app_id = app_id;
		this.name = name;
		this.own_email = own_email;
		this.url = url;
		this.about = about;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwn_email() {
		return own_email;
	}

	public void setOwn_email(String own_email) {
		this.own_email = own_email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
}



