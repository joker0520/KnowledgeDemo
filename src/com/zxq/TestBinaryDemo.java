package com.zxq;

import java.util.Arrays;

import org.junit.Test;
/**
 *  �����Ʋ��Ե���
 * @author joker
 * &   ������
 * ^   �� ���������,����ԭֵ(ֵ����)
 *     ����������ֵ�Ĳ�����ʽ��ʾ
 *      Դ��--��λȡ��--����--��1--����
 *     C=A A=B B=C 
 *     A=A+B B=A-B A=A-B
 *     A=A^B B=A^B A=A^B
 */
public class TestBinaryDemo {
	@Test
	public void TestBinary(){
		//��λ��     ȫ1Ϊ1 
		System.out.println(6 & 3);  //2
		//��λ��     ��1Ϊ1 
		System.out.println(6 | 3);  //7
		//�������  ��ͬΪ1 
		System.out.println(6 ^ 3);  //5
		//����  �ұ߶���  ������߲�1  ������߲�0
		System.out.println(6 >> 3); //0
		//�޷�������    �ұ߶���  ��߲�0
		System.out.println(6 >>> 3); //0
		//����     ��߶���  �ұ߲�0
		System.out.println(6 << 3);  //48
		/*
		 * 6  00000000 00000000 00000000 00000110
		 * 3  00000000 00000000 00000000 00000011
		 */
	}
	@Test
	public void TestMetod(){
		//�����Ʊ�ʾ
		System.out.println(Integer.toBinaryString(10));
		//�˽��Ʊ�ʾ
		System.out.println(Integer.toOctalString(10)) ;
		//16���Ʊ�ʾ
		System.out.println(Integer.toHexString(10)) ;
		//ʮ���Ʊ�ʾ
		System.out.println(Integer.parseInt("1010", 2));
		System.out.println(Integer.parseInt("012", 8));
		System.out.println(Integer.parseInt("a", 16));
	}
	/**
	 * java�л�����������  ת��Ϊ byte[] 
	 * �ַ��� -> �ֽ�����
	 * Strng s ;
	 * byte[] bs = s.getBytes() ;
	 * �ֽ����� -> �ַ���
	 * byte[]  bs = new byte[int] ;
	 * String s = new Sring(bs,encode) ;
	 * 
	 * byte  8
	 * short 16
	 * int 32
	 * long 64
	 * float 32
	 * double 64 
	 */
	@Test
	public void TestEmcode(){
		byte[] arr = new byte[4] ;
		int id = 10 ;
		arr[0] = (byte)((int)(id >> 0*8)&0xff) ;
		arr[1] = (byte)((int)(id >> 1*8)&0xff) ;
		arr[2] = (byte)((int)(id >> 2*8)&0xff) ;
		arr[3] = (byte)((int)(id >> 3*8)&0xff) ;
		System.out.println(Arrays.toString(arr));
		
		int r0 = ((arr[0] & 0xff) << 0*8) ;
		int r1 = ((arr[1] & 0xff) << 1*8) ;
		int r2 = ((arr[2] & 0xff) << 2*8) ;
		int r3 = ((arr[3] & 0xff) << 3*8) ;
		System.out.println(r0+r1+r2+r3);
	}
}