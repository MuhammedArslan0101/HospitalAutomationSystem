package entity;

public class odalar {

	private String ad_gs ;
	private Integer odano_gs ;
	private Integer kisisayisi_gs;
	private String durumoda_gs ;
	public odalar(String ad_gs, Integer odano_gs, Integer kisisayisi_gs, String durumoda_gs) {
		super();
		this.ad_gs = ad_gs;
		this.odano_gs = odano_gs;
		this.kisisayisi_gs = kisisayisi_gs;
		this.durumoda_gs = durumoda_gs;
	}
	@Override
	public String toString() {
		return "odalar [ad_gs=" + ad_gs + ", odano_gs=" + odano_gs + ", kisisayisi_gs=" + kisisayisi_gs
				+ ", durumoda_gs=" + durumoda_gs + "]";
	}
	public String getAd_gs() {
		return ad_gs;
	}
	public void setAd_gs(String ad_gs) {
		this.ad_gs = ad_gs;
	}
	public Integer getOdano_gs() {
		return odano_gs;
	}
	public void setOdano_gs(Integer odano_gs) {
		this.odano_gs = odano_gs;
	}
	public Integer getKisisayisi_gs() {
		return kisisayisi_gs;
	}
	public void setKisisayisi_gs(Integer kisisayisi_gs) {
		this.kisisayisi_gs = kisisayisi_gs;
	}
	public String getDurumoda_gs() {
		return durumoda_gs;
	}
	public void setDurumoda_gs(String durumoda_gs) {
		this.durumoda_gs = durumoda_gs;
	}
	public odalar() {
		super();
	}
	
	
	
	
}
