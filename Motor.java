package ejerciciotallerserializable;

import java.io.Serializable;

public class Motor implements Serializable{
    private int litrosAceite;
    private int cv;

    public Motor(int cv) {
        this.litrosAceite = 0;
        this.cv = cv;
    }

    public int getLitrosAceite() {
        return litrosAceite;
    }

    public void setLitrosAceite(int litrosAceite) {
        this.litrosAceite = litrosAceite;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        String desc = "Aceite: " + this.litrosAceite + " litros" 
                + "\nCv: "+ this.cv;
        return desc;
    }
    
}
