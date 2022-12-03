public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        // removing spaces
        char[] ca = s.toCharArray();
        StringBuilder noSpaces = new StringBuilder();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                noSpaces.append(ca[i]);
            }
        }
        String str = noSpaces.toString();

        // string length
        int n;
        if (encode) {
            n = str.length();
        } else {
            n = s.length();
        }

        // sqrt for matrixRabbitDecoder length
        double sq = Math.sqrt(n);
        int x;
        int y;
        int isq = (int) sq;

        // matrixRabbitDecoder size
        if (sq == isq) {
            x = y = isq;
        } else {
            x = isq;
            y = isq + 1;
        }

        if ((x * y) < n) x++;

        // new matrixRabbitDecoder
        char[][] matrixRabbitDecoder = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrixRabbitDecoder[i][j] = ' ';
            }
        }

        int t = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // --- encode ---
                if (t < n && encode) {
                    matrixRabbitDecoder[i][j] = str.charAt(t);
                    t++;
                    continue;

                } else if (encode) {
                    break;
                }

                // --- decode ---
                if (t < n && s.charAt(t) != ' ') {
                    matrixRabbitDecoder[i][j] = s.charAt(t);
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
                if (matrixRabbitDecoder[j][i] != ' ') {
                    bld2.append(matrixRabbitDecoder[j][i]);
                }
            }

            if (i < (y - 1) && encode) {
                bld2.append(" ");
            }
        }

        return bld2.toString();
    }
}