package jp.kuskyst.aozorapdf.service.impl;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public String convert(ConvertParam param) {
        return String.format("Hello %s!", param.getText());
    }
}
