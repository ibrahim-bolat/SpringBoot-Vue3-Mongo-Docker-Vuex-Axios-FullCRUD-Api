package com.VueCrudApplication.Model;

import com.VueCrudApplication.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;

    @Field(name = "customerName")
    @Indexed
    private String customerName;

    @Field(name = "customerSurName")
    private String customerSurName;

    @Field(name = "language")
    private String language;

    @Field(name = "gender")
    private Gender gender;

    @Field(name = "phoneNumber")
    private String phoneNumber;

    @Field(name = "email")
    private String email;

    @Field(name = "birthofDate")
    @CreatedDate()
    private LocalDate birthofDate;

    @Field(name = "psw")
    private String password;
}
