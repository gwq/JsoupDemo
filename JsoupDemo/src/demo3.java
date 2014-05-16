import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class demo3 {

	public static void main(String[] args) throws IOException {
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		///System.out.println(html.substring(0, html.lastIndexOf("<")));
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		Element link = doc.select("a").first();//查找第一个a元素

		String text = doc.body().text(); // "An example link"//取得字符串中的文本
		String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
		String linkText = link.text(); // "example"//取得链接地址中的文本

		String linkOuterH = link.outerHtml(); 
		    // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容

		System.out.println(text);
		System.out.println(linkHref);
		System.out.println(linkText);
		
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8087));
		//配置连接代理服务器
		for(int p = 1;p<2;p++){
			URL realUrl = new URL("http://67.220.92.8/forum/forum-58-"+String.valueOf(p)+".html");  
	        // 打开和URL之间的连接  
	        URLConnection conn = realUrl.openConnection(proxy); 
			//URLConnection conn = realUrl.openConnection();
	        //通过代理服务器打开
	        conn.connect();
	        BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String line = null;
	        StringBuffer sb = new StringBuffer();
	        while((line = bf.readLine()) != null){
	        	//System.out.println(line);
	        	sb.append(line);
	        }
	        String content = sb.toString();
	        System.out.println("=================Page "+p+"====================");
	        
			Document dc = Jsoup.parse(content);
			Elements links = dc.select("a[href]");
			for(Element e : links){
				if(e.text().contains("")){
					System.out.println(e.text());
					System.out.println(e.absUrl("href"));
				}
			}
		}
	}

}
