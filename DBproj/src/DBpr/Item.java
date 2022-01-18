package DBpr;
public class Item {
	private String Id;
	private String  Iname;
	private String  price;
	
	public Item() {
		
		
	}
	
	public Item(String Id,String Iname,String price) {
		this.Id=Id;
		this.Iname=Iname;
		this.price=price;
		
	}

public String getIname() {
		return Iname;
	}

	public void setIname(String iname) {
		Iname = iname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}
	
}
