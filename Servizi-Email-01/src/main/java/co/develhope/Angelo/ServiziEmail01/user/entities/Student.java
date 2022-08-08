package co.develhope.Angelo.ServiziEmail01.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//defines an entity Student
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String id;
    private String name;
    private String surname;
    private String email;
}
