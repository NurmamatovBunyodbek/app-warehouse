package uz.pdp.appwarehouse.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.Service.AttachmentService;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.model.Result;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping
    public Result uploadAttachment(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.uploadFile(request);
    }

    @GetMapping("/{id}")

    public void downloadFile(@PathVariable Integer id , MultipartHttpServletRequest request) throws IOException {
                attachmentService.downloadFile(id, (HttpServletResponse) request);

    }
    @GetMapping("/info")
    public List<Attachment> info(HttpServletResponse response )
    {
        List<Attachment> attachmentList = attachmentService.getInfo(response);
        return attachmentList;
    }


}
