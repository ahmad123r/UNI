package DBpr;

import java.util.Date;

public class saels_oreder {
	private int NO_order;
private int Total;
private int Cid;
private Date ODate= new Date();
public saels_oreder(int nO_order, int total, int cid, Date oDate) {
	super();
	NO_order = nO_order;
	Total = total;
	ODate = oDate;
	Cid = cid;
	
}
public int getNO_order() {
	return NO_order;
}
public void setNO_order(int nO_order) {
	NO_order = nO_order;
}
public int getTotal() {
	return Total;
}
public void setTotal(int total) {
	Total = total;
}
public int getCid() {
	return Cid;
}
public void setCid(int cid) {
	Cid = cid;
}
public Date getODate() {
	return ODate;
}
public void setODate(Date oDate) {
	ODate = oDate;
}



}
