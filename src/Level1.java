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

        int n;
        if (encode) {
            n = str.length();
        } else {
            n = s.length();
        }

        double sq = Math.sqrt(n);
        int x;
        int y;
        int isq = (int) sq;

        if (sq == isq) {
            x = y = isq;
        } else {
            x = isq;
            y = isq + 1;
        }

        if ((x * y) < n) x++;

        char[][] matrix = new char[x][y];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ' ';
            }
        }

        int t = 0;
        StringBuilder bld2 = new StringBuilder();

        if (encode) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (t < n) {
                        matrix[i][j] = str.charAt(t);
                        t++;
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][i] == ' ') continue;
                    else {
                        bld2.append(matrix[j][i]);
                        t++;
                    }
                }

                if (i < (matrix[0].length - 1)) {
                    bld2.append(" ");
                }
            }
        } else {
            t = -1;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    t++;

                    if (t < n && s.charAt(t) != ' ') {
                        matrix[i][j] = s.charAt(t);
                    } else if (j == matrix[0].length - 1) {
                        break;
                    } else {
                        j--;
                    }
                }
            }

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][i] != ' ') {
                        bld2.append(matrix[j][i]);
                    }
                }
            }
        }

        return bld2.toString();
    }

}
