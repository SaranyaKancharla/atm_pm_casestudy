import java.io.*;
import java.util.*;
class welcomemsg
{
    welcomemsg()
    {
        System.out.println("Welcome to XYZ atm");
        System.out.println("Press 1 : If you want to create a new account");
        System.out.println("Press 2 : If you want to view your balance");
        System.out.println("Press 3 : If you want to withdraw your cash");
        System.out.println("Press 4 : If you want to deposit the cash");
        System.out.println("Press 5 : If you want to exit");
    }
}
class userdetails
{
    Scanner sc=new Scanner(System.in);

    private String username;
    private String phonenum;

   userdetails()
    {
        this.setUsername();
        this.setPhonenum();

    }
    public String getUsername() {

        return username;
    }

    public void setUsername() {
        System.out.println("Enter username :");
        username=sc.nextLine();

    }
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum() {
        System.out.println("Enter phone number :");
        phonenum = sc.nextLine();
    }

}


class newaccount
{
    String accountnum(){
    Random random = new Random();
    int num = random.nextInt(100000);
    String formatted = String.format("%05d", num);
        System.out.println("Your account number:");
        System.out.println(formatted);
    return formatted;}

     String pinnum()
    {
        Random random = new Random();
        int num = random.nextInt(100000);
        String formatted = String.format("%05d", num);
        System.out.println("Your pin:");
        System.out.println(formatted);
        return formatted;
    }
    String otp()
    {
        Random random = new Random();
        int num = random.nextInt(100000);
        String formatted = String.format("%06d", num);
        System.out.println("Your otp:");
        System.out.println(formatted);
        return formatted;
    }
}
class customer extends userdetails
{
    customer()
    {
        super();
    }
}
class viewbalance
{
    Double i;
    viewbalance(Double i)
    {
        System.out.println("Current balance : "+i);
    }
}
public class atm {
    public static void main(String args[])
    {
        welcomemsg w=new welcomemsg();
        Scanner sc=new Scanner(System.in);
        ArrayList<String> A=new ArrayList<String>();
        ArrayList<String> B=new ArrayList<String>();
        ArrayList<Double> C=new ArrayList<Double>();
        ArrayList<customer> D=new ArrayList<customer>();
        while(100>0){

        int m=sc.nextInt();
        if(m==1)
        {

            customer c=new customer();
            newaccount n=new newaccount();
            String a=n.accountnum();
            String b=n.pinnum();
            System.out.println("Enter the amount paid:");
            double amount=sc.nextDouble();

            A.add(a);
            B.add(b);
            C.add(amount);
            D.add(c);


        }
        if(m==2){
            System.out.println("Enter account number:");

            String s=sc.next();
            System.out.println("Enter pin:");
            String pin=sc.next();

            newaccount n=new newaccount();
            String p=n.otp();
            System.out.println("Enter otp:");

            String otp=sc.next();
            int i=A.indexOf(s);

            if(pin.equals(B.get(i))&&p.equals(otp))
            {
                viewbalance v=new viewbalance(C.get(i));
            }
            else
            {
                System.out.println("User details doesn't match");
                System.exit(0);
            }
        }
        if(m==3)
        {
            System.out.println("Enter the account number:");
            String s=sc.next();
            System.out.println("Enter the pin:");
            String pin=sc.next();
            int i=A.indexOf(s);
            newaccount n=new newaccount();
            String p=n.otp();
            System.out.println("Enter the otp:");
            String otp=sc.next();

            if(pin.equals(B.get(i))&&p.equals(otp))
            {
                System.out.println("Enter the amount to be withdrawn:");
                double d=sc.nextDouble();
                if(C.get(i)>=d)
                {
                    double f=C.get(i)-d;
                    C.set(i,f);
                    viewbalance v=new viewbalance(C.get(i));
                }
                else
                {
                    System.out.println("Insufficient balance");
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("User details doesn't match");
                System.exit(0);
            }
        }
        if(m==4)
        {
            System.out.println("Enter the account number:");
            String s=sc.next();
            System.out.println("Enter the pin:");
            String pin=sc.next();
            int i=A.indexOf(s);
            newaccount n=new newaccount();
            String p=n.otp();
            System.out.println("Enter otp:");
            String otp=sc.next();

            if(pin.equals(B.get(i))&p.equals(otp))
            {
                System.out.println("Enter the amount to be deposited");
                double d=sc.nextDouble();
                double f=d+C.get(i);
                C.set(i,f);
                viewbalance v=new viewbalance(C.get(i));
            }
            else
            {
                System.out.println("User details doesn't match");
                System.exit(0);
            }
        }
        if(m==5)
        {
            System.exit(0);
        }



    }}

    }

