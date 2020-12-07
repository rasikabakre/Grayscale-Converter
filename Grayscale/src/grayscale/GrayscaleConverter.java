package grayscale;
import java.io.File;

import essentials.*;
public class GrayscaleConverter {
	
		public ImageResource makeGray(ImageResource inImage) {
			ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
			
			for(Pixel pixel: outImage.pixels()) {
				Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
				
				int average = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
				
				pixel.setRed(average);
				pixel.setGreen(average);
				pixel.setBlue(average);
				
			}
			return outImage;
		}
		
		public void testGray() {
			ImageSaver s = new ImageSaver();
			ImageResource ir = new ImageResource();
			ImageResource gray = makeGray(ir);
			s.doSave(gray);
			
		}
		
		public void selectAndConvert() {
			
			DirectoryResource dr = new DirectoryResource();
			for(File f: dr.selectedFiles()) {
				ImageResource inFile = new ImageResource(f);
				ImageResource gray = makeGray(inFile);
				gray.draw();
			}
			
		}
		public static void main(String srgs[]) {
			GrayscaleConverter  g = new GrayscaleConverter();
			g.testGray();
		}
		
}
