package emreusta.com.firebaseornek;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Activity activity;
    List<Kullanici> kullaniciList;
    LayoutInflater layoutInflater;

    public ListViewAdapter(Activity activity, List<Kullanici> kullaniciList) {
        this.activity = activity;
        this.kullaniciList = kullaniciList;
    }

    @Override
    public int getCount() {
        return kullaniciList.size();
    }

    @Override
    public Object getItem(int position) {
        return kullaniciList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.listview_item,null);

        TextView txtKullanici = itemView.findViewById(R.id.listName);
        TextView txtEmail = itemView.findViewById(R.id.listEMail);

        txtKullanici.setText(kullaniciList.get(position).getAd());
        txtEmail.setText(kullaniciList.get(position).getEmail());

        return itemView;
    }
}
