package com.archives;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Proceso;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<Proceso> listProcs = (List<Proceso>) model.get("listProcesos");
		
		doc.add(new Paragraph("Lista de Procesos"));
		
		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.0f, 3.0f, 2.0f, 2.0f, 2.0f,2.0f,2.0f});
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
		
		cell.setPhrase(new Phrase("Razon Social", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nombre del Proceso", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Tipo Proceso", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Encargado del Proceso", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Usuario", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Fecha Registro", font));
		table.addCell(cell);
		
		// write table row data
		for (Proceso aProc : listProcs) {
			table.addCell(String.valueOf(aProc.getId()));
			table.addCell(aProc.getNombEmpresa());
			table.addCell(aProc.getNombreProceso());
			table.addCell(aProc.getNombTipoProceso());
			table.addCell(aProc.getNombResponsable());
			table.addCell(aProc.getNombPersonal());
			table.addCell(String.valueOf(aProc.getFechaRegistro()));
		}
		
		doc.add(table);
		
	}

}