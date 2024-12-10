package ejerciciotallerserializable;

import java.io.Serializable;

public class Coche implements Serializable{
    private Motor motor;
    private String marca;
    private String modelo;
    private String matricula;
    private String averia;
    private double precioAveria;

    public Coche(Motor motor, String marca, String modelo, String matricula, String averia, double precioAveria) {
        this.motor = motor;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.averia = averia;
        this.precioAveria = precioAveria;
    }
    
    public void acumularAveria(){
        double gastoTotal = 0;
        gastoTotal = gastoTotal + this.precioAveria;
    }

    @Override
    public String toString() {
        String desc = "Motor:" + this.motor.toString() 
                + "\nMarca: " + this.marca + "\nModelo: " + this.modelo
                + "\n:Matricula: " + this.matricula + "\nAveria: "
                + this.averia + "\nCoste de reparacion: " + this.precioAveria;
        return desc;
    }

    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getAveria() {
        return averia;
    }

    public double getPrecioAveria() {
        return precioAveria;
    }

    public void setAveria(String averia) {
        this.averia = averia;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecioAveria(double precioAveria) {
        this.precioAveria = precioAveria;
    }
    
    
    
    
}
