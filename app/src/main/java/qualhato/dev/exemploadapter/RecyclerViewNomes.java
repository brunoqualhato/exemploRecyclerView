package qualhato.dev.exemploadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewNomes extends RecyclerView.Adapter<RecyclerViewNomes.ViewHolder> {

    private List<String> mListaDeNomes;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // construtor para passar os dados
    RecyclerViewNomes(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mListaDeNomes = data;
    }

    // infla o layout da linha de xml quando necessário
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    // liga os dados ao TextView em cada linha
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nome = mListaDeNomes.get(position);
        holder.textViewNome.setText(nome);
    }

    // retorna o total de linhas
    @Override
    public int getItemCount() {
        return mListaDeNomes.size();
    }

    //metodo para adicionar items
    public void adicionarNome(int posicao){
        mListaDeNomes.remove(posicao); //remove o item na posicao desejada
        notifyDataSetChanged();// notifica que meus items foi alterado
    }
    //metodo para remover items
    public void removerNome(String nome){
        mListaDeNomes.add(nome); //adiciona o item na ultima posicao
        notifyDataSetChanged();
    }


    // armazena e recicla as visualizações à medida que elas são deslizadas para fora da tela
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewNome;

        ViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.text_nome);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // método de conveniência para obter dados na posição de clique
    String getItem(int id) {
        return mListaDeNomes.get(id);
    }

    // permite que os eventos de cliques sejam capturados
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // interface método para responder a eventos de cliques
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

