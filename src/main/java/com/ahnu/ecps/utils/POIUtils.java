package com.ahnu.ecps.utils;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

/**
 * POI相关操作
 *
 * @Author: mxding
 * @Date: 2019-08-09 12:58
 */
@Slf4j
public class POIUtils {

    /**
     * 将PPT转成图片输出
     *
     * @param inputStream
     * @param outPath     输出路径
     */
    public static void pptToGraphics(InputStream inputStream, String outPath) {
        SlideShow slideShow;
        try {
            slideShow = SlideShowFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("输入流转PPT异常" + e.getMessage());
        }
        Dimension pgSize = slideShow.getPageSize();
        List<Slide> slideList = slideShow.getSlides();
        if (SetUtils.isNullList(slideList)) {
            log.warn("PPT所含页面数为0");
        } else {
            for (int i = 0; i < slideList.size(); i++) {
                Slide slide = slideList.get(i);
                BufferedImage img = new BufferedImage(pgSize.width, pgSize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.fill(new Rectangle2D.Float(0, 0, pgSize.width, pgSize.height));
                slide.draw(graphics);
                try {
                    @Cleanup
                    FileOutputStream out = new FileOutputStream(outPath + File.separator + i + ".png");
                    javax.imageio.ImageIO.write(img, "png", out);
                } catch (IOException e) {
                    log.debug("图片输出异常[{}]", e.getMessage());
                }
            }
        }
    }
}
