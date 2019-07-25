package qualhato.dev.exemploadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewNomes.ItemClickListener {

    RecyclerViewNomes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dados para preencher o RecyclerView com
        ArrayList<String> arrayDeNomes = new ArrayList<>();
        arrayDeNomes.add("Bruno");
        arrayDeNomes.add("Calos");
        arrayDeNomes.add("Pedro");
        arrayDeNomes.add("João");
        arrayDeNomes.add("Zé");

        // configura o RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_nomes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Visualização em lista
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2)); // Visualização em grid com 2 colunas
        adapter = new RecyclerViewNomes(this, arrayDeNomes);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Clique no nome: " + adapter.getItem(position) + " linha numero: " + position, Toast.LENGTH_SHORT).show();
    }
}
