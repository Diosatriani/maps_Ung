package dio.satriani.maps_ung;

/**
 * Created by user on 12/15/2017.
 */

public class Product {


    private int id;
    private String nama;
    private double lat;
    private double lng;
    private String alamat;
    private String image;



    public Product(int id, String nama,  String alamat, String image) {
        this.id = id;
        this.nama = nama;
//        this.lat = lat;
//        this.lng = lng;
        this.alamat = alamat;
        this.image = image;
    }

//    public double getLat() {
//        return lat;
//    }
//
//    public double getLng() {
//        return lng;
//    }

    public String getImage() { return image; }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
