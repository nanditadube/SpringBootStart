package com.mygit.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;


@Entity
@Table(name = "SERVERCONFIG")
@NamedNativeQueries({ @NamedNativeQuery(name = "getMaxLoginAttemptsQuery", query = "SELECT * FROM serverconfig sconfig where sconfig.confKey=? and sconfig.configuration=?", resultClass = ServerConfig.class),
                      @NamedNativeQuery(name = "getPwdConfigProperties", query = "SELECT * FROM serverconfig sconfig WHERE sconfig.confKey IN ('"+Constants.NO_OF_UPPERCASES+"','"+Constants.NO_OF_LOWERCASES+"','"+Constants.NO_OF_DIGIT+"','"+Constants.NO_OF_SPECIALCHARS+"','"+Constants.PWD_MIN_LENGTH+"','"+Constants.PWD_MAX_LENGTH+"')", resultClass = ServerConfig.class)})

public class ServerConfig implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CONFIGURATION", length = 45)
    private String configuration;

    @Column(name = "CONFKEY", length = 128)
    private String confKey;

    @Column(name = "CONFVALUE", length = 4000)
    private String confValue;

    public ServerConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getConfKey() {
        return confKey;
    }

    public void setConfKey(String confKey) {
        this.confKey = confKey;
    }

    public String getConfValue() {
        return confValue;
    }

    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }

}

