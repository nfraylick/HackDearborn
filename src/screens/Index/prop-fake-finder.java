import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.apache.commons.text.similarity.CosineDistance;

public class FakeNewsDetector {

    public static void main(String[] args) {
        String targetLink = "Insert target article link here"; // Replace this with the link you want to analyze
        String[] sourceLinks = {"Insert source article links here"}; // Add links to other sources for comparison

        try {
            String targetContent = fetchArticleContent(targetLink);
            double maxSimilarity = 0.0;

            for (String sourceLink : sourceLinks) {
                String sourceContent = fetchArticleContent(sourceLink);
                double similarity = calculateSimilarity(targetContent, sourceContent);

                if (similarity > maxSimilarity) {
                    maxSimilarity = similarity;
                }
            }

            double threshold = 0.8; // Set a similarity threshold (adjust as needed)
            if (maxSimilarity >= threshold) {
                System.out.println("The article appears to be credible.");
            } else {
                System.out.println("Warning: The article may contain misleading information.");
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to fetch article content.");
        }
    }

    private static String fetchArticleContent(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        return doc.text();
    }

    private static double calculateSimilarity(String text1, String text2) {
        CosineDistance cosine = new CosineDistance();
        return 1 - cosine.apply(text1, text2);
    }
}

