package prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        
        // T = Nivel de Carga al que se quiere llegar
        // S = Carga Inicial
        // C = Nivel Actual de Carga
        // R = Tasa de carga (Unidades por mínuto)
        
        ArrayList<Query> Q; // número de consultas
        
        Q = crearQueries();
        
        Q.forEach(query -> {
            calcularMinutos(query);
        });
    }
    
    public static void calcularMinutos(Query query) {
        double minutos = 0;
        
        double[] unidadesPorRango = identificarRangoDeUnidades(query);
        
        minutos = (unidadesPorRango[0] / 10)
                + (unidadesPorRango[1] / 5)
                + (unidadesPorRango[2] / 8)
                + (unidadesPorRango[3] / 2)
                + (unidadesPorRango[4] / 7)
                + (unidadesPorRango[5] / 8)
                + (unidadesPorRango[6] / 3);
        
        int minutosEnteros = (int) Math.ceil(minutos);
        
        // System.out.println(minutos);
        System.out.println(minutosEnteros);
    }
    
    public static double[] identificarRangoDeUnidades(Query query) {
        double[] rangos = {0, 0, 0, 0, 0, 0, 0};
        
        for (int i = query.S; i < query.T; i++) {
            if (i >= 0 && i <= 10) {
                rangos[0]++;
            } else if (i >= 11 && i <= 230) {
                rangos[1]++;
            } else if (i >= 231 && i <= 559) {
                rangos[2]++;
            } else if (i >= 560 && i <= 1009) {
                rangos[3]++;
            } else if (i >= 1010 && i <= 5000) {
                rangos[4]++;
            } else if (i >= 5001 && i <= 10000) {
                rangos[5]++;
            } else if (i >= 10001 && i <= Math.pow(10, 9)) {
                rangos[6]++;
            }
        }
        
        return rangos;
    }
    
    public static ArrayList<Query> crearQueries() {
        System.out.println("¿Cuántas consultas quieres hacer?");
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
