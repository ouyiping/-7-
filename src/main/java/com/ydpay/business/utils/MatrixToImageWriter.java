package com.ydpay.business.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;

public class MatrixToImageWriter {
	private static final int BLACK = 0xFF000000;//用于设置图案的颜色
	private static final int WHITE = 0xFFFFFFFF; //用于背景色

	private MatrixToImageWriter() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y,  (matrix.get(x, y) ? BLACK : WHITE));
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		writeToFile(matrix, format, file, null);
	}

	public static void writeToFile(BitMatrix matrix, String format, File file, String logoFilePath) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if(logoFilePath != null){
//			设置logo图标
			LogoConfig logoConfig = new LogoConfig();
			image = logoConfig.LogoMatrix(image, logoFilePath);
		}
		
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		writeToStream(matrix, format, stream, null);
	}
	
	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, String logoFilePath) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if(logoFilePath != null){
//			设置logo图标
			LogoConfig logoConfig = new LogoConfig();
			image = logoConfig.LogoMatrix(image, logoFilePath);
		}
		
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}
	 
}
