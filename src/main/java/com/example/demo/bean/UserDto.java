package com.example.demo.bean;

import com.example.demo.aop.annotation.NameAuth;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("name")
    @Size(min = 5,message = "Enter atleast five character")
    @NotEmpty(message = "name is null")
    @NameAuth
    private String name;

    @Past(message = "dob should in past")
    @JsonFormat(pattern = "DD-MM-YYYY")
    @JsonProperty("dob")
    private Date dob;
}
