package com.company.baidu.questions;

import java.util.Scanner;

/*
	 							 十字架（百度2017秋招真题）
	
										题目描述
										
	小A很喜欢十字架，并喜欢用各种方式产生十字架的样子。小A不满足简单的十字架输出效果，所以重新定义了一种高大上的十字架输出方式。
	给一个n(1≤n≤10) , 输出对应的图形，具体形式如下：
	1.当n=1的时候，输出一个小写字母"o" :
	o
	2.当n≥2的时候，复制n=n-1时候的图像，并且在n-1图像的上、下、左、右都粘贴一个一模一样的图形。
	如n=2时，在原图"o"的上下左右都粘贴一个"o",所以最后输出的是这样一个图形：
	  o
	 ooo
	  o
  
	输入
	包含多组数据，第一行是数据组数T(T≤10)，随后有T行，每组数据占一行，其中包含一个数字n(1 ≤ n ≤ 10) 。 

	输出
	首先每行输出：“Case #x:”，x表示这是第几组数据，在随后的行中输出对应图形。
	注意每行输出字符数应该与o处于最右的那一行的字符数相同；如果对应位置没有字母o，就在那一个位置输出一个空格。

 */
public class Question_004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer t = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(scanner.nextLine());
			System.out.println("Case #" + (i + 1) + ":");
			String[] arr = new String[(int) Math.pow(3, n - 1)];
			arr[0] = "o";
			for (int j = 2; j <= n; j++) {
				int temp = (int) Math.pow(3, j - 2);
				String blank = "";
				for (int k = 0; k < temp; k++) {
					blank += " ";
				}
				for (int k = temp; k < 2 * temp; k++) {
					arr[k] = arr[k - temp] + arr[k - temp] + arr[k - temp];
				}
				for (int k = temp * 2; k < (int) Math.pow(3, j - 1); k++) {
					arr[k] = blank + arr[k - 2 * temp] + blank;
				}
				for (int k = 0; k < temp; k++) {
					arr[k] = blank + arr[k] + blank;
				}
			}
			for (int j = 0;j<arr.length;j++) {
				System.out.println(arr[j]);
			}
		}
		scanner.close();
	}
}
