package jp.kuskyst.aozorapdf.service;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;

@Service
public interface ConvertService {
    public PDDocument convert(ConvertParam name);
}
