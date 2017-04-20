package com.archives;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.model.Proceso;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilderProceso extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		Proceso pro = (Proceso) model.get("listActs");
		Image imagen = Image.getInstance("http://localhost:8080/plantuml/img/9Sj12e0m34JHVKxHSxId6Uq8XTX832uaXrTn-ta_gMNLmHbCEGCUKiDsbAzZOvDKb8kpiviZfJgXu_w1BMxjtUoG1m00");
		
		String[] act = pro.getDescActividades().trim().split(",");
		int i=0;
		
		doc.add(new Paragraph("PROCESO: "+pro.getNombreProceso().toUpperCase()));
		
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.0f, 5.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Item", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Actividad", font));
		table.addCell(cell);
		

		for (String a : act) {
			table.addCell(String.valueOf(++i));
			table.addCell(a);
		
		}
		imagen.setAlignment(Element.ALIGN_CENTER);
		
		doc.add(table);
		doc.add(imagen);
		
	}

}