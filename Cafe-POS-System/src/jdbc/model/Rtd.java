package jdbc.model;

public class Rtd {
	
	private int rtd_id;
	private int m_type_id;
	private String rtd_name;
	private int rtd_price;
	
	public int getRtd_id() {
		return rtd_id;
	}
	
	public void setRtd_id(int rtd_id) {
		this.rtd_id = rtd_id;
	}
	
	public int getM_type_id() {
		return m_type_id;
	}
	
	public void setM_type_id(int m_type_id) {
		this.m_type_id = m_type_id;
	}
	
	public String getRtd_name() {
		return rtd_name;
	}
	
	public void setRtd_name(String rtd_name) {
		this.rtd_name = rtd_name;
	}
	
	public int getRtd_price() {
		return rtd_price;
	}
	
	public void setRtd_price(int rtd_price) {
		this.rtd_price = rtd_price;
	}
	
}
