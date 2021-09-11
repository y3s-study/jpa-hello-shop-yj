package org.y3s.jpashop.domain.member;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "from")
@ToString
@EqualsAndHashCode
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
