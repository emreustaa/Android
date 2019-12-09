package emreusta.com.recyclerviewcardview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List<String> ulkelerListe;

    public MyAdapter(Context mContext, List<String> ulkelerListe) {
        this.mContext = mContext;
        this.ulkelerListe = ulkelerListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView satirCard;
        private TextView satirYazi;
        private ImageView satirResim;

        public CardTasarimTutucu(View view){
            super(view);
            satirCard = view.findViewById(R.id.satir_card);
            satirYazi = view.findViewById(R.id.satir_yazi);
            satirResim = view .findViewById(R.id.satirResim);


        }

    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(v);

    }

    //TIKLANILMA ÖZELLİKLERİNİ AKTİF HALE GETİRMEK İÇİN GEREKLİ İŞLEMLER HOLDER ALTINDA YAPILMAKTADIR.

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu holder, int position) {

         final String ulke = ulkelerListe.get(position);
        holder.satirYazi.setText(ulke);

        holder.satirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( mContext,"Tıklanan Ülke  : " +ulke,Toast.LENGTH_SHORT).show();
            }
        });

        holder.satirResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText( mContext,"PopUp Tıklandı.",Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu = new PopupMenu(mContext,holder.satirResim);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu,popupMenu.getMenu());

                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText( mContext,ulke + " Sil Butonuna tıklandı.",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenle:
                                Toast.makeText( mContext,ulke +" Düzenle Butonuna tıklandı.",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;

                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ulkelerListe.size();
    }



}
