package utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class CaptchaUtil {
    private static final String RANDOM_STRS = "234568qwertyupasdfkzxcvm";

    private static final String FONT_NAME = "Fixedsys";
    private static final int FONT_SIZE = 30;

    private Random random = new Random();

    private int width = 100;
    private int heigth = 35;
    private int lineNum = 50;
    private int strNum = 4;

    public BufferedImage getRandomCodeImage(StringBuffer randomCode){
        BufferedImage image = new BufferedImage(width,heigth,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setColor(new Color(220,220,220));
        g.fillRect(0,0,width,heigth);
        g.setFont(new Font(FONT_NAME,Font.ROMAN_BASELINE,FONT_SIZE));
        for (int i=0;i<strNum;i++){
            randomCode.append(randString(g,i));
        }
        g.dispose();
        return image;
    }

    private String randString(Graphics g,int i){
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),
                random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(RANDOM_STRS.length())));
        g.translate(random.nextInt(3),random.nextInt(3));
        g.drawString(rand,13*i,16);
        return rand;
    }

    private String getRandomString(int num){
        return String.valueOf(RANDOM_STRS.charAt(num));
    }
}
