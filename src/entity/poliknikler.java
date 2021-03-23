package entity;



public class poliknikler {
	
	private  Integer polikid_gs ;
	private String polikisim_gs ;
	private String nobetci_gs ;
	private String calismasaat_gs ;
	public poliknikler(Integer polikid_gs, String polikisim_gs, String nobetci_gs, String calismasaat_gs) {
		super();
		this.polikid_gs = polikid_gs;
		this.polikisim_gs = polikisim_gs;
		this.nobetci_gs = nobetci_gs;
		this.calismasaat_gs = calismasaat_gs;
	}
	public Integer getPolikid_gs() {
		return polikid_gs;
	}
	public void setPolikid_gs(Integer polikid_gs) {
		this.polikid_gs = polikid_gs;
	}
	public String getPolikisim_gs() {
		return polikisim_gs;
	}
	public void setPolikisim_gs(String polikisim_gs) {
		this.polikisim_gs = polikisim_gs;
	}
	public String getNobetci_gs() {
		return nobetci_gs;
	}
	public void setNobetci_gs(String nobetci_gs) {
		this.nobetci_gs = nobetci_gs;
	}
	public String getCalismasaat_gs() {
		return calismasaat_gs;
	}
	public void setCalismasaat_gs(String calismasaat_gs) {
		this.calismasaat_gs = calismasaat_gs;
	}
	

	
}
