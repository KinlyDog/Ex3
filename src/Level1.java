public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        // removing spaces
        char[] stringToChar = s.toCharArray();
        StringBuilder noSpaces = new StringBuilder();

        for (char c : stringToChar) {
            if (c != ' ') {
                noSpaces.append(c);
            }
        }

        String str = noSpaces.toString();

        // string length
        final int STRING_LENGTH;
        if (encode) {
            STRING_LENGTH = str.length();
        } else {
            STRING_LENGTH = s.length();
        }

        // sqrt for matrixRabbitDecoder length
        final double SQRT_FROM_LENGTH = Math.sqrt(STRING_LENGTH);
        int x;
        int y;
        final int INT_FROM_SQRT = (int) SQRT_FROM_LENGTH;

        // matrixRabbitDecoder size
        if (SQRT_FROM_LENGTH == INT_FROM_SQRT) {
            x = y = INT_FROM_SQRT;
        } else {
            x = INT_FROM_SQRT;
            y = INT_FROM_SQRT + 1;
        }

        if ((x * y) < STRING_LENGTH) x++;

        // new matrixRabbitDecoder
        char[][] matrixRabbitDecoder = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrixRabbitDecoder[i][j] = ' ';
            }
        }

        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // --- encode ---
                if (count < STRING_LENGTH && encode) {
                    matrixRabbitDecoder[i][j] = str.charAt(count);
                    count++;
                    continue;

                } else if (encode) {
                    break;
                }

                // --- decode ---
                if (count < STRING_LENGTH && s.charAt(count) != ' ') {
                    matrixRabbitDecoder[i][j] = s.charAt(count);
                    count++;

                } else if (j == y - 1) {
                    count++;
                    break;

                } else {
                    count++;
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