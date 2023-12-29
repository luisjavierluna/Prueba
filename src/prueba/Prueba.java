package prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        
        // int T; // Nivel de Carga al que se quiere llegar
        // int S; // Carga Inicial
        // int C; // Nivel Actual de Carga
        // int R; // Tasa de carga (Unidades por mínuto)
        
        ArrayList<Query> Q = new ArrayList<>(); // número de consultas
        
        Q = crearQueries();
        
        Q.forEach(query -> {
            calcularMinutos(query);
        });
    }
    
    public static void calcularMinutos(Query query) {
        int minutes = 0;
        
        int C = query.S;
        int R;
        
        while (C < query.T) {     
            R = calcularR(C);
            
            C += R;
            
            minutes++;
        }
        
        System.out.println(minutes);
    }
    
    public static int calcularR(int C) {
        int R = 0;
        
        if (C >= 0 && C <= 10) {
            R = 10;
        } else if (C >= 11 && C <= 230) {
            R = 5;
        } else if (C >= 231 && C <= 559) {
            R = 8;
        } else if (C >= 560 && C <= 1009) {
            R = 2;
        } else if (C >= 1010 && C <= 5000) {
            R = 7;
        } else if (C >= 5001 && C <= 10000) {
            R = 8;
        } else if (C >= 10001 && C <= Math.pow(10, 9)) {
            R = 3;
        }
        
        return R;
    }
    
    public static ArrayList<Query> crearQueries() {
        System.out.println("¿Cuántas consulatas quieres hacer?");
        int cantidadConsultas = scan.nextInt();
        ArrayList<Query> queries = new ArrayList<>();
        
        scan.nextLine();
        for (int i = 0; i < cantidadConsultas; i++) {
            queries.add(crearQuery());
        }
        
        return queries;
    }
    
    public static Query crearQuery() {
            
            System.out.println("Ingresa el valor de S + espacio + valor de T ");
            String input = scan.nextLine();
            
            String[] numeros = input.split(" ");
            
            int S = Integer.parseInt(numeros[0]);
            int T = Integer.parseInt(numeros[1]);
                    
        return new Query(S, T);
    }
    
    public static class Query {
        public int S;
        public int T;

        public Query() {
        }

        public Query(int S, int T) {
            this.S = S;
            this.T = T;
        }
    }
}
