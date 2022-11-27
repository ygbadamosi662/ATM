public class User {

    private int accBalance = 1095000;
    private String userFirstname;
    private String userLastname;
    private String accountNumber;
    private String cardNumber;
    private String cardCvv;
    private String cardExpiryDate;

    private String userId;

    private String password;

    public User(){}

    public User (String userFirstname,String userLastname,String accountNumber,
                 String cardNumber,String cardCvv,String cardExpiryDate,String password,String userId ){
        this.cardExpiryDate = cardExpiryDate;
        this.cardCvv = cardCvv;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userId = userId;
        this.password = password;
    }

//    getters
    public String getUserFirstname(){return this.userFirstname;}

    public String getUserLastname(){return this.userLastname;}

    public String getAccountNumber(){return this.accountNumber;}

    public String getCardNumber(){return this.cardNumber;}

    public String getCardCvv(){return this.cardCvv;}

    public String getCardExpiryDate(){return this.cardExpiryDate;}

    public String getUserId(){return this.userId;}

    public String getPassword(){return this.password;}

    public int getAccBalance (){return this.accBalance;}

//    setters
    public void setUserFirstname(String userFirstname){ this.userFirstname = userFirstname;}

    public void setUserLastname(String userLastname){ this.userLastname = userLastname;}

    public void setAccountNumber(String accountNumber){ this.accountNumber = accountNumber;}

    public void setCardNumber(String cardNumber){ this.cardNumber = cardNumber;}

    public void setCardCvv(String cardCvv){ this.cardCvv = cardCvv;}

    public void setCardExpiryDate(String cardExpiryDate){ this.cardExpiryDate = cardExpiryDate;}

    public void setPassword(String password){ this.password = password;}

    public void setUserId(String userId){ this.userId = userId;}

    public void setAccBalance(int accBalance){this.accBalance = accBalance;}

    public int updateAccBalance(int a,int b){
        this.accBalance = this.accBalance + a;
        this.accBalance = this.accBalance - b;

        return 0;
    }
}
