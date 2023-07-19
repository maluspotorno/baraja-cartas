package Main;

import Servicios.CartaService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        CartaService cs = new CartaService();

        boolean bandera = true;
        cs.crearMazo();
        
        System.out.println("JUEGO DE CARTAS");
        do {
            System.out.println("---MENÚ---");
            System.out.println("1- Barajar cartas");
            System.out.println("2- Siguiente carta");
            System.out.println("3- Cartas disponibles");
            System.out.println("4- Dar cartas");
            System.out.println("5- Cartas fuera de juego");
            System.out.println("6- Mostrar baraja");
            System.out.println("7- Salir");
            int op = leer.nextInt();
            switch (op) {
                case 1:
                    cs.barajar();
                    break;
                case 2:
                    cs.siguienteCarta();
                    break;
                case 3:
                    cs.cartasDisponibles();
                    break;
                case 4:
                    cs.darCartas();
                    break;
                case 5:
                    cs.cartasMonton();
                    break;
                case 6:
                    cs.mostrarCartas();
                    break;
                case 7:
                    System.out.println("¿Desea salir? S/N");
                    String rta = leer.next();
                    if (rta.equalsIgnoreCase("s")) {
                        bandera = false;
                    }
                    if (!rta.equalsIgnoreCase("n")&&!rta.equalsIgnoreCase("s")){
                        System.out.println("Opción inválida.");
                    }
                    break;
            }
            System.out.println(" ");
        } while (bandera);
    }
    
}
