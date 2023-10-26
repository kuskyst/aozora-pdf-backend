package jp.kuskyst.aozorapdf.service.impl;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public String convert(ConvertParam param) {
        String result = param.getName()+".pdf";
        try {
            PdfWriter writer = new PdfWriter(new File(result));
            PdfFont font = PdfFontFactory.createFont("c:\\windows\\fonts\\msgothic.ttc,0", "Identity-H");

            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(param.getText()).setFont(font).setFontSize(12));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            PDDocument document = new PDDocument();
//            PDPage page = new PDPage(PDRectangle.A4);
//            document.addPage(page);
//            PDType0Font font = PDType0Font.load(document, new TrueTypeCollection(new File("c:/windows/fonts/MSGothic.ttc")).getFontByName("MS-Gothic"), true);
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//            contentStream.transform(Matrix.getTranslateInstance(0, page.getMediaBox().getHeight()));
//            contentStream.transform(Matrix.getRotateInstance(Math.toRadians(-90), 0, 0));
//            contentStream.setFont(font, 12);
//
//            String[] lines = "縦書きのテキスト\n縦書きのテキスト\n縦書きのテキスト".split("\n");
//            float margin = 50;
//            float xPosition = margin;
//            float yPosition = page.getMediaBox().getWidth() - margin;
//
//            for (String line : lines) {
//                contentStream.beginText();
//                contentStream.newLineAtOffset(xPosition, yPosition);
//                AffineTransform affineTransform = new AffineTransform();
//                affineTransform.rotate(-Math.PI / 2);
//                contentStream.setTextMatrix(affineTransform);
//                contentStream.showText(line);
//                contentStream.endText();
//                yPosition -= 14.4f;
//            }
//
//            contentStream.close();
//            document.save(result);
//            document.close();
            return result;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}
