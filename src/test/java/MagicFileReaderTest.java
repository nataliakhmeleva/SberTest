import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MagicFileReaderTest {

    @Test
    void readFromSpecificLine1() {
        String sourceFileName = "test1.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());

        String line = MagicFileReader.readFromSpecificLine(sourceFile, 0);

        Assertions.assertNotNull(line);
        Assertions.assertEquals("d   123", line);
    }

    @Test
    void readFromSpecificLine2() {
        String sourceFileName = "test2.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());

        String line = MagicFileReader.readFromSpecificLine(sourceFile, 3);

        Assertions.assertNotNull(line);
        Assertions.assertEquals("a   123", line);
    }

    @Test
    void readFromSpecificLine3() {
        String sourceFileName = "test4.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());

        String line = MagicFileReader.readFromSpecificLine(sourceFile, 66);

        Assertions.assertNotNull(line);
        Assertions.assertEquals("Ww5FRF6WCTP7GvVAY6B97SU2fZRCsYwV", line);
    }
}