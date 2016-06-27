/**
 * Created by Rita Liang on 2016/6/24.
 */
package tools;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class Barcode{

    public String codeStr;

    public Barcode(){};

    public Barcode(String codeStr){
        this.codeStr = codeStr;
    }

    public void getBarCode(){
        try {
            JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());

            localJBarcode.setEncoder(Code39Encoder.getInstance());
            localJBarcode.setPainter(WideRatioCodedPainter.getInstance());
            localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
            localJBarcode.setShowCheckDigit(false);

            BufferedImage localBufferedImage = localJBarcode.createBarcode(this.codeStr);
            saveToJPEG(localBufferedImage, "barcode.jpg");
        }catch (Exception localException){
            localException.printStackTrace();
        }
    }

    static void saveToJPEG(BufferedImage paramBufferedImage, String paramString)
    {
        saveToFile(paramBufferedImage, paramString, "jpeg");
    }

    static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2)
    {
        try
        {
            FileOutputStream localFileOutputStream = new FileOutputStream("E:\\projects\\hospital\\public\\images\\photo\\" + paramString1);
            ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 50, 50);
            localFileOutputStream.close();
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

}