import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class demo2 {
    /**
     * 
     * (pattern):ƥ��pattern����ȡ��һƥ��,����ȡ��ƥ����ԴӲ�����Matches���ϵõ�
     * (?:pattern):ƥ��pattern������ȡƥ������Ҳ����˵����һ���ǻ�ȡƥ�䣬�����д洢���Ժ�ʹ��
     * ?: �����ַ��������κ�һ���������Ʒ���*,+,?��{n}��{n,}��{n,m}������ʱ��
     *    ƥ��ģʽ�Ƿ�̰���ġ���̰��ģʽ�������ٵ�ƥ�����������ַ�����
     *    ��Ĭ�ϵ�̰��ģʽ�򾡿��ܶ��ƥ�����������ַ�������.*?
     * (?=pattern):����϶�Ԥ�飬���κ�ƥ��pattern���ַ�����ʼ��ƥ������ַ�����
     * 				����һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á�
     * 				���磬��Windows(?=95|98|NT|2000)����ƥ�䡰Windows2000���еġ�Windows����
     * 				������ƥ�䡰Windows3.1���еġ�Windows����Ԥ�鲻�����ַ���Ҳ����˵��
     * 				��һ��ƥ�䷢���������һ��ƥ��֮��������ʼ��һ��ƥ���������
     * 				�����ǴӰ���Ԥ����ַ�֮��ʼ��
     * (?!pattern):�����Ԥ�飬���κβ�ƥ��pattern���ַ�����ʼ��ƥ������ַ�����
     * 				����һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á�
     * 				���硰Windows(?!95|98|NT|2000)����ƥ�䡰Windows3.1���еġ�Windows����
     * 				������ƥ�䡰Windows2000���еġ�Windows����
     * (?<=pattern):����϶�Ԥ�飬������϶�Ԥ�����ƣ�ֻ�Ƿ����෴��
     * 				���磬��(?<=95|98|NT|2000)Windows����ƥ�䡰2000Windows���еġ�Windows����
     * 				������ƥ�䡰3.1Windows���еġ�Windows����
     * (?<!pattern):�����Ԥ�飬�������Ԥ�����ƣ�ֻ�Ƿ����෴��
     * 				���硰(?<!95|98|NT|2000)Windows����ƥ�䡰3.1Windows���еġ�Windows����
     * 				������ƥ�䡰2000Windows���еġ�Windows����
     * @param args
     */
	public static void main(String args[]){
		String ur = "fsdg<a href=\"www.baidu.com\">�ٶ�</a>asdg<a href=\"www.google.com.hk\">Google</a>ssgd";
		//Pattern p = Pattern.compile("<a href=\".*?\">(?:.*?)</a>");
		Pattern p = Pattern.compile("<a href=\".*?\">(.*?)</a>");
		//(.*?),����?��ʾ��̰��ƥ��
		//System.out.println(ur.charAt(28));
		Matcher m = p.matcher(ur);
		while (m.find()){
			//System.out.println(m.start(1));//���ַ�����ƥ���λ��
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			//���()�е�ƥ��������matcher�в�����()�Ľ����ʹ��(?:pattern)
		}
		
		
		String ur2 = "sdfvwindows2003asdfwindows2007ahslhdggd";
		Pattern p2 = Pattern.compile("windows(?!2003|ne)");
		Matcher m2 = p2.matcher(ur2);
		while (m2.find()){
			System.out.println(m2.group(0));
		}
		
	}
}
