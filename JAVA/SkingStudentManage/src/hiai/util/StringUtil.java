package hiai.util;
/**
 * �����ַ���������
 */
public class StringUtil {
	/**
	 * �ж��Ƿ��ǿ�
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �жϲ���Ϊ��
	 */
	public static boolean isNotEmpty(String str ){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}
