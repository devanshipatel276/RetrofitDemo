package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devanshi.taskone.R;
import com.example.devanshi.taskone.databinding.LanguageRowBinding;

import java.util.List;

import model.CountryModel;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyHolder>
{
    List<CountryModel.LanguagesBean> list;
    Context context;

    public LanguageAdapter(FragmentActivity context, List<CountryModel.LanguagesBean> list)
    {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public LanguageAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LanguageRowBinding languageRowBinding= LanguageRowBinding.inflate(layoutInflater,parent,false);
        return new MyHolder(languageRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageAdapter.MyHolder holder, int position)
    {
        CountryModel.LanguagesBean languagesBean=list.get(position);
       holder.bind(languagesBean);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {
        private  LanguageRowBinding languageRowBinding;
        public MyHolder( LanguageRowBinding languageRowBinding) {
            super(languageRowBinding.getRoot());
            this.languageRowBinding=languageRowBinding;

        }
        public void bind(CountryModel.LanguagesBean item) {
            languageRowBinding.setCountrymodel(item);
            languageRowBinding.executePendingBindings();
        }
    }
}
