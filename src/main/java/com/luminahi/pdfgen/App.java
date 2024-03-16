package com.luminahi.pdfgen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private static void writePDF(PDDocument document, PDPage page) {
        try {
            PDPageContentStream stream =  new PDPageContentStream(document, page);
            PDType1Font font = new PDType1Font(FontName.HELVETICA_BOLD);
            stream.setFont(font, 12);

            stream.beginText();
            stream.newLineAtOffset(100, 700);
            stream.showText("doing some pdf");
            stream.endText();

            log.info("pdf created!");
            stream.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        writePDF(document, page);

        if (Files.exists(Path.of("output.pdf"), LinkOption.NOFOLLOW_LINKS)) {
            log.warn("file already exists, deleting");
            Files.delete(Path.of("output.pdf"));
        }

        document.save("output.pdf");
        log.info("closing document");
        document.close();
    }
}
