package com.library.domain;

import lombok.*;

import java.util.Set;

/**
 * Sets don't allow duplicate objects
 *
 * @see https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "people")
public class PhoneNumber {

    private long id;
    private String number;
    private Set<Person> people;

}

