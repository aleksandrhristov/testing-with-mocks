import java.util.Scanner;

/**
 * Created by clouway on 22.06.16.
 */
public class Demo {


    public static void main(String[] args) throws IntegersOnlyStringExceptions {
        Sumator su = new Sumator();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String sum = "";
        try {
            sum = su.sum(str1, str2);
        } catch (Exception e) {
            throw new IntegersOnlyStringExceptions();
        }

        System.out.println(sum);
    }
}
