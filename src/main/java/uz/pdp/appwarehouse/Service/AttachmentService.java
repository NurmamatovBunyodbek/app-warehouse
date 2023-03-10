package uz.pdp.appwarehouse.Service;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.AttachmentContent;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.AttachmentContentRepo;
import uz.pdp.appwarehouse.repository.AttachmentRepo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepo attachmentRepo;
    @Autowired
    AttachmentContentRepo attachmentContentRepo;

    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attachment save = attachmentRepo.save(new Attachment(null, originalFilename, size, contentType));
            attachmentContentRepo.save(new AttachmentContent(null, file.getBytes(), save));
            return new Result("Attachment qo'shildi", true, save.getId());
        }
        return new Result("File qo'shilmadi", false);
    }

    public void downloadFile(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optional = attachmentRepo.findById(id);
        if (optional.isPresent()) {
            Attachment attachment = optional.get();
            AttachmentContent attachmentContentByAttachmentId = attachmentContentRepo.findAttachmentContentByAttachmentId(id);
            response.setHeader("Content-Disposition", "attachment ; fileName= \"" + attachment.getName() + "\"");
            response.setContentType(attachment.getContentType());
            FileCopyUtils.copy(attachmentContentByAttachmentId.getBytes(), response.getOutputStream());
        }
    }

    public List<Attachment> getInfo(HttpServletResponse response) {
        List<Attachment> all = attachmentRepo.findAll();
        return all;
    }


     public Attachment getFileId(Integer id){
         Optional<Attachment> byId = attachmentRepo.findById(id);
         return byId.get();
     }




}
