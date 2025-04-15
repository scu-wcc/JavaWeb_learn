import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {


        Socket socket = new Socket("localhost",6666);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = br.readLine();


    }
}
