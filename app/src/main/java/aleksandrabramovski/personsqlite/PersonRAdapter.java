package aleksandrabramovski.personsqlite;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;

public class PersonRAdapter extends RecyclerView.Adapter<PersonRViewHolder>{
    Context context;
    ArrayList<PersonDetails> person;

    public PersonRAdapter(Context context, ArrayList<PersonDetails> person){
        this.context = context;
        this.person = person;
    }

    @Override
    public PersonRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);
        PersonRViewHolder pHolder = new PersonRViewHolder(view);
        return pHolder;
    }

    @Override
    public void onBindViewHolder(PersonRViewHolder holder, int position) {
        holder.pYear.setText(person.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return person.size();
    }
}
