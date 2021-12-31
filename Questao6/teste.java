package Questao6;



import java.util.Scanner;

public class teste {

    

    public static void main(String[] args) {

        String[] perguntasQuiz = {"Quanto é 1 + 1? ", "Quanto é 2 x 2? ", "Quanto é 3 x 2? ", "Quanto é 4 x 4 - 8? ", "Quanto é 5 x 4 - 10? ", "Quanto é 6 + 6? ", "Quanto é 7 x 2? ", "Quanto é 2 x 8? ", "Quanto é 9 x 2? ", "Qual é a raiz quadrada de 400? "};

        int[] respostaPessoa = new int[10];
        int errou = 0;
        int acertou = 0;
        

        quiz pessoa = new quiz();

        Scanner input = new Scanner(System.in);
        System.out.printf("Digite o nome do jogador: ");

        pessoa.setNomeDoJogador(input.nextLine());

        for(int i=0; i < pessoa.respostaQuiz.length; i ++){

            System.out.printf(perguntasQuiz[i]);
            respostaPessoa[i] = input.nextInt();

            if(respostaPessoa[i] != pessoa.respostaQuiz[i]){

                System.out.println("Vc errou!!");
                errou++;
            }
            else {


                System.out.println("Vc acertou");

                acertou++;
            }

            
        }
        System.out.println("O jogador " + pessoa.getNomeDoJogador());
        System.out.printf("Conseguiu acertar %d questões e errou %d questões.\n", acertou, errou);

        //input.close();
        
        

    }

   

}
