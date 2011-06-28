package org.tomale.id.gis.editor.ui.internal;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

public class ImageConverter {

	public static ImageData convertToSWT(final BufferedImage image){
		
		ColorModel colorModel = image.getColorModel();
		if(colorModel instanceof DirectColorModel){
			DirectColorModel cm = (DirectColorModel) colorModel;
			PaletteData pd = new PaletteData(cm.getRedMask(), cm.getGreenMask(), cm.getBlueMask());
			ImageData id = new ImageData(image.getWidth(), image.getHeight(), cm.getPixelSize(), pd);
			for(int y=0;y<id.height;y++){
				for(int x=0;x<id.width;x++){
					int rgb = image.getRGB(x, y);
					int pixel = pd.getPixel(new RGB((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, (rgb & 0xff)));
					id.setPixel(x, y, pixel);
					if(cm.hasAlpha()){
						id.setAlpha(x, y, (rgb >> 24) & 0xff);
					}
				}
			}
			
			return id;
		}
		
		if(colorModel instanceof IndexColorModel){
			IndexColorModel cm = (IndexColorModel) colorModel;
			int size = cm.getMapSize();
			byte[] red = new byte[size];
			byte[] green = new byte[size];
			byte[] blue = new byte[size];
			cm.getReds(red);
			cm.getGreens(green);
			cm.getBlues(blue);
			RGB[] rgb = new RGB[size];
			for(int i=0;i<rgb.length;i++){
				rgb[i] = new RGB(red[i] & 0xff, green[i] & 0xff, blue[i] & 0xff);
			}
			PaletteData pd = new PaletteData(rgb);
			ImageData id = new ImageData(image.getWidth(), image.getHeight(), cm.getPixelSize(), pd);
			id.transparentPixel = cm.getTransparentPixel();
			WritableRaster raster = image.getRaster();
			int[] pixel = new int[1];
			for(int y=0;y<id.height;y++){
				for(int x=0;x<id.width;x++){
					raster.getPixel(x, y, pixel);
					id.setPixel(x, y, pixel[0]);
				}
			}
			
			return id;
		}
		
		return null;
		
	}
	
}
