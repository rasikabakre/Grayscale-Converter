package grayscale;


import essentials.*;

public class ImageSaver {

	public void doSave(ImageResource inFile) {
		
			String fname = inFile.getFileName();
			String newName = "cpy-" + fname;
			inFile.setFileName(newName);
			inFile.draw();
			inFile.save();
			
	}
	
	public static void main(String srgs[]) {
		GrayscaleConverter  g = new GrayscaleConverter();
		g.testGray();
	}
	
}
