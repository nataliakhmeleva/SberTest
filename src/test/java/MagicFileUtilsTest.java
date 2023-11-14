import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class MagicFileUtilsTest {

    @Test
    void successCheckFile() {
        Assertions.assertDoesNotThrow(() -> MagicFileUtils.checkFile("test1.txt"));
    }

    @Test
    void failCheckFile() {
        Assertions.assertThrows(RuntimeException.class, () -> MagicFileUtils.checkFile("text.txt"));
    }

    @Test
    void successCreateFile() {
        File file = MagicFileUtils.createFile("test4.txt", "_test");

        Assertions.assertNotNull(file);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.getAbsolutePath().endsWith("_test.txt"));

        file.delete();
    }

    @Test
    void failCreateFile() {
        File file = MagicFileUtils.createFile("test4.txt", "_test");

        Assertions.assertThrows(RuntimeException.class, () -> MagicFileUtils.createFile("test4.txt", "_test"));

        file.delete();
    }
}