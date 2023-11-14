import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MagicFileReader {

    public static String readFromSpecificLine(File file, int lineNumber) {
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
            for (int i = 0; i < lineNumber; i++) {
                lnr.readLine();
            }
            return lnr.readLine();
        }
        catch (IOException e) {
            String errorMessage = String.format("Не удалось прочитать строку №%s из файла %s", lineNumber, file);
            log.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
