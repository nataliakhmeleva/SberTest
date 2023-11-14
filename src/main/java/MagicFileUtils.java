import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

@Slf4j
public class MagicFileUtils {

    public static File checkFile(String fullFileName) {
        File file;
        try {
            file = new File(MagicFileUtils.class.getClassLoader().getResource(fullFileName).getFile());
            return file;
        } catch (Exception e) {
            String errorMessage = String.format("Файл %s не существует", fullFileName);
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public static File createFile(String fullFileName, String postfix) {
        String resultFileName = FilenameUtils.removeExtension(fullFileName).concat(postfix).concat(".").concat(FilenameUtils.getExtension(fullFileName));
        File resultFile = new File(resultFileName);
        createNewFile(resultFile, resultFileName);
        return resultFile;
    }

    private static void createNewFile(File resultFile, String resultFileName) {
        try {
            if (!resultFile.createNewFile()) {
                String errorMessage = String.format("Не удалось создать файл %s", resultFileName);
                log.error(errorMessage);
                throw new RuntimeException(errorMessage);
            }
        } catch (IOException e) {
            String errorMessage = String.format("Не удалось создать файл %s", resultFileName);
            log.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
