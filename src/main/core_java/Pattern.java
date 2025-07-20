package core_java;

public class Pattern {

    public Pattern printPattern1(int n){

        for (int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        return new Pattern();
    }

    public Pattern printPattern2(int n){

        for (int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            } 
            for(int j=1; j<=((i*2)-1); j++){
                System.out.print("*");
            }
            System.out.println("");
        }


        return new Pattern();
    }

    public Pattern printPattern3(int n){

        for (int i = n; i >= 1; i--) {
                // Print leading spaces
                for (int j = 0; j < n - i; j++) {
                    System.out.print(" ");
                }
                // Print stars
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

        return this;
    }

}