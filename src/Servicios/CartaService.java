package Servicios;

import Entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CartaService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Carta> mazo = new ArrayList();
    ArrayList<Carta> disponibles = new ArrayList();
    ArrayList<Carta> noDisponibles = new ArrayList();
    int j = 0;
    
    public void crearMazo(){
        int contador = 1;
        for (int i = 0; i < 40; i++) {
            Carta c = new Carta();
            c.setNumero(contador);
            contador++;
            if ((contador-1) == 7) {
                contador = 10;
            }
            if ((contador-1) == 8) {
                contador = 10;
            }
            if ((contador-1) == 12) {
                contador = 1;
            }
      
            if (i<10) {
                c.setPalo("BASTO");
            }
            if (i>=10 && i<20) {
                c.setPalo("ORO");
            }
            if (i>=20 && i<30) {
                c.setPalo("COPA");
            }
            if (i>=30 && i<40) {
                c.setPalo("ESPADA");
            }
            mazo.add(c);
        }
        disponibles.addAll(mazo);
    }
    
    public void barajar(){
        Collections.shuffle(mazo);
    }
    
    public void siguienteCarta(){
        j++;
        if (j<40) {
            System.out.println(mazo.get(j));
            noDisponibles.add(mazo.get(j));
            disponibles.remove(j);
        } else {
            System.out.println("No hay más cartas disponibles para barajar.");
        }
    }
    
    public void darCartas(){
        System.out.println("Ingrese una cantidad de cartas.");
        int cant = leer.nextInt();
        for (int i = 0; i < cant; i++) {
            siguienteCarta();
        }
        
    }
    
    public void cartasDisponibles(){
        System.out.println("Cartas disponibles: " + disponibles.size());
    }
    
    public void cartasMonton(){
        if (noDisponibles.isEmpty()) {
            System.out.println("No hay cartas fuera de juego.");
        } else {
            System.out.println("Cartas fuera de juego:");
            for (Carta carta : noDisponibles) {
                System.out.println(carta);
            }
        }
    }
    
    public void mostrarCartas(){
        System.out.println("Cartas");
        for (Carta carta : disponibles) {
            System.out.println(carta);
        }
    }
}
