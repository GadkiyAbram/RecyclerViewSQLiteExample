package aleksandrabramovski.personsqlite;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PersonRViewHolder extends RecyclerView.ViewHolder{
    TextView pName;
    TextView pYear;

    public PersonRViewHolder(View itemView) {
        super(itemView);
        pYear = (TextView)itemView.findViewById(R.id.pYear);
    }
}