package core_java;

public class Pattern {

    public static void printPattern(int n){
        for (int i =1; i<=n; i++){
            System.out.print("*");
            for(int j=1; j<=n-i; j++){
                System.out.println("");
            }

        }
    }
}
