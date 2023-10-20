package jp.kuskyst.aozorapdf.controller;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConvertController {

    private final ConvertService helloService;

    public ConvertController(ConvertService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String convert(@RequestBody ConvertParam param) {
        return this.helloService.convert(param);
    }

}
