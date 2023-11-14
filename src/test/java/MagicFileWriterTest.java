import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MagicFileWriterTest {

    @Test
    void writeToSpecificLine1() {
        File sourceFile = MagicFileUtils.createFile("t1.txt", "");
        MagicFileWriter.writeToSpecificLine(sourceFile, 0, "превед", 0);

        Assertions.assertEquals("превед", MagicFileReader.readFromSpecificLine(sourceFile, 0));

        sourceFile.deleteOnExit();
    }

    @Test
    void writeToSpecificLine2() throws IOException {
        File sourceFile = MagicFileUtils.createFile("t2.txt", "");
        FileUtils.writeLines(sourceFile, List.of("1", "2"));
        MagicFileWriter.writeToSpecificLine(sourceFile, 2, "превед", 2);

        Assertions.assertEquals("превед", MagicFileReader.readFromSpecificLine(sourceFile, 2));

        sourceFile.deleteOnExit();
    }

    @Test
    void writeToSpecificLine3() throws IOException {
        File sourceFile = MagicFileUtils.createFile("t3.txt", "");
        FileUtils.writeLines(sourceFile, List.of("1", "2"));
        MagicFileWriter.writeToSpecificLine(sourceFile, 1, "превед", 2);

        Assertions.assertEquals("превед", MagicFileReader.readFromSpecificLine(sourceFile, 1));

        sourceFile.deleteOnExit();
    }
}