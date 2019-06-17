package com.springcloud.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.io.IOContext;

/**
 * 用于实现对上传图片的像素的调整
* 项目名称：springcloud-02-shopping-fileserver   
* 类名称：ImageUtil   
* 类描述：   
* 创建人：admin   
* 创建时间：2019年5月29日 下午8:57:26     
* @version    
*
 */
public class ImageUtil {

	/**
	 * 图片剪切的工具
	 * @param fromFile		输入文件（源文件）
	 * @param toFile		输出文件（剪切的文件）
	 * @param outFileWidth	剪切的宽度
	 * @param outFileHight	剪切的高度
	 * @param proportion    是否等比剪切
	 * @return 				成功返回0，失败返回1
	 * @throws IOException 
	 */
    @SuppressWarnings("static-access")
	public Integer shareImage(File fromFile,File toFile,int outFileWidth,int outFileHeight,boolean proportion) throws IOException {
    	//读取源文件
    	BufferedImage read = ImageIO.read(fromFile);
    	//定义一个新的高度跟宽度来实现原图片的高度跟宽度
    	int newWidth;
    	int newHeight;
    	//设置等比缩放
    	if (proportion) {
			double restWidth=((double)read.getWidth())/(double)outFileWidth+0.1;
			double restHeight=((double)read.getHeight())/(double)outFileHeight+0.1;
			//现在根据比率大的设置等比
			double rest=restWidth<restHeight?restHeight:restWidth;
			newWidth=(int)(read.getWidth()/rest);
			newHeight=(int)(read.getHeight()/rest);
		}else {
			newHeight=outFileHeight;
			newWidth=outFileWidth;
		}
    	//使用一个图片的缓存
    	BufferedImage bImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        //创建一个花布
    	Graphics2D gp2d = bImage.createGraphics();
    	//创建一个透明的背景
    	bImage = gp2d.getDeviceConfiguration().createCompatibleImage(newWidth,newHeight,Transparency.TRANSLUCENT);
    	//释放图片资源，不然会出现程序卡死
    	gp2d.dispose();
    	//现在来在原来透明的背景上画图片
    	gp2d = bImage.createGraphics();
    	Image image = read.getScaledInstance(newWidth, newHeight, read.SCALE_AREA_AVERAGING);
    	//调用画图工具
    	gp2d.drawImage(image,0,0,null);
    	//把画图上的图片输出到剪切完的图片中
    	ImageIO.write(bImage, "png", toFile);
    	//程序失败
    	return 0;
    }
	/*//测试
	 * public static void main(String[] args) { try { new ImageUtil().shareImage(new
	 * File("E:/图片文件/3.jpg"), new File("E:/图片文件/3.jpg"), 350, 350, false);
	 * System.out.println("成功"); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
