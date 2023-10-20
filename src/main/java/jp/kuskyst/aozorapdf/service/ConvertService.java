package jp.kuskyst.aozorapdf.service;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import org.springframework.stereotype.Service;

@Service
public interface ConvertService {
    public String convert(ConvertParam name);
}
