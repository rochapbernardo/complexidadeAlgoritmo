package linhaMontagem;

public class Main {
    public static void main(String[] args) {

        int [][] tempo = {
                {7,9,3,4,8},
                {8,5,6,4,5}
        };

        //matriz troca iniciada com 0
        int [][] troca = {
                 {0,2,3,1,3},
                 {0,2,1,2,2}
        };

        int[] entrada = {2,4};
        int[] saida = {3,6};

        int resultado = tempoMinimo(tempo, entrada, saida, troca);

        System.out.println("Tempo mínimo na linha de montagem: " + resultado);

    }

    public static int tempoMinimo(int[][] tempo, int[] entrada, int[] saida, int[][] troca){
        int n = tempo[0].length;

        int[] t1 = new int[n]; //tempo acumulado linha 1
        int[] t2 = new int[n]; //tempo acumulado linha 2

        //tempo gasto na entrada das linhas
        t1[0] = entrada[0] + tempo[0][0];
        t2[0] = entrada[1] + tempo[1][0];

        //preencher as próximas estacoes
        for(int i=1; i<n; i++){

            //verifica se ficar na mesma linha é menos custoso do que a troca de linha
            t1[i] = Math.min(
                    t1[i-1] + tempo[0][i], //fica na mesma linha
                    t2[i-1] + troca [1][i] + tempo[0][i] //realiza a troca
            );
            t2[i] = Math.min(
                    t2[i-1] + tempo[1][i],
                    t1[i-1] + troca[0][i] + tempo[1][i]
            );
        }

        //adiciona o tempo de saída das linhas de montagem e verifica qual o menor tempo
        return Math.min(t1[n-1] + saida[0], t2[n-1] + saida[1]);
    }
}