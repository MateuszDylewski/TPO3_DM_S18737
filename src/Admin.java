import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Admin {

    public static void main(String[] args) throws IOException {
        Request request = new Request();

        AdminWindow adminWindow = new AdminWindow();
        Thread adminWindowThread = new Thread(() -> adminWindow.startWindow(request));
        adminWindowThread.start();

        SocketChannel channel = null;
        String server = "localhost"; // adres hosta serwera
        int port = 12345; // numer portu

        try {
            // Utworzenie kanału
            channel = SocketChannel.open();

            // Ustalenie trybu nieblokującego
            channel.configureBlocking(false);

            // połączenie kanału
            channel.connect(new InetSocketAddress(server, port));

            System.out.print("Admin: łączę się z serwerem ...");

            while (!channel.finishConnect()) {
                // ew. pokazywanie czasu łączenia (np. pasek postępu)
                // lub wykonywanie jakichś innych (krótkotrwałych) działań
            }

        } catch(UnknownHostException exc) {
            System.err.println("Uknown host " + server);
            // ...
        } catch(Exception exc) {
            exc.printStackTrace();
            // ...
        }

        System.out.println("\nAdmin: jestem połączony z serwerem ...");

        Charset charset  = Charset.forName("ISO-8859-2");
        Scanner scanner = new Scanner(System.in);

        // Alokowanie bufora bajtowego
        // allocateDirect pozwala na wykorzystanie mechanizmów sprzętowych
        // do przyspieszenia operacji we/wy
        // Uwaga: taki bufor powinien być alokowany jednokrotnie
        // i wielokrotnie wykorzystywany w operacjach we/wy
        int rozmiar_bufora = 1024;
        ByteBuffer inBuf = ByteBuffer.allocateDirect(rozmiar_bufora);
        CharBuffer cbuf = null;

        // pętla czytania
        while (true) {

            if(request.topic != null && request.news != null) {
                System.out.println("Admin: wysyłam - " + request.topic);
                // "Powitanie" do serwera
                channel.write(charset.encode("ADMIN " + request.topic + ";" + request.news + '\n'));
                request.topic = null;
                request.news = null;
            }

            //cbuf = CharBuffer.wrap("cos" + "\n");

            inBuf.clear();	// opróżnienie bufora wejściowego
            int readBytes = channel.read(inBuf); // czytanie nieblokujące
            // natychmiast zwraca liczbę
            // przeczytanych bajtów

            // System.out.println("readBytes =  " + readBytes);

            if (readBytes == 0) {                              // jeszcze nie ma danych
                //System.out.println("zero bajtów");

                // jakieś (krótkotrwałe) działania np. info o upływającym czasie

                continue;

            }
            else if (readBytes == -1) { // kanał zamknięty po stronie serwera
                // dalsze czytanie niemożlwe
                // ...
                break;
            }
            else {		// dane dostępne w buforze
                //System.out.println("cos jest od serwera");

                inBuf.flip();	// przestawienie bufora

                // pobranie danych z bufora
                // ew. decyzje o tym czy mamy komplet danych - wtedy break
                // czy też mamy jeszcze coś do odebrania z serwera - kontynuacja
                cbuf = charset.decode(inBuf);

                String odSerwera = cbuf.toString();

                System.out.println("Admin: serwer właśnie odpisał ... " + odSerwera);
                ClientWindow.news.setValue(odSerwera);
                cbuf.clear();

                if (odSerwera.equals("Bye")) break;
            }

            // Teraz klient pisze do serwera poprzez Scanner
            /*String input = scanner.nextLine();
            cbuf = CharBuffer.wrap(input + "\n");
            ByteBuffer outBuf = charset.encode(cbuf);
            channel.write(outBuf);

            System.out.println("Klient: piszę " + input);*/
        }

        scanner.close();
    }
}
