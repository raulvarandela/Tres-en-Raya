/**
 @author : Raúl Varandela
 Descripción: clase que contiene toda la lógica de negocio del juego
 */

import java.util.Scanner;

public class Tablero {
    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero() {
        crearJugadores();
    }

    private void crearJugadores() {
        System.out.print("Introduce un nombre para el jugador1: ");
        Scanner sc = new Scanner(System.in);
        String cad = sc.nextLine();
        jugador1 = new Jugador(cad);
        System.out.println("---------------------------------------");

        System.out.print("Introduce un nombre para el jugador 2: ");
        sc = new Scanner(System.in);
        cad = sc.nextLine();
        jugador2 = new Jugador(cad);
        System.out.println("---------------------------------------");

        iniciarPartida();
    }


    private void iniciarPartida() {
        char tablero[][] = new char[3][3];
        tablero = rellenarTablero(tablero);
        boolean fin = false;
        boolean incorrecto = false;
        int col;
        int fila;
        int c = 0;
        boolean ocupada = false;
        boolean empate = false;
        int respuesta = 0;
        try {
            do {

                while (!fin && !empate) {
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println();
                    }
                    if (c % 2 == 0) {
                        System.out.println("Turno para " + jugador1.getNombre() + " y juagrá con la X.");

                        do {
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Introduce un numero de columna: ");
                            col = Integer.parseInt(sc.nextLine());
                            System.out.print("Introduce un numero de fila: ");
                            fila = Integer.parseInt(sc.nextLine());

                            if ((fila > 2 || fila < 0) || (col > 2 || col < 0)) {
                                System.out.println("Esa no es una posición correcta");
                                incorrecto = true;
                            } else {
                                incorrecto = false;
                            }

                            if (incorrecto != true && tablero[fila][col] != '*') {
                                System.out.println("Esa posición ya está ocupada");
                                ocupada = true;
                            } else {
                                ocupada = false;
                            }


                        } while (ocupada || incorrecto);

                        tablero[fila][col] = 'X';
                        fin = comprobarFin(tablero);
                        empate = empate(tablero);
                        c++;
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("Turno para " + jugador2.getNombre() + " y juagrá con la O.");
                        do {
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Introduce un numero de columna: ");
                            col = Integer.parseInt(sc.nextLine());
                            System.out.print("Introduce un numero de fila: ");
                            fila = Integer.parseInt(sc.nextLine());

                            if ((fila > 2 || col > 2) || (fila < 0 || col < 0)) {
                                System.out.println("Esa no es una posición correcta");
                                incorrecto = true;
                            } else {
                                incorrecto = false;
                            }

                            if (incorrecto != true && tablero[fila][col] != '*') {
                                System.out.println("Esa posición ya está ocupada");
                                ocupada = true;
                            } else {
                                ocupada = false;
                            }


                        } while (ocupada || incorrecto);

                        tablero[fila][col] = 'O';
                        fin = comprobarFin(tablero);
                        empate = empate(tablero);
                        c++;
                        System.out.println("--------------------------");
                    }
                }

                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("--------------------------");

                if (empate) {
                    System.out.println("Ha sido empate!");
                    jugador1.setPartidasJugadas();
                    jugador2.setPartidasJugadas();
                } else {
                    if (c % 2 == 0) {
                        jugador2.setPartidasGanadas();
                        jugador1.setPartidasJugadas();
                        jugador2.setPartidasJugadas();
                        System.out.println("Ganador! " + "\n" + jugador2.toString());
                    } else {
                        jugador1.setPartidasGanadas();
                        jugador1.setPartidasJugadas();
                        jugador2.setPartidasJugadas();
                        System.out.println("Ganador! " + "\n" + jugador1.toString());
                    }
                }
                do {
                    System.out.print("Quiere jugar otra? 1 --> si / 0 --> no: ");
                    Scanner sc = new Scanner(System.in);
                    respuesta = sc.nextInt();
                } while (respuesta != 0 && respuesta != 1);

                if (respuesta == 1) {
                    fin = false;
                    empate = false;
                    tablero = rellenarTablero(tablero);
                }

            } while (respuesta == 1);
        } catch (NumberFormatException ex) {
            System.out.println("Ha debido de introducir una posición el blanco");
        }
    }

    private char[][] rellenarTablero(char tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '*';
            }
        }
        return tablero;
    }

    private boolean empate(char tablero[][]) {
        boolean empate = true;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == '*') {
                    empate = false;
                }
            }
        }
        return empate;
    }

    private boolean comprobarFin(char tablero[][]) {
        char letra = 'X';
        //empezamos con las Xs

        //diagonal princinal
        if (tablero[0][0] == letra && tablero[1][1] == letra && tablero[2][2] == letra) {
            return true;
        }
        //diagonal inversa
        if (tablero[0][2] == letra && tablero[1][1] == letra && tablero[2][0] == letra) {
            return true;
        }

        // para las filas
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == letra && tablero[i][1] == letra && tablero[i][2] == letra) {
                return true;
            }
        }

        //para las columnas
        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[0][i] == letra && tablero[1][i] == letra && tablero[2][i] == letra) {
                return true;
            }
        }
        //ahora con las Os
        letra = 'O';

        //diagonal princinal
        if (tablero[0][0] == letra && tablero[1][1] == letra && tablero[2][2] == letra) {
            return true;
        }
        //diagonal inversa
        if (tablero[0][2] == letra && tablero[1][1] == letra && tablero[2][0] == letra) {
            return true;
        }

        // para las filas
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == letra && tablero[i][1] == letra && tablero[i][2] == letra) {
                return true;
            }
        }

        //para las columnas
        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[0][i] == letra && tablero[1][i] == letra && tablero[2][i] == letra) {
                return true;
            }
        }

        return false;
    }

}
