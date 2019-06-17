package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.utils.DeletImageUtil;
import com.springcloud.utils.ImageUtil;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	@Value("${web.user-path}")
	private String userPath;
	
	
	@Value("${web.goods-path}")
	private String goodsPath;
	
	ResultValue rv=new ResultValue();
	//实现上传图片的剪切
	ImageUtil imageUtil=new ImageUtil();
	
	@RequestMapping("/userUpload")
	public ResultValue userUpload(@RequestParam("userImage") MultipartFile file) {
		
		//用来返回是否成功
		
		try {
			//this可以调用当前类中的方法
			Map<String, Object> files = this.uploadFile(userPath, file);
			if (files!=null&&files.size()>0) {
				rv.setCode(0);
				rv.setDataMap(files);
				return rv;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户头像上传失败");
		return rv;
	}
	@RequestMapping("/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		
		//用来返回是否成功
		try {
			//this可以调用当前类中的方法
			Map<String, Object> files = this.uploadFile(goodsPath, file);
			if (files!=null&&files.size()>0) {
				
				rv.setCode(0);
				rv.setDataMap(files);
				return rv;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品图片上传失败");
		return rv;
	}
	
	@RequestMapping("/deleteGoodsImage")
	public ResultValue deleteImage(@RequestParam("fileName") String fileName) {
		try {
			DeletImageUtil deletImageUtil = new DeletImageUtil();
			Integer deletFileImage = deletImageUtil.deletFileImage(goodsPath, fileName);
			//删除商品图片成功
			if (deletFileImage==0) {
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//失败时，返回1
		rv.setCode(1);
		rv.setMessage("删除图片失败");
		return rv;
		
	}
	/**
	 *  上传文件的公有类
	 * @param path  要存的位置
	 * @param file 	你需要上传的文件
	 * @return
	 * @throws IOException 
	 */
	private Map<String, Object> uploadFile(String path,MultipartFile file) throws IOException{
				//获取新的文件名
				String fileName=UploadUtils.getFileName();
				
				//根据上传文件的文件扩展名获得其扩展名,getOriginalFilename获得上传的文件名
				String extendName=UploadUtils.getExendName(file.getOriginalFilename());
				
				  //设置上传的文件路径
				   String filePath=path+fileName+extendName;
				   //上传文件
				  
					//将文件转换为字节类型的数组
					byte[] bytes= file.getBytes();
					
					//创建file类的对象，并设置文件名跟上传路径及文件名
					File saveFile=new File(path+fileName+extendName);
					
					//上传文件,把文件字节的值复制到saveFile文件中
					FileCopyUtils.copy(bytes, saveFile);
					Integer shareImage = imageUtil.shareImage(saveFile, saveFile, 350, 350, false);
					//成功的时候把 文件的新的文件名跟扩展名传递回视图层
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("fileName", fileName);
					map.put("extendName", extendName);
					//把这个map返回
					return map;
				
	}
}
