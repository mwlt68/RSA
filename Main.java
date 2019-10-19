import java.util.Scanner;

public class Main {
    static Scanner  scanner= new Scanner(System.in);
    static int q=0,p=0,totient=0,Natural=0,encryption=0,decryption=0;
    static String message="",encryptedMsg="";
    public static void main(String[] args) {
        System.out.println("Please,Enter a p value that must be prime:");
        p=getValue();
        System.out.println("Please,Enter a q value that must be prime:");
        q=getValue();
        System.out.println("Please,Enter your message :");
        message=scanner.nextLine();
        Natural=p*q;
        System.out.println("Natural:"+Natural);
        totient=(p-1)*(q-1);
        System.out.println("Totien:"+totient);
        getEncryptionVal();
        System.out.println("e:"+encryption);
        getDecryptionVal();
        System.out.println("d:"+decryption);
        createEncryptedMessage();
        getNormalMessage();

    }
    public static void createEncryptedMessage(){
        encryptedMsg="";
        for (char x:message.toCharArray()) {
            int val=(int)x;
            encryptedMsg+=(char)EulerAndEuclid.EulerAlgorithm(val,decryption,Natural);
        }
        System.out.println("Encrypted message= "+encryptedMsg);
    }
    public static void getNormalMessage(){
        String temp="";
        for (char x:encryptedMsg.toCharArray()) {
            int val=(int)x;
            temp+=(char)EulerAndEuclid.EulerAlgorithm(val,encryption,Natural);
        }
        System.out.println("Your message= "+temp);
    }
    public static void getEncryptionVal(){
        for (int i = 2; i < totient; i++) {
            if ( EulerAndEuclid.EuclidAlgorithm(i,totient)==1){
                encryption=i;
                break;
            }
        }
    }
    public static void getDecryptionVal(){
        for (int i = 2; i < totient; i++) {
            if ( EulerAndEuclid.EuclidExpandAlgorithm(i,totient) != -1){
                decryption=EulerAndEuclid.EuclidExpandAlgorithm(i,totient);
                break;
            }

        }
    }
    public static int getValue(){
        int val;
        String enterVal="";
        enterVal=scanner.nextLine();
        try {
            val=Integer.parseInt(enterVal);
            while (!isPrime(val)){
                System.out.println("Please,Enter a prime value !");
                enterVal=scanner.nextLine();
                val=Integer.parseInt(enterVal);
            }
            return  val;
        }catch (Exception e){
            System.out.println("Please ,Enter a numerical value !");
            return -1;
        }
    }
    public static boolean isPrime(int val){

        for (int i = 2; i < val ; i++) {
            if (val % i ==0)
                return  false;
        }
        return  true;
    }
}
