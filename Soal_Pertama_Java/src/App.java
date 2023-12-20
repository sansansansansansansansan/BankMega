import java.util.Arrays;
import java.util.Comparator;

public class App {
    
    public static void main(String[] args) throws Exception {
        // #############Soal Pertama###########

        // ################# A ################

        String[] array1 = {"Satu", "Dua", "Tiga", "Lima"};
        String[] array2 = {"Tiga", "Empat", "Lima", "Enam"};

        int nArray1 = array1.length;
        int nArray2 = array2.length;
        String[] arrayIrisan = new String[0];

        for (int i = 0; i < nArray1; i++) {
            for (int j = 0; j < nArray2; j++) {
                if (array1[i].equals(array2[j])) {
                    arrayIrisan = Arrays.copyOf(arrayIrisan, arrayIrisan.length + 1);
                    arrayIrisan[arrayIrisan.length-1] = array2[j];
                    break;
                }
            }
        }
        // Sorting array irisan
        Arrays.sort(arrayIrisan);
        // Menampilkan Hasil tanpanilai null
        for (String data : arrayIrisan) {
            if(data!=null){
                System.out.println(data);
            }
            
        }

        // ################# B ################
        
        ObjectAngka o1 = new ObjectAngka("Satu", "Dua", "Tiga", "Lima");
        ObjectAngka o2 = new ObjectAngka("Tiga", "Empat", "Lima", "Enam");

        ObjectAngka oIrisan = new ObjectAngka(cariIrisanAngka(o1, o2));
        // Menampilkan Angka yang beririsan dari object
        for (String data : oIrisan.getAngka()) {
            System.out.println(data);
        }
    }
        // Mencari irisan object
        private static String[] cariIrisanAngka(ObjectAngka o1, ObjectAngka o2) {
            String[] Irisan = new String[0];
    
            for (String angka1 : o1.getAngka()) {
                for (String angka2 : o2.getAngka()) {
                    if (angka1.equals(angka2)) {
                        Irisan = Arrays.copyOf(Irisan, Irisan.length + 1);
                        Irisan[Irisan.length - 1] = angka1;
                        break;
                    }
                }
            }
    
            return Irisan;
        }
}
