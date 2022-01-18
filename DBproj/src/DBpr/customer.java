package DBpr;

public class customer {
	private String Cname;
	private String Cadderes;
	private String Cphone;
private String Id;
	public customer(String cname, String cadderes, String cphone,String Id) {
		this.Id=Id;
		
		this.Cname = cname;
		this.Cadderes = cadderes;
		this.Cphone = cphone;
		
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCadderes() {
		return Cadderes;
	}
	public void setCadderes(String cadderes) {
		Cadderes = cadderes;
	}
	public String getCphone() {
		return Cphone;
	}
	public void setCphone(String cphone) {
		Cphone = cphone;
	}
	
	

}
