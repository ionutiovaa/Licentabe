package be.dto;

import java.io.Serializable;

public class LocDTO implements Serializable {

    private Integer ID;
    private String pozitie;
    private String qrCode;
    private Integer value;

    public LocDTO() {
    }

    @Override
    public String toString() {
        return "LocDTO{" +
                "ID=" + ID +
                ", pozitie='" + pozitie + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", value=" + value +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocDTO(Integer ID, String pozitie, String qrCode, Integer value) {
        this.ID = ID;
        this.pozitie = pozitie;
        this.qrCode = qrCode;
        this.value = value;
    }
}
