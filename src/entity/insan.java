package entity;

import application.deiskenler;

public class insan extends deiskenler {

	protected static String adsoyad_gs ;
	protected static String tc ;
	
	
	public insan() {
		super();
	}
	public insan(String adsoyad_gs, String tc) {
		super();
		this.adsoyad_gs = adsoyad_gs;
		this.tc = tc;
	}
	@Override
	public String toString() {
		return "insan [adsoyad_gs=" + adsoyad_gs + ", tc=" + tc + "]";
	}
	public String getAdsoyad_gs() {
		return adsoyad_gs;
	}
	public void setAdsoyad_gs(String adsoyad_gs) {
		this.adsoyad_gs = adsoyad_gs;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	
	
	

}
