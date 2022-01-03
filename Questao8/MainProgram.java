package Questao8;

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    
    public static void main(String[] args) {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        String nome;
        double salario;
        int qntFuncionarios;
        
        Scanner in = new Scanner(System.in);

        int op = 0;
        do {

            System.out.println("Selecione as opções");
            System.out.println("1-----------Cadastrar");
            System.out.println("2-----------Listar e ver o bônus");
            System.out.println("3-----------Sair");

            op = in.nextInt();

            switch (op){


                case 1:
                    
                    System.out.println("Digite o nro de funcionarios que vc quer cadastrar: ");
                    qntFuncionarios = in.nextInt();

                    for(int i = 0; i < qntFuncionarios; i++){

                        Funcionario f = new Funcionario();
                        System.out.printf("Digite o nome %d funcionario: \n", i + 1);
                        
                        nome = in.next();
                        f.setNome(nome);

                        System.out.printf("Digite o salário do %d funcionario: \n", i + 1);
                        
                        salario = in.nextDouble();
                        f.setSalario(salario);

                        funcionarios.add(f);
                    }
                    break;

                case 2:

                    for(int i = 0; i < funcionarios.size(); i++)
                    {
                        Funcionario f = funcionarios.get(i);
                        
                        if(f.getSalario() <= 1000){
                            
                            double bonus = (f.getSalario() * 20) / 100;
                            salario = f.getSalario() + bonus;
                            
                            System.out.println("Nome: " + f.getNome());
                            System.out.println("Salário: " + f.getSalario());
                            System.out.println("Bônus: " + bonus);
                            System.out.println("Salário líquido: " + salario);
                            System.out.println("***************************");
                        
                        }else if(f.getSalario() > 1000 && f.getSalario() <= 2000){

                            double bonus = (f.getSalario() * 10) / 100;
                            salario = f.getSalario() + bonus;

                            System.out.println("Nome: " + f.getNome());
                            System.out.println("Salário: " + f.getSalario());
                            System.out.println("Bônus: " + bonus);
                            System.out.println("Salário líquido: " + salario);
                            System.out.println("***************************");
                        
                        }else{

                            double desconto = (f.getSalario() * 10) / 100;
                            salario = f.getSalario() - desconto;

                            System.out.println("Nome: " + f.getNome());
                            System.out.println("Salário: " + f.getSalario());
                            System.out.println("Desconto: " + desconto);
                            System.out.println("Salário líquido: " + salario);
                            System.out.println("***************************");
                        }
                    }

                    break;

                case 3:
                    
                    System.out.println("Você fechou o sistema");
                    break;
                
                default:

                    System.out.println("Opção inválida");
            }


        } while(op != 3);
        

        
    }
}
