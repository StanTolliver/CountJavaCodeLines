package train.stan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountLines1 {
    File javaFile = null;
    Scanner readFile = null;
    long lineCount = 0;

    public static void main(String[] args) {
        CountLines1 countLines = new CountLines1();

        countLines.openJavaFile();
        countLines.printCodeLine();

//        if (!countLines.checkForSingleLineComments())

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
        String pattern = "(^//)";
        Pattern compPattern = Pattern.compile(pattern);
        Matcher m = compPattern.matcher(lineOfCode);

        if (m.find()) {
            isComment = true;
        }

        return isComment;
    }

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
}
