package com.kechun.conf.kaptcha;

import com.google.code.kaptcha.text.WordRenderer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The default implementation of {@link WordRenderer}, creates an image with a
 * word rendered on it.
 */
public class KaptchaWordRender extends Configurable implements WordRenderer
{
    /**
     * Renders a word to an image.
     *
     * @param word
     *            The word to be rendered.
     * @param width
     *            The width of the image to be created.
     * @param height
     *            The height of the image to be created.
     * @return The BufferedImage created from the word.
     */
    public BufferedImage renderWord(String word, int width, int height)
    {
        int fontSize = getConfig().getTextProducerFontSize();
        Font[] fonts = getConfig().getTextProducerFonts(fontSize);
        //Font[] fonts = new Font[2];
        //fonts[0] = new Font("Courier",Font.PLAIN,32);
        //fonts[1] = new Font("Arial",Font.PLAIN,32);

        int charSpace = getConfig().getTextProducerCharSpace();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2D = image.createGraphics();

        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.add(new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY));
        g2D.setRenderingHints(hints);

        FontRenderContext frc = g2D.getFontRenderContext();
        Random random = new Random();

        int startPosY = (height - fontSize) / 5 + fontSize;

        char[] wordChars = word.toCharArray();
        Font[] chosenFonts = new Font[wordChars.length];
        int [] charWidths = new int[wordChars.length];
        int widthNeeded = 0;
        for (int i = 0; i < wordChars.length; i++)
        {
            chosenFonts[i] = fonts[random.nextInt(fonts.length)];
            char[] charToDraw = new char[]{
                    wordChars[i]
            };
            GlyphVector gv = chosenFonts[i].createGlyphVector(frc, charToDraw);

            charWidths[i] = (int)gv.getVisualBounds().getWidth();
            if (i > 0)
            {
                widthNeeded = widthNeeded + 2;
            }
            widthNeeded = widthNeeded + charWidths[i];
        }

        int startPosX = (width - widthNeeded) / 2;
        for (int i = 0; i < wordChars.length; i++)
        {
            g2D.setColor(getColor());
            g2D.setFont(chosenFonts[i]);
            char[] charToDraw = new char[] {
                    wordChars[i]
            };
            g2D.drawChars(charToDraw, 0, charToDraw.length, startPosX, startPosY);
            startPosX = startPosX + (int) charWidths[i] + charSpace;
        }

        return image;
    }

    private Color getColor() {
        Random random = new Random();
        Color colors[] = {Color.red,Color.blue,Color.green,Color.black,Color.cyan,Color.magenta, Color.pink,Color.orange};
        int index = random.nextInt(colors.length);
        return colors[index];
    }
}
