package jp.kuskyst.aozorapdf.service.impl;

import java.io.IOException;
import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public PDDocument convert(ConvertParam param) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDType1Font font = PDType1Font.HELVETICA;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(font, 12);

            String text = param.getText();
            float x = 100, y = 700, lineHeight = 14;
            for (int i = text.length() - 1; i >= 0; i--) {
                String character = text.substring(i, i + 1);
                contentStream.beginText();
                contentStream.newLineAtOffset(x, y - (text.length() - 1 - i) * lineHeight);
                contentStream.showText(character);
                contentStream.endText();
            }

            contentStream.close();
            document.save(param.getName()+".pdf");
            document.close();
            return document;
        } catch (IOException e) {
            return null;
        }
    }
}
