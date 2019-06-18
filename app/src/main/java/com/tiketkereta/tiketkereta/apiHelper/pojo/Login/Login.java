package com.tiketkereta.tiketkereta.apiHelper.pojo.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nisn")
    @Expose
    private String nisn;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("username")
    @Expose
    private String username;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}