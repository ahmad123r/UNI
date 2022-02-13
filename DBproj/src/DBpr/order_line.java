package DBpr;



public class order_line extends Item  {

	private int NO_order;
	private int Id;

	private int Qan;
	public order_line() {}
	
public order_line( int NO_order,String Id, String Iname, String price,int Qan) {
		super(Id, Iname, price);
		this.NO_order=NO_order;
		this.Qan=Qan;
	}

public int getNO_order() {
	return NO_order;
}

public void setNO_order(int nO_order) {
	NO_order = nO_order;
}

public int getQan() {
	return Qan;
}

public void setQan(int qan) {
	Qan = qan;
}



}