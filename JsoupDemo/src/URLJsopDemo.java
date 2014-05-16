import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class URLJsopDemo {
	
	public static void main(String args[]) throws IOException{
		Document doc = Jsoup.connect("http://www.baidu.com").get();
		Elements eles = doc.select("a[href]");
		for(Element ele : eles){
			System.out.println(ele.toString()+":"+ele.text()+":"+ele.baseUri()+":"+ele.attr("abs:href"));
			
		}
	}

}
