package ejerciciotallerserializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller implements Serializable{
    private ArrayList <Coche> coches;
    private double gananciaTotal;

    public Taller() {
        this.coches = new ArrayList();
        this.gananciaTotal = 0;
    }
    
    public boolean aceptarCoche(){
        Scanner datos = new Scanner(System.in);
        System.out.println("Introduzca la informacion del coche: ");
            System.out.println("Motor: ");
            System.out.println("cv: ");
            int cv = datos.nextInt();
            System.out.println("aceite: ");
            int litros = datos.nextInt();
            System.out.println("marca: ");
            datos = new Scanner(System.in);
            String marca = datos.nextLine();
            System.out.println("modelo: ");
            String modelo = datos.nextLine();
            System.out.println("matricula: ");
            String matricula = datos.nextLine();
            System.out.println("averia: ");
            String averia = datos.nextLine();
            System.out.println("precio: ");
            double precio = datos.nextDouble();
            
            Motor m1 = new Motor(cv);
            m1.setLitrosAceite(litros);
            Coche c1 = new Coche(m1, marca, modelo, matricula, averia, precio);
            this.coches.add(c1);
            return true;
        
    }
    
    public boolean areglarCoche(){
        Scanner datos = new Scanner(System.in);
        System.out.println("Introduzca la matricula del coche que desea arreglar");
        datos = new Scanner(System.in);
        String matriculaElegida = datos.nextLine();
        for (Coche actual : this.coches) {
            if(actual.getMatricula().equalsIgnoreCase(matriculaElegida)){
                actual.setAveria(null);
                this.gananciaTotal = this.gananciaTotal + actual.getPrecioAveria();
                this.coches.remove(actual);
                return true;
            }System.out.println("No se ha encontrado el coche");
        }return false;
    }

    @Override
    public String toString() {
        String desc = "";
        for (Coche actual : this.coches) {
            desc = desc + actual.toString();
            desc = desc + "\n------------------------------";
        }
        return desc;
    }

    public double getGananciaTotal() {
        return gananciaTotal;
    }
    
    
    
}
