package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoomList {

    public int page_count;
    public int page_number;
    public int page_size;
    public int total_records;
    public String next_page_token;
    public ArrayList<User1> users;
}
