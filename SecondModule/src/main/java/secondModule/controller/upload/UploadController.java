package secondModule.controller.upload;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import secondModule.service.upload.UploadService;

/**
 * For test apache poi
 */
@RestController
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public List<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return uploadService.upload(file);
    }
}