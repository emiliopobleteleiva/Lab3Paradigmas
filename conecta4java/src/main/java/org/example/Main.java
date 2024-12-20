import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Game game = null;

        while(true){
            System.out.println("Conecta4 - Menú Principal:");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Visualizar estado actual");
            System.out.println("3. Realizar jugada");
            System.out.println("4. Ver estadísticas generales");
            System.out.println("5. Salir del juego");
            System.out.print("Elige opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();
                switch (option){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Saliendo del juego.");
                        break;
                    default:
                        System.out.println("Ingresa un número válido.");
                }
        }
    }

}