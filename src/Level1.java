public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        char[] ca = s.toCharArray();
        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                bld.append(ca[i]);
            }
        }

        String str = bld.toString();
        int n = str.length();

        double sq = Math.sqrt(n);

        int x = (int) sq;
        int y = (int) (sq + 1);

        if ((x * y) < n) x++;

        char[][] matrix = new char[x][y];

        int t = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = str.charAt(t);
                t++;

                if (t == n) break;
            }

            if (t == n) break;
        }

        StringBuilder bld2 = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                bld2.append(matrix[j][i]);
            }

            bld2.append(" ");
        }

        String strFin = bld2.toString();

        return strFin;
    }

}
