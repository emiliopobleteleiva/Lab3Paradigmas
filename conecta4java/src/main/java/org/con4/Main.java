package org.con4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean gameloop = true;
        Game game = null;

        while(gameloop){
            System.out.println("\nConecta4 - Menú Principal:");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Salir del juego");
            System.out.print("\nIngrese su opción: ");

            int option = scanner.nextInt();

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

                    Player player1 = new Player(1, nombrePlayer1, colorPlayer1, gameRemainingPieces);
                    Player player2 = new Player(2, nombrePlayer2, colorPlayer2, gameRemainingPieces);

                    game = new Game(player1, player2);

                    boolean inGame = true;
                    while(inGame){
                        System.out.println("\nConecta4 - Menú de partida:");
                        System.out.println("1. Realizar jugada");
                        System.out.println("2. Visualizar estado actual");
                        System.out.println("3. Ver estadísticas generales");
                        System.out.println("4. Terminar partida");
                        System.out.print("\nIngrese su opción: ");

                        int newOption = scanner.nextInt();

                        switch(newOption){
                            case 1:
                                System.out.println("\n### Realizar Jugada ###");
                                Player p = game.getCurrentPlayer();
                                System.out.println("Turno de: " + p.getName() + " (" + p.getColor() + ")");
                                System.out.println("Fichas restantes: " + p.getRemainingPieces());

                                boolean played = false;
                                while (!played) {
                                    System.out.print("\nSeleccione columna (1-7): ");
                                    int columna = scanner.nextInt();
                                    played = game.realizarMovimiento(p, columna - 1);
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                inGame = false;
                                break;
                        }
                        //comprobar quien es ganador
                        if(!game.esEmpate()){
                            int winner = game.getBoard().entregarGanador();
                            if(winner != 0){
                                System.out.println("Juego termina, el ganador es el Jugador " + winner + " (" + (winner == 1 ? player1.getName() : player2.getName()) + ")!");
                                game.endGame();
                                inGame = false;
                            }
                            else {
                                System.out.println("El juego continúa.");
                            }
                        }
                        else{
                            System.out.println("Juego termina en empate.");
                            game.endGame();
                            inGame = false;
                        }

                    }

                    break;

                case 2: //terminar juego
                    System.out.println("Saliendo del juego.");
                    gameloop = false;
                    break;
                case 3: // Caso de pruebas
                    System.out.println("### Caso de Pruebas ###");
                    // Crear jugadores directamente
                    Player playertest1 = new Player(1, "emilio", "rojo", 10);
                    Player playertest2 = new Player(2, "mac", "negro", 10);

                    // Crear el juego
                    Game gametest = new Game(playertest1, playertest2);

                    // Simular jugadas
                    System.out.println("\nSimulando un juego en el que gana 'mac' (negro) por diagonal...");

                    // Turno 1: emilio
                    gametest.realizarMovimiento(playertest1, 0); // Columna 1
                    // Turno 2: mac
                    gametest.realizarMovimiento(playertest2, 1); // Columna 2
                    // Turno 3: emilio
                    gametest.realizarMovimiento(playertest1, 1); // Columna 2
                    // Turno 4: mac
                    gametest.realizarMovimiento(playertest2, 2); // Columna 3
                    // Turno 5: emilio
                    gametest.realizarMovimiento(playertest1, 2); // Columna 3
                    // Turno 6: mac
                    gametest.realizarMovimiento(playertest2, 3); // Columna 4
                    // Turno 7: emilio
                    gametest.realizarMovimiento(playertest1, 2); // Columna 3
                    // Turno 8: mac
                    gametest.realizarMovimiento(playertest2, 3); // Columna 4
                    // Turno 9: emilio
                    gametest.realizarMovimiento(playertest1, 3); // Columna 4
                    // Turno 10: mac (gana con diagonal)
                    gametest.realizarMovimiento(playertest2, 1); // Columna 4
                    gametest.realizarMovimiento(playertest1, 3); // Columna 4

                    // Mostrar estado final del tablero
                    System.out.println("\nTablero final:");
                    gametest.boardGetState();

                    // Comprobar el ganador
                    int winner = gametest.getBoard().entregarGanador();
                    if (winner != 0) {
                        System.out.println("\n¡El ganador es el Jugador " + winner + " (" + (winner == 1 ? playertest1.getName() : playertest2.getName()) + ")!");
                    } else {
                        System.out.println("\nEl juego terminó en empate.");
                    }

                    break;

                default:
                    System.out.println("Ingresa un número válido.");
            }
        }
    }
}