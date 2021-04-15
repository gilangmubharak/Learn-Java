public class Coba {
    public static void main(String[] args) {
        int[][] cinema = new int[5][5];
        cinema[2][2] = 1; // center

        for (int i = 1; i < 4; i++) { // fourth row
            cinema[i][3] = 1;
        }
        for (int i = 0; i < 5; i++) { // the last row
            cinema[i][4] = 1;
        }
        for (int j = 0; j < cinema[0].length; j++) {
            for (int i = 0; i < cinema.length; i++) {
                System.out.print(cinema[i][j]);

                System.out.println();
            }
        }

    }
}