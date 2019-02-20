package Demo;

import com.zs.pms.md5.MD5;

public class Demo {
	
	MD5 md5=new MD5();
	public static void main(String[] args) {

		System.out.println(md5.getMD5ofStr("yang123"));
	}

}
