package org.invenit.hello.entity;

import javax.persistence.*;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@javax.persistence.Entity
@Table(name = "script")
public class Script {

    @Id
    private String code;

    @Lob
    @Column(nullable = false)
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
