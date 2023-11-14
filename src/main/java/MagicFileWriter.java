import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Slf4j
public class MagicFileWriter {

    public static void writeToSpecificLine(File file, int lineNumber, String line, int resultFileLength) {
        File tempFile = MagicFileUtils.createFile(file.getName(), "_temp");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            for (int i = 0; i < lineNumber; i++) {
                String lineFromSourceFile = MagicFileReader.readFromSpecificLine(file, i);
                appendLineToFile(bufferedWriter, lineFromSourceFile);
            }
            appendLineToFile(bufferedWriter, line);
            for (int i = lineNumber; i < resultFileLength; i++) {
                String lineFromSourceFile = MagicFileReader.readFromSpecificLine(file, i);
                appendLineToFile(bufferedWriter, lineFromSourceFile);
            }
            Files.copy(tempFile.toPath(), file.toPath(), REPLACE_EXISTING);
        } catch (IOException e) {
            String errorMessage = String.format("Не удалось записать строку №%s в файл %s", lineNumber, file);
            log.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        } finally {
            tempFile.delete();
        }
    }

    private static void appendLineToFile(BufferedWriter bufferedWriter, String line) {
        try {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e) {
            String errorMessage = "Не удалось записать строку в файл";
            log.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
