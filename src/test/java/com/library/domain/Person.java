package com.library.domain;

import lombok.*;

import java.util.Set;

/**
 * Sets don't allow duplicate objects
 * @see https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "phoneNumbers")
public class Person {

    private long id;
    private String name;
    private Set<PhoneNumber> phoneNumbers;

}

