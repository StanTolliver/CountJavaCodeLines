package train.stan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountLines1 {
    private File javaFile = null;
    private Scanner readFile = null;
    private long lineCount = 0;

    public static void main(String[] args) {
        CountLines1 countLines = new CountLines1();

        countLines.openJavaFile();

        while (countLines.readFile.hasNextLine() ) {

            String code = countLines.readFile.nextLine();

            if (countLines.checkForSingleLineComments(code)) {
                countLines.incrementCounter();
            }
        }

        System.out.println(countLines.getLineCount());
    }

    /**
     *
     * @return
     */
    public boolean openJavaFile() {
        boolean isFileOpen = false;

        javaFile = new File("TestFile1.java");
        try {
            readFile = new Scanner(javaFile);
            isFileOpen = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(javaFile.getName());

        return isFileOpen;
    }

    /**
     *
     * @param lineOfCode
     * @return
     */
    public boolean checkForSingleLineComments(String lineOfCode) {
        boolean isComment = false;
//        String pattern = "(^//)";
        String pattern = "(//)";
        Pattern compPattern = Pattern.compile(pattern);
        Matcher m = compPattern.matcher(lineOfCode);

        if (m.find()) {
            isComment = true;
        }

        return isComment;
    }

    /**
     *
     * @param lineOfCode
     * @return
     */
    public boolean checkForMultiLineComments(String lineOfCode) {
        boolean isComment = false;
        String startPattern = "(^/*)";
        String endPattern = "(^*/)";

        return isComment;

    }

    /**
     *
     */
    public void printCodeLine() {
        while (readFile.hasNext()) {
            String data = readFile.nextLine();
            System.out.println(data);
        }
    }

    /**
     *
     */
    public void incrementCounter() {
        lineCount++;
    }

    /**
     *
     * @return
     */
    public long getLineCount() {
        return lineCount;
    }
}
