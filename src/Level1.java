public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        // removing spaces
        char[] ca = s.toCharArray();
        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                bld.append(ca[i]);
            }
        }
        String str = bld.toString();

        // string length
        int n;
        if (encode) {
            n = str.length();
        } else {
            n = s.length();
        }

        // sqrt for matrix length
        double sq = Math.sqrt(n);
        int x;
        int y;
        int isq = (int) sq;

        // matrix size
        if (sq == isq) {
            x = y = isq;
        } else {
            x = isq;
            y = isq + 1;
        }

        if ((x * y) < n) x++;

        // new matrix
        char[][] matrix = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = ' ';
            }
        }

        int t = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // --- encode ---
                if (t < n && encode) {
                    matrix[i][j] = str.charAt(t);
                    t++;
                    continue;

                } else if (encode) {
                    break;
                }

                // --- decode ---
                if (t < n && s.charAt(t) != ' ') {
                    matrix[i][j] = s.charAt(t);
                    t++;

                } else if (j == y - 1) {
                    t++;
                    break;

                } else {
                    t++;
                    j--;
                }
            }
        }

        // creating a new string
        StringBuilder bld2 = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[j][i] != ' ') {
                    bld2.append(matrix[j][i]);
                }
            }

            if (i < (y - 1) && encode) {
                bld2.append(" ");
            }
        }

        return bld2.toString();
    }
}