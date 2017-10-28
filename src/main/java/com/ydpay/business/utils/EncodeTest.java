package com.ydpay.business.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class EncodeTest {
	public static void Encode_QR_CODE() throws IOException, WriterException{
		String contents = "ZXing 二维码内容1234!"; // 二维码内容
		int width = 430; // 二维码图片宽度 300 
		int height = 430; // 二维码图片高度300
		
		String format = "jpg";// 二维码的图片格式 gif
		
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		 // 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用字符集编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	
//		hints.put(EncodeHintType.MAX_SIZE, 350);//设置图片的最大值
//	    hints.put(EncodeHintType.MIN_SIZE, 100);//设置图片的最小值
		hints.put(EncodeHintType.MARGIN, 1);//设置二维码边的空度，非负数
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,//要编码的内容
				//编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,
				//Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,
				//MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION
				BarcodeFormat.QR_CODE,
				width, //条形码的宽度
				height, //条形码的高度
				hints);//生成条形码时的一些配置,此项可选
		
		// 生成二维码
		File outputFile = new File("d:" + File.separator + "new-1.jpg");//指定输出路径
		
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
	
	 private static final String CODE = "utf-8";  
	    private static final int BLACK = 0xff000000;  
	    private static final int WHITE = 0xFFFFFFFF; 
	   /** 
     * 生成一维码（128） 
     *  
     * @author wuhongbo 
     * @param str 
     * @param width 
     * @param height 
     * @return 
     */  
    public static BufferedImage getBarcode(String str, Integer width,  
            Integer height)  
    {  
  
        if (width == null || width < 200)  
        {  
            width = 200;  
        }  
  
        if (height == null || height < 50)  
        {  
            height = 50;  
        }  
  
        try  
        {  
            // 文字编码  
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();  
            hints.put(EncodeHintType.CHARACTER_SET, CODE);  
  
            BitMatrix bitMatrix = new MultiFormatWriter().encode(str,  
                    BarcodeFormat.CODE_128, width, height, hints);  
  
            return toBufferedImage(bitMatrix);  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    /** 
     * 转换成图片 
     *  
     * @author wuhongbo 
     * @param matrix 
     * @return 
     */  
    private static BufferedImage toBufferedImage(BitMatrix matrix)  
    {  
        int width = matrix.getWidth();  
        int height = matrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height,  
                BufferedImage.TYPE_INT_ARGB);  
        for (int x = 0; x < width; x++)  
        {  
            for (int y = 0; y < height; y++)  
            {  
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
            }  
        }  
        return image;  
    } 
    
    /** 
     * 生成一维码，写到文件中 
     *  
     * @author wuhongbo 
     * @param str 
     * @param height 
     * @param file 
     * @throws IOException 
     */  
    public static void getBarcodeWriteFile(String str, Integer width,  
            Integer height, File file) throws IOException  
    {  
        BufferedImage image = getBarcode(str, width, height);  
        ImageIO.write(image, "png", file);  
    } 
	
    
    /**  
     * 编码  
     * @param contents  
     * @param width  
     * @param height  
     * @param imgPath  
     */    
    public static void encode(String contents, int width, int height, String imgPath) {    
        int codeWidth = 3 + // start guard    
                (7 * 6) + // left bars    
                5 + // middle guard    
                (7 * 6) + // right bars    
                3; // end guard    
        codeWidth = Math.max(codeWidth, width);    
        try {    
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,    
                    BarcodeFormat.EAN_13, codeWidth, height, null);    
    
            MatrixToImageWriter    
                    .writeToFile(bitMatrix, "png", new File(imgPath));    
    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    } 
    
	public static void main(String[] args) throws Exception {
		try {
			Encode_QR_CODE();
			
			File file = new File("D://qrcode.png");  
	  
	        // code39 大写字母、数字、-、  
	        // code128   
	        getBarcodeWriteFile("30701124105515086", null,null, file);  
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
