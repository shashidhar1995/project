package com.PdfView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class view {
	  public static void main(String[] args)
	    {
		  public static void main(String[] args) {
				try {
					File file = new File("itext-test.pdf");
					FileOutputStream fileout = new FileOutputStream(file);
					Document document = new Document();
					PdfWriter.getInstance(document, fileout);
					document.addAuthor("Me");
					document.addTitle("My iText Test");

					document.open();

					Chunk chunk = new Chunk("iText Test");
					Font font = new Font(Font.COURIER);
					font.setStyle(Font.UNDERLINE);
					font.setStyle(Font.ITALIC);
					chunk.setFont(font);
					chunk.setBackground(Color.CYAN);
					document.add(chunk);

					Paragraph paragraph = new Paragraph();
					paragraph.add("Hello World");
					paragraph.setAlignment(Element.ALIGN_CENTER);
					document.add(paragraph);
                     
				/*	Image image;
					try {
						image = Image.getInstance("world.gif");
						image.setAlignment(Image.MIDDLE);
						document.add(image);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
*/
					List list = new ArrayList();
					list.add("ABC");
					list.add("DEF");
					document.add(list);

					document.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
}
