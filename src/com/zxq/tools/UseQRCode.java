package com.zxq.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
 

import com.swetake.util.Qrcode;
/**
 * 编写二维码 
 * @author joker
 *
 */
public class UseQRCode {
	public void MakeQRCode(){
		 //1.  创建QRCode对象
        Qrcode qrcodeHand = new Qrcode() ;
        //2.二维码的纠错等级 
        // L 7%   M 15%  Q 25% H 30%
        qrcodeHand.setQrcodeErrorCorrect('M');
        //3.模式  二进制 
        qrcodeHand.setQrcodeEncodeMode('B');
        //版本 从1 21*21  2 25*25 每个版本增加4个模块 最大不能超过40
        qrcodeHand.setQrcodeVersion(7);
      
        int width = 140 ;
        int geight = 140 ;
     
        BufferedImage bufImg = new BufferedImage(width, geight, BufferedImage.TYPE_INT_RGB) ;
        
        //获取画图工具
        Graphics2D  grap = bufImg.createGraphics() ;
        //准备数据 
        String content = "其实我是个二维码 有多少人发现呢？ 好无聊啊。求约" ;
        //转化为byte数组
        byte[] contentByte = null ;
        
        try {
			contentByte  =content.getBytes("gbk") ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        //设置背景
        grap.setBackground(Color.WHITE);
        //清空画板
        grap.clearRect(0, 0, width, geight);
        //设置画笔
        grap.setColor(Color.BLACK);
        //位移变量 
        int pos = 2  ;
        //判断是否超出限制
        boolean [][]  codeOut = qrcodeHand.calQrcode(contentByte) ;
        if(codeOut.length < 0 || codeOut.length >120){
                System.out.println("超出范围") ;
                return ;
        }
        
        for (int i = 0; i <codeOut.length ; i++) {
            for (int j = 0; j < codeOut.length; j++) {
                if(codeOut[i][j]){
                    grap.fillRect(j*3+pos, i*3+pos, 3, 3);
                }
            }
        }
        //找到图片 
        Image img = null ;
        String name = new File("").getAbsolutePath() ;
        try {
        	 String sourceName = name + "\\image\\joker.jpg" ;
        	System.out.println(name) ;
        	File file = new File(sourceName) ;
			img = ImageIO.read(file) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
        //画上图片
        grap.drawImage(img, 50, 50, 50 , 50, null) ;
        //关闭资源
        grap.dispose();
        bufImg.flush(); 
        String goalName = name + "\\image\\codeTest.png" ;
        File file =new File(goalName) ;
        try {
        	//输出文件
			ImageIO.write(bufImg, "PNG", file) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}