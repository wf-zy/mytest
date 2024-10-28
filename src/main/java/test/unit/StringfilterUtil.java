package test.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringfilterUtil {

	public static void main(String[] args) {
		String str = "\\“·”》☆斩断★ *adCVs*34_a _09_b5*[/435^*&城池()^$$&*).{}+.|.)%%*(*.中国}34{45[]12.fd'*&999下面是中文的字符￥……{}【】。，；’“‘”？";
		System.out.println(str);
		System.out.println(stringFilter(str));

	}// 过滤特殊字符
 
	public static String stringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字、中文
		// String regEx="[^a-zA-Z0-9]";
		// 清除掉[]中所有特殊字符
		String regEx = "[`~☆★!@#$%^&*()+=|{}':;,\\[\\]》·.<>/?~！@#￥%……（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim().replace(" ", "").replace("\\", "");
	}


}
