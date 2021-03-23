package entity;

import java.time.LocalDate;

public class personel {

	private Integer idper_gs ;
	private String adper_gs ;
	private String soyper_gs ;
	private String tcper_gs ;
	private long teleper_gs ;
	private Integer massper_gs ;
	private String polikper_gs ;
	private LocalDate tarihper_gs ;
	private String personeltur_gs ;
	
	
	
	
	public personel(Integer idper_gs, String adper_gs, String soyper_gs, String tcper_gs,String personeltur_gs, long teleper_gs,
			Integer massper_gs, String polikper_gs, LocalDate tarihper_gs) {
		super();
		this.idper_gs = idper_gs;
		this.adper_gs = adper_gs;
		this.soyper_gs = soyper_gs;
		this.tcper_gs = tcper_gs;
		this.teleper_gs = teleper_gs;
		this.massper_gs = massper_gs;
		this.polikper_gs = polikper_gs;
		this.tarihper_gs = tarihper_gs;
		this.personeltur_gs = personeltur_gs;
	}

	public personel() {
		super();
	}
	

	public String getPersoneltur_gs() {
		return personeltur_gs;
	}

	public void setPersoneltur_gs(String personeltur_gs) {
		this.personeltur_gs = personeltur_gs;
	}

	public Integer getIdper_gs() {
		return idper_gs;
	}
	public void setIdper_gs(Integer idper_gs) {
		this.idper_gs = idper_gs;
	}
	public String getAdper_gs() {
		return adper_gs;
	}
	public void setAdper_gs(String adper_gs) {
		this.adper_gs = adper_gs;
	}
	public String getSoyper_gs() {
		return soyper_gs;
	}
	public void setSoyper_gs(String soyper_gs) {
		this.soyper_gs = soyper_gs;
	}
	public String getTcper_gs() {
		return tcper_gs;
	}
	public void setTcper_gs(String tcper_gs) {
		this.tcper_gs = tcper_gs;
	}
	
	public long getTeleper_gs() {
		return teleper_gs;
	}
	public void setTeleper_gs(long teleper_gs) {
		this.teleper_gs = teleper_gs;
	}
	public Integer getMassper_gs() {
		return massper_gs;
	}
	public void setMassper_gs(Integer massper_gs) {
		this.massper_gs = massper_gs;
	}
	public String getPolikper_gs() {
		return polikper_gs;
	}
	public void setPolikper_gs(String polikper_gs) {
		this.polikper_gs = polikper_gs;
	}
	public LocalDate getTarihper_gs() {
		return tarihper_gs;
	}
	public void setTarihper_gs(LocalDate tarihper_gs) {
		this.tarihper_gs = tarihper_gs;
	}
	@Override
	public String toString() {
		return "personel [idper_gs=" + idper_gs + ", adper_gs=" + adper_gs + ", soyper_gs=" + soyper_gs + ", tcper_gs="
				+ tcper_gs + ", teleper_gs=" + teleper_gs + ", massper_gs=" + massper_gs + ", polikper_gs="
				+ polikper_gs + ", tarihper_gs=" + tarihper_gs + "]";
	}
	
	
	

}
