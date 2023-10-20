package jp.kuskyst.aozorapdf.controller;

import jp.kuskyst.aozorapdf.entity.ConvertParam;
import jp.kuskyst.aozorapdf.service.ConvertService;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.nio.file.Path;

@RestController
public class ConvertController {

    private final ConvertService convertService;

    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Resource> convert(@RequestBody ConvertParam param) {

        this.convertService.convert(param);
        Path path = Path.of(param.getName() + ".pdf");
        Resource resource = new PathResource(path);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + param.getName() + ".pdf" + "\"")
                .body(resource);
    }

}
