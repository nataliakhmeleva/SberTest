import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MagicFileSorterTest {

    private MagicFileSorter magicFileSorter = new MagicFileSorter();

    @Test
    void testSorting1() throws IOException {
        String sourceFileName = "test1.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());
        List<String> sortedLines = FileUtils.readLines(sourceFile, StandardCharsets.UTF_8);
        sortedLines.sort(Comparator.naturalOrder());

        File file = magicFileSorter.sortFileStrings(sourceFileName);

        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Assertions.assertEquals(sortedLines, lines);

        file.deleteOnExit();
    }

    @Test
    void testSorting2() throws IOException {
        String sourceFileName = "test2.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());
        List<String> sortedLines = FileUtils.readLines(sourceFile, StandardCharsets.UTF_8);
        sortedLines.sort(Comparator.naturalOrder());

        File file = magicFileSorter.sortFileStrings(sourceFileName);

        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Assertions.assertEquals(sortedLines, lines);

        file.deleteOnExit();
    }

    @Test
    void testSorting3() throws IOException {
        String sourceFileName = "test3.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());
        List<String> sortedLines = FileUtils.readLines(sourceFile, StandardCharsets.UTF_8);
        sortedLines.sort(Comparator.naturalOrder());

        File file = magicFileSorter.sortFileStrings(sourceFileName);

        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Assertions.assertEquals(sortedLines, lines);

        file.deleteOnExit();
    }

    @Test
    void testSorting4() throws IOException {
        String sourceFileName = "test4.txt";
        File sourceFile = new File(FileUtils.class.getClassLoader().getResource(sourceFileName).getFile());
        List<String> sortedLines = FileUtils.readLines(sourceFile, StandardCharsets.UTF_8);
        sortedLines.sort(Comparator.naturalOrder());

        File file = magicFileSorter.sortFileStrings(sourceFileName);

        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Assertions.assertEquals(sortedLines, lines);

        file.deleteOnExit();
    }
}