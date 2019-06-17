package com.springcloud.common;

import java.util.Date;

/**
 * 文件上传的工具类
 * @author hhhjj
 *
 */
public class UploadUtils {

	/**
	 * 这里怕两个用户上传的文件名称相同
	 * 
	 * 获取新文件的名称（毫秒数+4位随机数）
	 * @return返回新的文件名称
	 */
	public static String getFileName() {
		
		String fileName=null;
		//获取1-1000之间的随机数
		int num=(int)(Math.random()*1000+1);
		
		//将随机数设置为4位
		String temp="000" + num;
		String reuslt = temp.substring(temp.length()-4);
	    Date date=new Date();
	    fileName=date.getTime()+reuslt;//获取到1970、1月到今天的毫秒数
		return fileName;
	}
	
	public static String getExendName(String fileName) {
		if (fileName==null || fileName.length()==0) {
			return null;
		}
		int index=fileName.lastIndexOf(".");
		if(index==-1){
			return null;
		}
		return fileName.substring(index);
	}
	
}
