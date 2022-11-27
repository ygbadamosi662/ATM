import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;
import  java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Random;


public class Bank {
    String bankName = "Vfd microfinance bank";

//    ArrayList<String> Banks = new ArrayList<>(Arrays.asList("Vfd Microfinance Bank",
//            "GT Bank","First Bank"));
//
//    ArrayList<String> Banksid = new ArrayList<>(Arrays.asList("1007","3334","2334"));
//
//    ArrayList<String> cardIds = new ArrayList<>(Arrays.asList("5524","6723","9602"));
    String bankId = "1007";
    String cardId = "5524";

    ArrayList<User> users = new ArrayList<>();



    public String generator(String prefixStringIfNonePutEmpty,int howManyRandosPlusPrefix){
        String urEmptyStringVariable = "";
        Random rand = new Random();
        int upperbound = 10;
        int l;
        int a;
        int c =0;
        if (prefixStringIfNonePutEmpty != "") {
            a = prefixStringIfNonePutEmpty.length();
            c = howManyRandosPlusPrefix - a;
        }else if(prefixStringIfNonePutEmpty == ""){
            c = howManyRandosPlusPrefix;
        }

        for (l = 0; l < c; l++) {
            int rando = rand.nextInt(upperbound);
            String randi = Integer.toString(rando);
            prefixStringIfNonePutEmpty = prefixStringIfNonePutEmpty.concat(randi);
        }
        urEmptyStringVariable = prefixStringIfNonePutEmpty;

        return urEmptyStringVariable;
    }



    public void registerUsers() {

        User hi = new User();

        System.out.println("Hi,welcome to vfd Microfinance Bank,lets register your account with us today");
        System.out.println("Enter your first name");
        Scanner scanner = new Scanner(System.in);
        String fname = scanner.nextLine();
        hi.setUserFirstname(fname);
        System.out.println("Enter your lastname");
        String lname = scanner.nextLine();
        hi.setUserLastname(lname);

        int b;
        int a=1;
        for(b=0; b<a; b++) {
            System.out.println("Set a user id...6 characters minimum," +
                    "10 characters max,if u like do sturborn");
            String userId = scanner.nextLine();
            if ((userId.length() > 10) || (userId.length() < 6)) {
                a++;
            } else {
                hi.setUserId(userId);
            }
        }


        System.out.println("Great,lets set ur pin now...." +
                "just any four digit number no alphabets no special characters");

        b=0;
        a=1;
        for(b=0; b<a; b++) {
            String pin = scanner.nextLine();
            if(pin.matches("[0-9]{4,4}")) {
                hi.setPassword(pin);

            }
            else{
                System.out.println("It has to be four digits man!");
                a++;
            }
        }
        System.out.println("Great now lets set up ur accout for you, \n \n");

//        accout setup intitiation
//        generating accout number

        String accNum = generator(bankId,10);
        hi.setAccountNumber(accNum);

//        generating card number
        String cNum = generator(cardId,15);
        hi.setCardNumber(cNum);

//        generating cvv
        String cvv = generator("",3);
        hi.setCardCvv(cvv);

//      generating card expiry date
        LocalDate today = LocalDate.now();
        int year = today.getYear() + 5;
        int month = today.getMonthValue();
        String exxp = Integer.toString(year) +"/"+Integer.toString(month);

        hi.setCardExpiryDate(exxp);

        System.out.println("Now you are done,you are a proud beneficiary of account number "+
                hi.getAccountNumber());
        System.out.println("Your new card details is below👇");
        System.out.println("Card number: "+hi.getCardNumber()+"\n"+"cvv: "+hi.getCardCvv()+"\n"
        +"Card expiry date: "+hi.getCardExpiryDate()+"\n \n" +
                "...now that ur account is set,how much will be your first deposit with us?👇");
        int howMuch = Integer.parseInt(scanner.nextLine());
        hi.setAccBalance(howMuch);
        System.out.println("Congrats,your new account balance is "+hi.getAccBalance()+"\n \n \n");
        users.add(hi);

        useCard();

    }

//    card attributes
    public void useCard() {
        User mkSure = new User();
        System.out.println("Welcome to Vfd Microfinance Bank,enter your card number below 👇");
        Scanner scanner = new Scanner(System.in);
        String nowNum = scanner.nextLine();

        int k;
        for (k = 0; k < users.size(); k++ ) {
            User user0 = users.get(k);
            if (user0.getCardNumber().equals(nowNum)){
                mkSure = users.get(k);
                k = users.size();
            }
            else if((k == users.size()-1) && (!user0.getAccountNumber().equals(nowNum))){
                System.out.println("Incorrect card number!");
                useCard();
            }
        }


        System.out.println("Welcome " + mkSure.getUserFirstname() + ",what you tryna do?");
        System.out.println("enter 1 if withdrawal,2 if deposit and 3 if transfer👇");
        int userWants = Integer.parseInt(scanner.nextLine());

//           dissecting what service the user wants
        if (userWants == 1 || userWants == 3) {
            if (userWants == 1) {
                System.out.println("OK,how much you want...👇");
                int userComot = Integer.parseInt(scanner.nextLine());

                int i;
                int j = 1;
                for (i = 0; i < j; i++) {
                    System.out.println("Enter your pin👇");
                    String userPin = scanner.nextLine();

//                        System.out.println(mkSure.getPassword());
                    if (mkSure.getPassword().equals(userPin)) {
                        mkSure.updateAccBalance(0, userComot);

                        System.out.println("Transaction succesful");
                        System.out.println("Ur new balance is " + mkSure.getAccBalance()+"\n \n \n");
                        useCard();
                    }
                    else {
                        System.out.println("incorrect pin");
                        j++;
                        if (j > 5) {
                            System.out.println("Exceeded number of valid tries,try again later");
                            useCard();
                        }
                    }
                }

            } else if (userWants == 3) {
                System.out.println("to what bank?");
                String tBank = scanner.nextLine();
                System.out.println("Account number?");
//                    write a program that checks and confam beneficiary account

                String tNumber = scanner.nextLine();
                int l;
                for (l = 0; l < users.size(); l++) {
                    User kil = users.get(l);
                    if (kil.getAccountNumber().equals(tNumber)) {
                        l = users.size();
                        System.out.println("Accout number: " + tNumber + " belongs to "
                                + kil.getUserFirstname() + " " + kil.getUserLastname()
                        );

                    } else if ((l == users.size() - 1) && (!kil.getAccountNumber().equals(nowNum))) {
                        System.out.println("Incorrect accout number!");
                    }
                }
                System.out.println("If the above information is correct,how much?");
                int tMuch = Integer.parseInt(scanner.nextLine());

                int i;
                int j = 1;
                for (i = 0; i < j; i++) {
                    System.out.println("Enter your pin👇");
                    String userPin = scanner.nextLine();

                    if (mkSure.getPassword().equals(userPin)) {

                        mkSure.updateAccBalance(0, tMuch);

                        System.out.println("Your transfer to" + "account number: " + tNumber +
                                " is succesful");
                        System.out.println("Ur new balance is " + mkSure.getAccBalance()+"\n \n \n");
                        useCard();
                    }
                    else {
                        System.out.println("incorrect pin");
                        j++;
                        if (j > 5) {
                            System.out.println("Exceeded number of valid tries,try again later");
                            useCard();
                        }

                    }


                }
            }
        }

        else if (userWants == 2) {
            System.out.println("How much do you want to deposit?");

            int depo = Integer.parseInt(scanner.nextLine());


            int i;
//                    int k = 1;
            int j = 1;
            for (i = 0; i < j; i++) {
                System.out.println("Enter your pin👇");
                String userPin = scanner.nextLine();

                if (mkSure.getPassword().equals(userPin)) {
                    mkSure.updateAccBalance(depo, 0);
                    System.out.println("Transaction Successful");
                    System.out.println("Ur new balance is " + mkSure.getAccBalance()+"\n \n \n");

                    useCard();
                }
                else {
                    j++;
                    System.out.println("incorrect pin,");
                    if (j > 5) {
                        System.out.println("Exceeded number of valid tries,try again later");
                        useCard();
                    }
                }
            }
        }
    }

    public void homepage(){
        System.out.println("Welcome to Vfd Microfinance Bank....what can we do for you?....\n" +
                "Want to register with us? if yes enter 1\nAlready have an account with us? enter 2");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        if (action.equals("1")){
            registerUsers();
        }
        else if(action.equals("2")){
            useCard();
        }
        else{
            System.out.println("its gotta be 1 or 2 mehn");

            homepage();
        }

    }

//    public String myNairaFormater(String amountInString){
//        if (amountInString.length() <= 3){
//            return amountInString;
//        }
//        else{
//
//        }
//
//    }

}

