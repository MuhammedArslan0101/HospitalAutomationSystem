package entity;

public class hastadurumbelgesi {
	private Integer idh_gs ;
	private String adsoyad_gs ;
	private String tc ;
	private String hastalik_gs ;
	
	private String drh_gs ;
	
	private String kisim_gs ;
	
	private String not_gs ;

	@Override
	public String toString() {
		return "hastadurumbelgesi [idh_gs=" + idh_gs + ", adsoyad_gs=" + adsoyad_gs + ", tc=" + tc + ", hastalik_gs="
				+ hastalik_gs + ", drh_gs=" + drh_gs + ", kisim_gs=" + kisim_gs + ", not_gs=" + not_gs + "]";
	}

	public hastadurumbelgesi(Integer idh_gs, String adsoyad_gs, String tc, String hastalik_gs, String drh_gs,
			String kisim_gs, String not_gs) {
		super();
		this.idh_gs = idh_gs;
		this.adsoyad_gs = adsoyad_gs;
		this.tc = tc;
		this.hastalik_gs = hastalik_gs;
		this.drh_gs = drh_gs;
		this.kisim_gs = kisim_gs;
		this.not_gs = not_gs;
	}

	public hastadurumbelgesi() {
		super();
	}

	public Integer getIdh_gs() {
		return idh_gs;
	}

	public void setIdh_gs(Integer idh_gs) {
		this.idh_gs = idh_gs;
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

	public String getHastalik_gs() {
		return hastalik_gs;
	}

	public void setHastalik_gs(String hastalik_gs) {
		this.hastalik_gs = hastalik_gs;
	}

	public String getDrh_gs() {
		return drh_gs;
	}

	public void setDrh_gs(String drh_gs) {
		this.drh_gs = drh_gs;
	}

	public String getKisim_gs() {
		return kisim_gs;
	}

	public void setKisim_gs(String kisim_gs) {
		this.kisim_gs = kisim_gs;
	}

	public String getNot_gs() {
		return not_gs;
	}

	public void setNot_gs(String not_gs) {
		this.not_gs = not_gs;
	}
	
	
	

}
