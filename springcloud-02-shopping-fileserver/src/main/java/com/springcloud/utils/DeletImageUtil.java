package com.springcloud.utils;

import java.io.File;



public class DeletImageUtil {

	
	public Integer deletFileImage(String filePath,String fileName) {
		
		File file =new File(filePath+fileName);
		
		//判断传入的是否是个文件
		
		if (file.exists()) {
			//当删除成功的时候，返回true
			if (file.delete()) {	
				return 0;
				
			}
		}
		
		
		
		//删除失败
		return 1;
	}

}
