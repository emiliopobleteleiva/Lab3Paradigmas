package org.con4;

import java.util.Scanner;

public class Main_204446830_PobleteLeiva {

    private static int leerEntero(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) { // Verifica si la entrada es un entero
                numero = scanner.nextInt();
                entradaValida = true; // Sal del bucle si es válido
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                scanner.next(); // Descarta la entrada no válida
            }
        }
        return numero;
    }

    private static boolean volverAJugar(Scanner scanner, Game_204446830_PobleteLeiva game, int gameRemainingPieces){
        String resp = "";
        while (resp.isEmpty() || (resp.charAt(0) != 's' && resp.charAt(0) != 'n')){

            scanner.nextLine();
            System.out.print("Jugar de nuevo? (s/n): ");

            resp = scanner.nextLine().toLowerCase();

            if(!resp.isEmpty()) {
                if (resp.charAt(0) == 'n') {
                    System.out.println("\nSe termina el juego.");
                    return false;
                }
                else if(resp.charAt(0) == 's'){
                    game.resetGame(gameRemainingPieces);
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean gameloop = true;
        Game_204446830_PobleteLeiva game = null;

        while(gameloop){
            System.out.println("\nConecta4 - Menú Principal:");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Salir del juego");

            int option = leerEntero(scanner, "\nIngrese su opción: ");

            scanner.nextLine();

            switch (option){
                case 1: //crear nuevo juego
                    System.out.println("### Crear Nuevo Juego ###");
                    //datos jugador 1
                    System.out.println("\n--- Configuración jugador 1 ---");
                    System.out.print("Ingrese nombre del jugador 1: ");
                    String nombrePlayer1 = scanner.nextLine();
                    System.out.print("Color asignado: ");
                    String colorPlayer1 = scanner.nextLine();

                    //datos jugador 2
                    System.out.println("\n--- Configuración jugador 2 ---");
                    System.out.print("Ingrese nombre del jugador 2: ");
                    String nombrePlayer2 = scanner.nextLine();
                    System.out.print("Color asignado: ");
                    String colorPlayer2 = scanner.nextLine();


                    System.out.println("\n--- Configuración del juego ---");
                    System.out.print("Ingrese cantidad de fichas por jugador: ");
                    int gameRemainingPieces = scanner.nextInt();

                    Player_204446830_PobleteLeiva player1 = new Player_204446830_PobleteLeiva(1, nombrePlayer1, colorPlayer1, gameRemainingPieces);
                    Player_204446830_PobleteLeiva player2 = new Player_204446830_PobleteLeiva(2, nombrePlayer2, colorPlayer2, gameRemainingPieces);

                    game = new Game_204446830_PobleteLeiva(player1, player2);

                    boolean inGame = true;
                    while(inGame){
                        System.out.println("\nConecta4 - Menú de partida:");
                        System.out.println("1. Realizar jugada");
                        System.out.println("2. Visualizar estado actual");
                        System.out.println("3. Ver estadísticas generales");
                        System.out.println("4. Terminar partida");

                        int newOption = leerEntero(scanner, "\nIngrese su opción: ");

                        switch(newOption){
                            case 1:
                                System.out.println("\n### Realizar Jugada ###");
                                Player_204446830_PobleteLeiva p = game.getCurrentPlayer();
                                System.out.println("Turno de: " + p.getName() + " (" + p.getColor() + ")");
                                System.out.println("Fichas restantes: " + p.getRemainingPieces());

                                boolean played = false;
                                while (!played) {
                                    System.out.print("\nSeleccione columna (1-7): ");
                                    int columna = scanner.nextInt();
                                    played = game.realizarMovimiento(p, columna - 1);
                                }
                                break;

                            case 2: //visualizar estado actual
                                System.out.println("\n### Visualizar estado actual ###");
                                System.out.println("Jugador 1: " + player1.getName() + " (" + player1.getColor() + "). " + player1.getRemainingPieces() + " Piezas restantes.");
                                System.out.println("Jugador 2: " + player2.getName() + " (" + player2.getColor() + "). " + player2.getRemainingPieces() + " Piezas restantes.");
                                System.out.println("\nTurno de " + game.getCurrentPlayer().getName() + " (Jugador "+ game.getCurrentPlayer().getId()+ ").");
                                game.boardGetState();

                                break;

                            case 3: //ver estadísticas generales
                                System.out.println("\n### Visualizar estadísticas generales ###");

                                game.printHistory();

                                System.out.println("\nJugador 1 : " + player1.getName() + " (" + player1.getColor() + ")\nPiezas restantes: " + player1.getRemainingPieces());
                                System.out.println("- Victorias: "+ player1.getWins());
                                System.out.println("- Derrotas: " + player1.getLosses());
                                System.out.println("- Empates: " + player1.getDraws());

                                System.out.println("\nJugador 2: " + player2.getName() + " (" + player2.getColor() + ")\nPiezas restantes: " + player2.getRemainingPieces());
                                System.out.println("- Victorias: "+ player2.getWins());
                                System.out.println("- Derrotas: " + player2.getLosses());
                                System.out.println("- Empates: " + player2.getDraws());

                                break;

                            case 4:
                                scanner.nextLine();
                                String resp = "";
                                while (resp.isEmpty() || (resp.charAt(0) != 's' && resp.charAt(0) != 'n')){

                                    System.out.print("\n¿Estas seguro de terminar la partida? (s/n): ");
                                    resp = scanner.nextLine().toLowerCase();

                                    if(!resp.isEmpty()) {
                                        if (resp.charAt(0) == 's') {
                                            System.out.println("\nLa partida se termina.");
                                            inGame = false;
                                        }
                                    }
                                }
                                break;

                            default:
                                System.out.println("Ingresa un número válido");
                                break;
                        }
                        //comprobar quien es ganador
                        if(!game.esEmpate()){
                            int winner = game.getBoard().entregarGanador();
                            if(winner != 0){
                                System.out.println("\nJuego termina, el ganador es el Jugador " + winner + " (" + (winner == 1 ? player1.getName() : player2.getName()) + ")!");
                                game.endGame();
                                //se reinician los stats del juego (nuevo board y se reinician las piezas restantes)
                                if (!volverAJugar(scanner, game, gameRemainingPieces)) {
                                    inGame = false; // Salir del ciclo del juego
                                }


                            }
                            else if(inGame){
                                game.cambiarTurno();
                                System.out.println("\nEl juego continúa.");
                            }
                        }
                        else{
                            System.out.println("\nJuego termina en empate.");
                            game.endGame();
                            if (!volverAJugar(scanner, game, gameRemainingPieces)) {
                                inGame = false; // Salir del ciclo del juego
                            }
                        }

                    }

                    break;

                case 2: //terminar juego
                    String resp = "";
                    while (resp.isEmpty() || (resp.charAt(0) != 's' && resp.charAt(0) != 'n')){

                        System.out.print("¿Estas seguro que quieres salir del juego? (s/n): ");
                        resp = scanner.nextLine().toLowerCase();

                        if(!resp.isEmpty()) {
                            if (resp.charAt(0) == 's') {
                                System.out.println("\nSe cierra el juego.");
                                gameloop = false;
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Ingresa un número válido.");
            }
        }
    }
}