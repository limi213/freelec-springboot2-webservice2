package com.jojoldu.book.springboot.domain;



import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA entity들이 해당 클래스 상속할 경우 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //auditing 기능 포함시킴
public class BaseTimeEntity {

    @CreatedDate //entity 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 entity 값 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}
