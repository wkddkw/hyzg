package com.syc.china.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String username;
    @JsonIgnore
    private String password;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    private Integer id_card;

    private String link_man;

    private String email;

    private String weixin;

    private String qq;

    private String id_image;

    private String ctf_image;

    private Integer role_id;

    private String province;

    private String city;

    private String area;

    private Date create_time;

    private Date last_update_time;

    private Integer is_vip;


}
