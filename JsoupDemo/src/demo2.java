import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class demo2 {
    /**
     * 
     * (pattern):匹配pattern并获取这一匹配,所获取的匹配可以从产生的Matches集合得到
     * (?:pattern):匹配pattern但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用
     * ?: 当该字符紧跟在任何一个其他限制符（*,+,?，{n}，{n,}，{n,m}）后面时，
     *    匹配模式是非贪婪的。非贪婪模式尽可能少的匹配所搜索的字符串，
     *    而默认的贪婪模式则尽可能多的匹配所搜索的字符串。如.*?
     * (?=pattern):正向肯定预查，在任何匹配pattern的字符串开始处匹配查找字符串。
     * 				这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。
     * 				例如，“Windows(?=95|98|NT|2000)”能匹配“Windows2000”中的“Windows”，
     * 				但不能匹配“Windows3.1”中的“Windows”。预查不消耗字符，也就是说，
     * 				在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，
     * 				而不是从包含预查的字符之后开始。
     * (?!pattern):正向否定预查，在任何不匹配pattern的字符串开始处匹配查找字符串。
     * 				这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。
     * 				例如“Windows(?!95|98|NT|2000)”能匹配“Windows3.1”中的“Windows”，
     * 				但不能匹配“Windows2000”中的“Windows”。
     * (?<=pattern):反向肯定预查，与正向肯定预查类似，只是方向相反。
     * 				例如，“(?<=95|98|NT|2000)Windows”能匹配“2000Windows”中的“Windows”，
     * 				但不能匹配“3.1Windows”中的“Windows”。
     * (?<!pattern):反向否定预查，与正向否定预查类似，只是方向相反。
     * 				例如“(?<!95|98|NT|2000)Windows”能匹配“3.1Windows”中的“Windows”，
     * 				但不能匹配“2000Windows”中的“Windows”。
     * @param args
     */
	public static void main(String args[]){
		String ur = "fsdg<a href=\"www.baidu.com\">百度</a>asdg<a href=\"www.google.com.hk\">Google</a>ssgd";
		//Pattern p = Pattern.compile("<a href=\".*?\">(?:.*?)</a>");
		Pattern p = Pattern.compile("<a href=\".*?\">(.*?)</a>");
		//(.*?),其中?表示非贪婪匹配
		//System.out.println(ur.charAt(28));
		Matcher m = p.matcher(ur);
		while (m.find()){
			//System.out.println(m.start(1));//在字符串中匹配的位置
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			//输出()中的匹配项，如果在matcher中不保存()的结果则使用(?:pattern)
		}
		
		
		String ur2 = "sdfvwindows2003asdfwindows2007ahslhdggd";
		Pattern p2 = Pattern.compile("windows(?!2003|ne)");
		Matcher m2 = p2.matcher(ur2);
		while (m2.find()){
			System.out.println(m2.group(0));
		}
		
	}
}
