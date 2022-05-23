import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void parseTest() throws IOException{
        ArrayList<String> expected = new ArrayList();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    
    @Test
    public void imageTest() throws IOException{
        ArrayList<String> expected = new ArrayList();
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    @Test
    public void reportEightOneTest() throws IOException{
        ArrayList<String> expected = new ArrayList();
        expected.add("google.com")
        expected.add("ucsd.edu")
        Path fileName = Path.of("test-file-rep1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    @Test
    public void reportEightTwoTest() throws IOException{
        ArrayList<String> expected = new ArrayList();
        expected.add("a.com(())")
        expected.add("example.com")
        Path fileName = Path.of("test-file-rep2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    @Test
    public void reportEightThreeTest() throws IOException{
        ArrayList<String> expected = new ArrayList();
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule")
        Path fileName = Path.of("test-file-rep3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
}