package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Attachment;

public interface AttachmentRepo extends JpaRepository<Attachment,Integer> {


}
