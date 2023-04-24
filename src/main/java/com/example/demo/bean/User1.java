package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class User1 {
    public String first_name;
    public String last_name;
    public String display_name;
    public String email;
    public int type;
    public long pmi;
    public String timezone;
    public int verified;
    public Date created_at;
    public Date last_login_time;
    public String pic_url;
    public String language;
    public String phone_number;
    public String status;
    public String role_id;
    public Date user_created_at;
}