package DBpr;
public class Item {
	private String Id;
	private String  Iname;
	private String  price;
	
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

public  void setRecords(String sg, int i) {
		
		switch  (i) {
		case 1:
			Id = sg;
			break;
		case 2:
			Iname = sg;
			break;
		case 3:
			price = sg;
			
			
	
			
		}
	}
public String getField(int i) {
	
	
	String res = null;
	switch(i) {
	case 1:
		res = Id;
		break;
	case 2:
		res = Iname;
		break;
	case 3:
		res= price;

		
		
	}
return res;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}
	
}
