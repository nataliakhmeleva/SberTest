import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

@Slf4j
public class MagicFileSorter {

    public File sortFileStrings(String fullFileName) {
        File sourceFile = MagicFileUtils.checkFile(fullFileName);
        File resultFile = MagicFileUtils.createFile(fullFileName, "_result");
        sortAndWriteToResultFile(sourceFile, resultFile);
        return resultFile;
    }

    private void sortAndWriteToResultFile(File sourceFile, File resultFile) {
        int lineNumber = 0;
        String line;
        while (!StringUtils.isEmpty(line = MagicFileReader.readFromSpecificLine(sourceFile, lineNumber))) {
            if (lineNumber == 0) {
                MagicFileWriter.writeToSpecificLine(resultFile, 0, line, lineNumber);
            } else {
                int resultLineNumber = calculateResultLineNumber(resultFile, line, lineNumber);
                MagicFileWriter.writeToSpecificLine(resultFile, resultLineNumber, line, lineNumber);
            }
            lineNumber++;
        }
    }

    private int calculateResultLineNumber(File resultFile, String line, int resultFileSize) {
        String firstLine = MagicFileReader.readFromSpecificLine(resultFile, 0);
        if (line.compareTo(firstLine) <= 0) {
            return 0;
        }
        String lastLine = MagicFileReader.readFromSpecificLine(resultFile, resultFileSize - 1);
        if (lastLine.compareTo(line) <= 0) {
            return resultFileSize;
        }
        return binarySearch(resultFile, line, resultFileSize);
    }

    private int binarySearch(File resultFile, String line, int fileLength) {
        int left = 0, right = fileLength;
        while (right >= left ) {
            int mid = left + (right - left) / 2;
            String midLine = MagicFileReader.readFromSpecificLine(resultFile, mid);
            String rightLine = MagicFileReader.readFromSpecificLine(resultFile, right - 1);
            String rightMinusOneLine = MagicFileReader.readFromSpecificLine(resultFile, right - 2);
            if (line.compareTo(midLine) == 0) {
                return mid;
            }
            if ((right - left == 1) && (rightMinusOneLine.compareTo(line) > 0 && rightLine.compareTo(line) < 0)) {
                return right;
            }
            if (line.compareTo(midLine) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
