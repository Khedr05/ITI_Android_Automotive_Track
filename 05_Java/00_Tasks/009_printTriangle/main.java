/*class Shape {
    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 1; i < n; i++) {
            // First triangle
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.print("\t\t");

            // Printing spaces before the second triangle to align it
            for (int k = 0; k < (n - i); k++) {
                System.out.print(" ");
            }

            // Second triangle
            for (int j = 0; j < i; j++) {
                System.out.print(" *");
            }

            System.out.println();
        }
    }
}*/

/*
class Shape {

    public static void main(String[] args) {
        int n = 4; // Change this value to adjust the size of the triangle

        for (int i = 1; i <= n; i++) {
            // Print the left side of the triangle
            System.out.print(repeat("*", i));
            
            // Print the spaces in the middle
            System.out.print(repeat(" ", (n - i) * 2));

            // Print the right side of the triangle
            System.out.print(repeat(" *", i));

            System.out.println();
        }
    }

    public static String repeat(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}*/


class Shape {
    public static void main(String[] args) {
        int n = 4;  

        printTriangle(n,1);
    }

    public static void printTriangle(int n, int i) {
        if (i > n) {
            return;
        }

        printStars(i);
        
        printSpaces((n - i) * 2);

        printRightSide(i);

        System.out.println();

        printTriangle(n, i + 1);
    }

    public static void printStars(int count) {
        if (count <= 0) {
            return;
        }
        System.out.print("*");
        printStars(count - 1);
    }

    public static void printSpaces(int count) {
        if (count <= 0) {
            return;
        }
        System.out.print(" ");
        printSpaces(count - 1);
    }

    public static void printRightSide(int count) {
        if (count <= 0) {
            return;
        }
        System.out.print(" *");
        printRightSide(count - 1);
    }
}


