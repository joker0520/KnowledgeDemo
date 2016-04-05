package com.zxq;

import java.util.Arrays;

import org.junit.Test;
/**
 *  二进制测试的类
 * @author joker
 * &   ①清零
 * ^   ① 与零相异或,保留原值(值交换)
 *     负数以其正值的补码形式表示
 *      源码--按位取反--反码--加1--补码
 *     C=A A=B B=C 
 *     A=A+B B=A-B A=A-B
 *     A=A^B B=A^B A=A^B
 */
public class TestBinaryDemo {
	@Test
	public void TestBinary(){
		//按位与     全1为1 
		System.out.println(6 & 3);  //2
		//按位或     有1为1 
		System.out.println(6 | 3);  //7
		//异或运算  不同为1 
		System.out.println(6 ^ 3);  //5
		//右移  右边丢弃  负数左边补1  正数左边补0
		System.out.println(6 >> 3); //0
		//无符号右移    右边丢弃  左边补0
		System.out.println(6 >>> 3); //0
		//左移     左边丢弃  右边补0
		System.out.println(6 << 3);  //48
		/*
		 * 6  00000000 00000000 00000000 00000110
		 * 3  00000000 00000000 00000000 00000011
		 */
	}
	@Test
	public void TestMetod(){
		//二进制表示
		System.out.println(Integer.toBinaryString(10));
		//八进制表示
		System.out.println(Integer.toOctalString(10)) ;
		//16进制表示
		System.out.println(Integer.toHexString(10)) ;
		//十进制表示
		System.out.println(Integer.parseInt("1010", 2));
		System.out.println(Integer.parseInt("012", 8));
		System.out.println(Integer.parseInt("a", 16));
	}
	/**
	 * java中基本数据类型  转换为 byte[] 
	 * 字符串 -> 字节数组
	 * Strng s ;
	 * byte[] bs = s.getBytes() ;
	 * 字节数组 -> 字符串
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