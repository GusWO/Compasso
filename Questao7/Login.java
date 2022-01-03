package Questao7;





public class Login {
    
    private String Login ;
    private String Password ;
    private String LoginU ;
    private String PasswordU ;



    public Login(){}

    public String getPasswordU() {
        return PasswordU;
    }

    public void setPasswordU(String passwordU) {
        this.PasswordU = passwordU;
    }

    public String getLoginU() {
        return LoginU;
    }

    public void setLoginU(String loginU) {
        this.LoginU = loginU;
    }

    public Login(String Login, String Password, String LoginU, String PasswordU){

        this.Login = Login;
        this.Password = Password;
        this.LoginU = LoginU;
        this.PasswordU = PasswordU;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }




    
}
