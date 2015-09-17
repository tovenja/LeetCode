

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main1 {
    InputStream is;
    PrintWriter out;
    String INPUT = "1 2 34 5";
    private boolean oj = true;

    void solve() throws Exception {
        int t = ni();
        while(t-->0){
            String num = ns();
            int res =0;
            int c9=0,c7=0,c0=0,c6=0;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i)=='9'){
                    c9++;
                }
                else if (num.charAt(i)=='7'){
                    c7++;
                    c7=Math.min(c7, c9);
//                    c9=Math.max(0,c9-1);

                }
                else if (num.charAt(i)=='0'){
                    c0++;
                    c0 = Math.min(c7, c0);
//                    c7=Math.max(0,c7-1);
                }
                else if (num.charAt(i)=='6'){
                    c6++;
                    c6=Math.min(c0, c6);
//                    c0=Math.max(0,c0-1);
                    res=c6;
                }

            }
            System.out.println(res);

        }
    }

    void run() throws Exception {
        is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new Main1().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private boolean hasNext() throws Exception {
        is.mark(1);
        int res = is.read();
        is.reset();
        return res > 0;
    }


    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }


    private void tr(Object... o) {
        if (!oj) System.out.println(Arrays.deepToString(o));
    }
}