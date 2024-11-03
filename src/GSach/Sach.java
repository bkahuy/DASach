/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author buikh
 */
public class Sach {
    private String mas, tens, nhaxb;
    private int namxb, giab;

    public String getMas() {
        return mas;
    }

    public String getTens() {
        return tens;
    }

    public String getNhaxb() {
        return nhaxb;
    }

    public int getNamxb() {
        return namxb;
    }

    public int getGiab() {
        return giab;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    public void setTens(String tens) {
        this.tens = tens;
    }

    public void setNhaxb(String nhaxb) {
        this.nhaxb = nhaxb;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    public void setGiab(int giab) {
        this.giab = giab;
    }

    public Sach() {
        this.mas = "";
        this.tens = "";
        this.nhaxb = "";
        this.namxb = 0;
        this.giab = 0;
    }

    public Sach(String mas, String tens, String nhaxb, int namxb, int giab) {
        this.mas = mas;
        this.tens = tens;
        this.nhaxb = nhaxb;
        this.namxb = namxb;
        this.giab = giab;
    }
    
    public int Khuyetmai(int namxb, int giab){
        int gia = 0;
        if (namxb < 2019) {
            gia = giab - (giab * 25 /100);
        }
        return gia;        
    }
}
