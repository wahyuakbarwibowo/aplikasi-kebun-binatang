package com.wahyuakbarwibowo.aplikasikebunbinatang

class Binatang{
    var nama: String? = null
    var deskripsi: String? = null
    var gambar: Int? = null
    var binatangBuas: Boolean? = null
    constructor(nama: String, des: String, gambar: Int, buas: Boolean){
        this.nama = nama
        this.deskripsi = des
        this.gambar = gambar
        this.binatangBuas = buas
    }
}