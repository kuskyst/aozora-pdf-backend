package jp.kuskyst.aozorapdf.service.impl;

import java.io.IOException;
import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public PDDocument convert(ConvertParam param) {
        try {
            PDDocument res = new PDDocument();

            PDPage page = new PDPage();
            res.addPage(page);

            res.save(param.getName() + ".pdf");
            res.close();
            return res;
        } catch (IOException e) {
            return null;
        }
    }
}
