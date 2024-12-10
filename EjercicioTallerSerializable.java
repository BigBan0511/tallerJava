package ejerciciotallerserializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EjercicioTallerSerializable {
    public static Scanner datos = new Scanner(System.in);
    
    public static void guardarTaller(Taller garaje){
        try {
            FileOutputStream miFlujoSalida = new FileOutputStream("taller.dat");
            ObjectOutputStream salvaObjeto = new ObjectOutputStream(miFlujoSalida);
            salvaObjeto.writeObject(garaje);
            salvaObjeto.close();
            miFlujoSalida.close();
        } catch(IOException e) {
            System.out.println("No ha sido posible guardar el taller" + e.getMessage());
        }
    }
    
    public static Taller cargarTaller(){
        Taller elTaller = null;
        try {
            FileInputStream miFlujoEntrada = new FileInputStream("taller.dat");
            ObjectInputStream objetoEntrada = new ObjectInputStream(miFlujoEntrada);
            elTaller = (Taller)objetoEntrada.readObject();
            objetoEntrada.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo buscado " + e.getMessage());
        }catch(IOException e){
            System.out.println("Problemas al cargar el taller: " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado el taller");
        }
        return elTaller;
    }
    
    public static void mostrarMenu(){
        System.out.println("Taller 1º DAW, elija una opcion:");
        System.out.println("1- Agregar coche");
        System.out.println("2- Arreglar coche");
        System.out.println("3- Consultar coches");
        System.out.println("4- Consultar ganancia");
        System.out.println("5- Salvar taller");
        System.out.println("6- Cargar taller");
        System.out.println("7- Salir");
    }

    public static void main(String[] args) {
        boolean salida = true;
        String opcion = "";
        Taller t1 = new Taller();
        do {            
            mostrarMenu();
            opcion = datos.next();
            switch (opcion) {
                case "1":
                    t1.aceptarCoche();
                    break;
                case "2":
                    t1.areglarCoche();
                    break;
                case "3":
                    System.out.println(t1.toString());
                    break;
                case "4":
                    System.out.println("La ganancia del taller es: " + t1.getGananciaTotal());
                    break;
                case "5":
                    guardarTaller(t1);
                    break;
                case "6":
                    t1 = cargarTaller();
                    break;
                case "7":
                    salida = false;
                    System.out.println("Gracias por usar el taller 1º DAW");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (salida);
    }
    
}
