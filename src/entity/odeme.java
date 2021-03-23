package entity;

public class odeme {
	
	private Integer idodeme ;
	private String isim_gs ;
	private String ucret ;
	private String taks ;
	private String taka ;
	public odeme(Integer idodeme, String isim_gs, String ucret, String taks, String taka) {
		super();
		this.idodeme = idodeme;
		this.isim_gs = isim_gs;
		this.ucret = ucret;
		this.taks = taks;
		this.taka = taka;
	}
	public odeme() {
		super();
	}
	@Override
	public String toString() {
		return "odeme [idodeme=" + idodeme + ", isim_gs=" + isim_gs + ", ucret=" + ucret + ", taks=" + taks + ", taka="
				+ taka + "]";
	}
	public Integer getIdodeme() {
		return idodeme;
	}
	public void setIdodeme(Integer idodeme) {
		this.idodeme = idodeme;
	}
	public String getIsim_gs() {
		return isim_gs;
	}
	public void setIsim_gs(String isim_gs) {
		this.isim_gs = isim_gs;
	}
	public String getUcret() {
		return ucret;
	}
	public void setUcret(String ucret) {
		this.ucret = ucret;
	}
	public String getTaks() {
		return taks;
	}
	public void setTaks(String taks) {
		this.taks = taks;
	}
	public String getTaka() {
		return taka;
	}
	public void setTaka(String taka) {
		this.taka = taka;
	}

	
}
