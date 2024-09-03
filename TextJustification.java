import java.util.ArrayList;
import java.util.List;
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extraSpaces = (maxWidth - totalChars) % gaps;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < extraSpaces ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = tj.fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}
