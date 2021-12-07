package code;

public class DataMahasiswa {
    private int id;
    private String nim,nama, falkultas, jurusan, alamat, kota, hobby;

    public DataMahasiswa(int id, String nim, String nama, String falkultas, String jurusan, String alamat, String kota, String hobby) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.falkultas = falkultas;
        this.jurusan = jurusan;
        this.alamat = alamat;
        this.kota = kota;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getFalkultas() {
        return falkultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKota() {
        return kota;
    }

    public String getHobby() {
        return hobby;
    }
}
