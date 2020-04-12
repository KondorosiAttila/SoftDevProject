
package hu.unideb.inf.model;

import java.util.*;

public class Pizza {
    
    private String nev;
    private int ar;
    private int meret;
    private ArrayList<String> feltet;
    private boolean duplateszta;

    public Pizza() {
    }

    public Pizza(String nev, int ar, int meret, ArrayList<String> feltet, boolean duplateszta) {
        this.nev = nev;
        this.ar = ar;
        this.meret = meret;
        this.feltet = feltet;
        this.duplateszta = duplateszta;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    public ArrayList<String> getFeltet() {
        return feltet;
    }

    public void setFeltet(ArrayList<String> feltet) {
        this.feltet = feltet;
    }

    public boolean isDuplateszta() {
        return duplateszta;
    }

    public void setDuplateszta(boolean duplateszta) {
        this.duplateszta = duplateszta;
    }
    
    
    
    
}
