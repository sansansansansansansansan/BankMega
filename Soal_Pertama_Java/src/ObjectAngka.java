public class ObjectAngka {
    private String[] angka;
    // Membuat konstruktor untuk menampung nilai dari variabel angka
    public ObjectAngka(String... angka) {
        this.angka = angka;
    }
    public String[] getAngka(){
        return angka;
    }
}
