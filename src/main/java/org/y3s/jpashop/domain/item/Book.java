package org.y3s.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "B")
@Getter
@Setter
@ToString(callSuper = true)
public class Book extends Item {
    private String author;
    private String isbn;
}
