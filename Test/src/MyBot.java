import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyBot {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.naver.com").get();
			//System.out.println(doc);
			Elements footer = doc.select("#footer");
			System.out.println(footer.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
