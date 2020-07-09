package train.stan;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountLines1Test {

    private CountLines1 countCommentLines = new CountLines1();

    @Test
    public void OpenFileTest() throws Exception{
        assertTrue(countCommentLines.openJavaFile());
    }

    @Test
    public void singleLineCommentTest() {
        String lineWithComment = "// We have a comment";
        String lineWithoutComment = "No comment here";

        assertTrue(countCommentLines.checkForSingleLineComments(lineWithComment));
        assertFalse(countCommentLines.checkForSingleLineComments(lineWithoutComment));
    }

    @Test
    public void multiLineCommentTest() {
        String multiLineComment = "    /**\n" +
                "     * count the number of lines in a file\n" +
                "     */";

        assertTrue(countCommentLines.checkForMultiLineComments(multiLineComment));
    }
}

