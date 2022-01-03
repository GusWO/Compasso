package Questao7;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;



public class TestaLogin {

    public static void main(String[] args) {

        ArrayList<Login> logins = new ArrayList<>();
        ArrayList<Login> verifica = new ArrayList<>();

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int minuto = calendar.get(Calendar.MINUTE);
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        
        int qntUsuarios = 1; 
        int op = 0;

        String Login, Password, LoginU, PasswordU;

        Scanner in = new Scanner(System.in);

        System.out.printf(" %d:%d \n",hora, minuto);
        
        do{
            
            
            System.out.println("1 ------ Cadastre um usuário | 2-----Fazer login | 3------saindo.");
            op = in.nextInt();
            
            switch(op) {

                case 1:


                    for(int i = 0; i < qntUsuarios; i++)
                    {
                        Login l = new Login();

                        System.out.println("Cadastre seu login: ");
                        
                        
                        Login = in.next();
                        l.setLogin(Login);

                        System.out.println("Cadastre sua senha: ");
                        

                        Password = in.next();
                        l.setPassword(Password);

                        logins.add(l);

                    }

                    

                    break;

                case 2:

                    Login NewLogin = new Login();

                    System.out.println("Digite o seu login: ");
                    System.out.flush();

                    LoginU = in.next();
                    NewLogin.setLoginU(LoginU);

                    System.out.println("Digite sua senha: ");
                    System.out.flush();

                    PasswordU = in.next();
                    NewLogin.setPasswordU(PasswordU);

                    verifica.add(NewLogin);

                    

                    for (int i = 0; i < logins.size(); i++){

                        for(int j = 0; j < verifica.size(); j++){

                            Login l = logins.get(i);
                            Login l2 = verifica.get(j);

                            System.out.println(" Login " + l.getLogin());
                            System.out.println(" Password " + l.getPassword());

                            System.out.println(" LoginU :" + l2.getLoginU());
                            System.out.println(" PasswordU :" + l2.getPasswordU());

                            if(l.getLogin().equals(l2.getLoginU()) && l.getPassword().equals(l2.getPasswordU())){

                                int horaNova = hora;
                                int minutoNovo = minuto;

                                if(horaNova >= 6 && horaNova <= 11 && minutoNovo <= 59){

                                    System.out.println("Bom dia, você se logou ao nosso sistema.");
                                
                                }else if(horaNova >= 12 && horaNova <= 17 && minutoNovo <= 59){

                                    System.out.println("Boa tarde, você se logou ao nosso sistema.");
                                
                                }else if(horaNova >= 18 && horaNova <= 23 && minutoNovo <= 59){

                                    System.out.println("Boa noite, você se logou ao nosso sistema.");
                               
                                }else if(horaNova >= 0 && horaNova <= 5 && minutoNovo <= 59){

                                    System.out.println("Boa madrugada, você se logou ao nosso sistema.");
                                
                                }
                            }else {

                                System.err.println("Login e senha inválidos");
                            }
                        }
                    }

                    break; 

                case 3:

                    System.out.println("Saindo");
                    break;
            
            } 

        }while(op != 3);
    }
             
}

