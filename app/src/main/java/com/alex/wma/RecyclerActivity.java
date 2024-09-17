package com.alex.wma;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mahasiswaList = new ArrayList<>();

        mahasiswaList.add(new Mahasiswa("MUHAMMAD NOR KHOLIT", "081234567890", "kholit@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("AKBAR MAULIDI RISKIAWAN", "081234567891", "akbar@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("AHMAD ALFAHREZI", "081234567892", "ahmad@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("BUSTANUL ARIFIN", "081234567893", "bustanul@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("ILLHAM NUR ISNAINI BASKARA JAYA", "081234567894", "illham@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("SEPTIAN GALOH PRASETYO", "081234567895", "septian@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("FEBRI DWI KHOIRINA AZIS", "081234567896", "febri@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("ALEX ROHMATULLAH", "081234567897", "alex@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("REO ARYA YUDHA", "081234567898", "reo@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("MUHAMMAD SONU AFRIZA ZAKARIA", "081234567899", "sonu@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("ALFINO SHOFIYULLOH Z R", "081234567900", "alfino@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("RAIHAN RAIS ARRUM", "081234567901", "raihan@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("DHEDEN SANDIKA", "081234567902", "dheden@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("WAHYU ANANDA", "081234567903", "wahyu@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("RAFFI ARGANTA VIARI", "081234567904", "raffi@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("MOHAMMAD SOLLI", "081234567905", "solli@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("SAGITA PUTRI AGUSTINA", "081234567906", "sagita@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("MAFIRA AURELIA SALSABILA FIRDAUS", "081234567907", "mafira@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("MUHAMMAD HASAN KAMIL", "081234567908", "hasan@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("MUHAMMAD ABDUL WAFI", "081234567909", "wafi@gmail.com", R.drawable.ic_person));
        mahasiswaList.add(new Mahasiswa("DENDI APRILIO SETIAWAN", "081234567910", "dendi@gmail.com", R.drawable.ic_person));

        // Set adapter
        adapter = new MahasiswaAdapter(mahasiswaList);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}