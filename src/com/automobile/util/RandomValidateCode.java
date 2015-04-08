package com.automobile.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key
	private Random random = new Random();
	private String randString = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private int width = 80;
	private int height = 25;
	private int lineSize = 45;
	private int stringNum = 4;

	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	private Color getRandColor(int fc, int bc) {
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc + 12);
		int g = fc + random.nextInt(bc - fc + 14);
		int b = fc + random.nextInt(bc - fc + 18);
		return new Color(r, g, b);
	}

	public void getRandCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(110, 113));
		for (int i = 0; i < lineSize; i++) {
			drawLine(g);
		}
		String randomStr = " ";
		for (int i = 0; i < stringNum; i++) {
			randomStr = drawString(g, randomStr, i);
		}
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomStr);
		System.out.println("===================" + randomStr);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 绘制随机字符串
	 * 
	 * @param g
	 * @param randString2
	 * @param i
	 * @return
	 */
	private String drawString(Graphics g, String randomStr, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
				.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(randString
				.length())));
		randomStr += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return randomStr;
	}

	/**
	 * 获取随机字符
	 * 
	 * @param num
	 * @return
	 */
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}

	/**
	 * 绘制干扰线
	 * 
	 * @param g
	 */
	private void drawLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(13);
		int y1 = random.nextInt(15);
		g.drawLine(x, y, x + x1, y1 + y);
	}

}
