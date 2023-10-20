package jp.kuskyst.aozorapdf.controller;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConvertController {

    private final ConvertService convertService;

    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @PostMapping(value = "/")
    public String convert(@RequestBody ConvertParam param) {

        String result = "failure!!!";

        return result + this.convertService.convert(param);
    }

}
