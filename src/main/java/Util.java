import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Util {


    public static Optional<String> readFile(String name){
        try(BufferedReader br = new BufferedReader(new FileReader(name))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return Optional.of(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
