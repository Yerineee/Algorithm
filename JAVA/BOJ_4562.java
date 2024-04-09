import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_4562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        while(n-->0) {
        	StringTokenizer st=new StringTokenizer(br.readLine());

            int X=Integer.parseInt(st.nextToken());
            int Y=Integer.parseInt(st.nextToken());

            if(X>=Y) {
                System.out.println("MMM BRAINS");
            }
            else {
                System.out.println("NO BRAINS");
            }
        }
    }
}