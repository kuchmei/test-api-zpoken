package com.example.testapizpoken.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date date_create;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date date_update;

}
