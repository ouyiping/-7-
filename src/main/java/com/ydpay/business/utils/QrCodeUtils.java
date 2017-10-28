package com.ydpay.business.utils;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.UUID;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QrCodeUtils {

	private static String format = "png";// 二维码的图片格式 png

	/**
	 * @description: 创建二维码，同时返回二维码的网络地址, 不包含logo图片 二维码名称:时间戳.png
	 * @param contents
	 *            二维码内容
	 * @param path
	 *            二维码图片绝对路径
	 * @param urlPath
	 *            二维码图片网络路径
	 * @return
	 * @throws IOException
	 * @throws WriterException
	 *             (设定参数)
	 * @return String(返回值说明)
	 * @author Zhanghaifeng 2015年11月24日
	 */
	public static String createQrCode(String contents, String path,
			String urlPath) throws IOException, WriterException {
		return createQrCode(contents, path, urlPath, null);
	}

	public static String createQrCode(String contents, String path,
			String urlPath, String logoFilePath) throws IOException,
			WriterException {
		int width = 250; // 二维码图片宽度 250
		int height = 250; // 二维码图片高度250

		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		String name = UUID.randomUUID().toString().replace("-", "");
		String fileName = name + "." + format;
		String filePath = path + File.separator + fileName;
		BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
				BarcodeFormat.QR_CODE, width, height, hints);
		File outputFile = new File(filePath);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

		return urlPath + File.separator + fileName;
	}

	public static String createBarCode(String contents, String path,
			String urlPath) throws IOException, WriterException {
		int width = 240;
		int height = 60;
		// 文字编码
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 3);

		BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
				BarcodeFormat.CODE_128, width, height, hints);

		String name = UUID.randomUUID().toString().replace("-", "");
		String fileName = name + "." + format;
		File outputFile = new File(path + File.separator + fileName);// 指定输出路径

		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

		return urlPath + File.separator + fileName;
	}
}
