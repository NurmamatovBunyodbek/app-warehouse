package uz.pdp.appwarehouse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {



    @OneToOne
    private Attachment attachment;
    @Column(unique = true,nullable = true)
    private String code;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment photo;
    @ManyToOne
    private Measurement measurement;




}
