package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //모든 필드의 getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자 생성
@Entity //해당 클래스가 엔티티 클래스임을 나타냄, DB와 링크되는 클래스
public class Posts {
    @Id //해당 필드가 PK필드임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false) //해당 필드를 컬럼으로 명시, 필요 없으나 수정할 땐 필요, 문자열 길이 늘임
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
