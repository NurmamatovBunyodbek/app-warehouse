package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.AttachmentContent;

public interface AttachmentContentRepo extends JpaRepository<AttachmentContent,Integer> {

      AttachmentContent findAttachmentContentByAttachmentId(Integer attachment_id);

}
