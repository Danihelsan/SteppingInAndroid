package pe.belatrix.steppingandroid.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.belatrix.steppingandroid.R;

/**
 * @author Danihelsan
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.TextImageHolder> {
    private Random random = new Random();

    private List values;
    private OnClickListener onClickListener;

    public DemoAdapter(Context context, OnClickListener onClickListener){
        this.onClickListener = onClickListener;

        values = new ArrayList();
        int max = random.nextInt(20);
        for (int i = 0;i<max;i++){
            values.add(String.valueOf(random.nextInt(1000)));
        }
    }

    @Override
    public TextImageHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null){
                    int position = ((RecyclerView)parent).getChildAdapterPosition(v);
                    onClickListener.onClick(position);
                }
            }
        });
        TextImageHolder holder = new TextImageHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TextImageHolder holder, int position) {
        holder.text.setText(holder.rootView.getContext().getResources().getString(R.string.item_position, values.get(position)));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void removeItem(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    static class TextImageHolder extends RecyclerView.ViewHolder {
        @Nullable  @Bind(R.id.rootView) View rootView;
        @Nullable @Bind(R.id.image) ImageView image;
        @Nullable @Bind(R.id.text) TextView text;

        public TextImageHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
