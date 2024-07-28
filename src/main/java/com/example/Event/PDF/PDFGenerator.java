package com.example.Event.PDF;

import com.example.Event.modal.Ticket;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.io.ByteArrayOutputStream;
@Component
public class PDFGenerator {

    public byte[] generateTicketPDF(Ticket ticket) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Chunk title = new Chunk("Event Ticket", titleFont);
        Paragraph titlePara = new Paragraph(title);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        document.add(new Paragraph("Ticket Code: " + ticket.getTicketCode()));
        document.add(new Paragraph("Ticket Date: " + ticket.getTicketDate()));
        document.add(new Paragraph("Event: " + ticket.getEvent().getEventName()));
        document.add(new Paragraph("Location: " + ticket.getEvent().getLocation()));
        document.add(new Paragraph("Event Date: " + ticket.getEvent().getEventDate()));
        document.add(new Paragraph("Ticket For : " + ticket.getUser().getUsername()));
        document.add(new Paragraph("Nb : Ce document est télechargeable une seule fois ") );


        document.close();
        return out.toByteArray();
    }
}
