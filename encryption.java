import java.util.Scanner;

public class encryption {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 0 to encrypt or 1 to decrypt");
        int a = input.nextInt();
        System.out.println("enter text");
        String b = input.next();
        if (a == 0)
            encrypt(b);
        else
            decrypt(b);
    }
        private static void encrypt (String entery)
        {
            char[] array = entery.toCharArray();
            int[] numeric = new int[50];
            int i = 0;
            while (i < array.length) {
                numeric[i] = (((int)array[i]-7+5)%58)+65;
                i++;
            }
            int j = 0;
            while (numeric[j] != 0) {
                System.out.printf("%c", (char) numeric[j]);
                j++;
            }
            System.out.println(" is the secret text");
        }
    private static void decrypt (String entery)
    {
        char[] array = entery.toCharArray();
        int[] numeric = new int[50];
        int i = 0;
        while (i < array.length) {
            numeric[i] = (((int)array[i]-70)%58);
            if(numeric[i]<0)
            numeric[i]+=58;

            numeric[i]+=65;
            i++;
        }
        int j = 0;
        while (numeric[j] != 0) {
            System.out.printf("%c", (char) numeric[j]);
            j++;
        }
        System.out.println(" is the orginal text");
    }


}
