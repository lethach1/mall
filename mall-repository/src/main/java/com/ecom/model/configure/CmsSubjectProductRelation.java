package com.ecom.model.configure;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cms_subject_product_relation")
public class CmsSubjectProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "product_id")
    private Long productId;

}