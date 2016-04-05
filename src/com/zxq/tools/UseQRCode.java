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
 * ��д��ά�� 
 * @author joker
 *
 */
public class UseQRCode {
	public void MakeQRCode(){
		 //1.  ����QRCode����
        Qrcode qrcodeHand = new Qrcode() ;
        //2.��ά��ľ���ȼ� 
        // L 7%   M 15%  Q 25% H 30%
        qrcodeHand.setQrcodeErrorCorrect('M');
        //3.ģʽ  ������ 
        qrcodeHand.setQrcodeEncodeMode('B');
        //�汾 ��1 21*21  2 25*25 ÿ���汾����4��ģ�� ����ܳ���40
        qrcodeHand.setQrcodeVersion(7);
      
        int width = 140 ;
        int geight = 140 ;
     
        BufferedImage bufImg = new BufferedImage(width, geight, BufferedImage.TYPE_INT_RGB) ;
        
        //��ȡ��ͼ����
        Graphics2D  grap = bufImg.createGraphics() ;
        //׼������ 
        String content = "��ʵ���Ǹ���ά�� �ж����˷����أ� �����İ�����Լ" ;
        //ת��Ϊbyte����
        byte[] contentByte = null ;
        
        try {
			contentByte  =content.getBytes("gbk") ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        //���ñ���
        grap.setBackground(Color.WHITE);
        //��ջ���
        grap.clearRect(0, 0, width, geight);
        //���û���
        grap.setColor(Color.BLACK);
        //λ�Ʊ��� 
        int pos = 2  ;
        //�ж��Ƿ񳬳�����
        boolean [][]  codeOut = qrcodeHand.calQrcode(contentByte) ;
        if(codeOut.length < 0 || codeOut.length >120){
                System.out.println("������Χ") ;
                return ;
        }
        
        for (int i = 0; i <codeOut.length ; i++) {
            for (int j = 0; j < codeOut.length; j++) {
                if(codeOut[i][j]){
                    grap.fillRect(j*3+pos, i*3+pos, 3, 3);
                }
            }
        }
        //�ҵ�ͼƬ 
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
        //����ͼƬ
        grap.drawImage(img, 50, 50, 50 , 50, null) ;
        //�ر���Դ
        grap.dispose();
        bufImg.flush(); 
        String goalName = name + "\\image\\codeTest.png" ;
        File file =new File(goalName) ;
        try {
        	//����ļ�
			ImageIO.write(bufImg, "PNG", file) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}