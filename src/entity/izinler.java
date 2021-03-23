package entity;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class izinler {

	private Integer idizin_gs;
	private String izinad_gs;
	private LocalDate bas;
	private LocalDate bitis;
	private String aciklama;

	public izinler(Integer idizin_gs, String izinad_gs, LocalDate bas, LocalDate bitis, String aciklama) {
		super();
		this.idizin_gs = idizin_gs;
		this.izinad_gs = izinad_gs;
		this.bas = bas;
		this.bitis = bitis;
		this.aciklama = aciklama;
	}

	public Integer getIdizin_gs() {
		return idizin_gs;
	}

	public void setIdizin_gs(Integer idizin_gs) {
		this.idizin_gs = idizin_gs;
	}

	public String getIzinad_gs() {
		return izinad_gs;
	}

	public void setIzinad_gs(String izinad_gs) {
		this.izinad_gs = izinad_gs;
	}

	public LocalDate getBas() {
		return bas;
	}

	public void setBas(LocalDate bas) {
		this.bas = bas;
	}

	public LocalDate getBitis() {
		return bitis;
	}

	public void setBitis(LocalDate bitis) {
		this.bitis = bitis;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	@Override
	public String toString() {
		return "izinler [idizin_gs=" + idizin_gs + ", izinad_gs=" + izinad_gs + ", bas=" + bas + ", bitis=" + bitis
				+ ", aciklama=" + aciklama + "]";
	}

}
