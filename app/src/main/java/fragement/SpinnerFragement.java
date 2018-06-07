package fragement;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devanshi.taskone.LanguageActivity;
import com.example.devanshi.taskone.R;
import com.example.devanshi.taskone.databinding.FragmentSpinnerFragementBinding;

import java.io.Serializable;
import java.util.List;

import model.CountryModel;
import retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpinnerFragement extends Fragment implements AdapterView.OnItemSelectedListener
{
    private FragmentSpinnerFragementBinding binding;
    ApiInterface apiInterface;
    private List<CountryModel> list;
    CountryModel model;
    List<CountryModel.LanguagesBean> languagelist;
    private static final String TAG = "SpinnerFragement";

    public SpinnerFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_spinner_fragement, container, false);
        View view =binding.getRoot();
        binding.setCountrymodel(model);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.spinner.setOnItemSelectedListener(this);

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://restcountries.eu").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        apiInterface = retrofit.create(ApiInterface.class);
        fetchnews();

        final Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
        binding.btnLanguage.startAnimation(myAnim);
        binding.btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(),LanguageActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable) languagelist);
                i.putExtras(args);
                startActivity(i);

            }
        });







    }

    private void fetchnews() {
        Call<List<CountryModel>> call = apiInterface.getpost();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                List<CountryModel> body = response.body();
                list = body;
                String[] countryName = new String[list.size()];
                Log.d(TAG, "onResponse: " + list);
                for (int i = 0; i < body.size(); i++) {
                    countryName[i] = body.get(i).getName();
                }
                Log.d(TAG, "onResponse: " + countryName);
                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, countryName);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        CountryModel value = list.get(position);
        languagelist=value.getLanguages();
        binding.setCountrymodel(value);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();

    }

}
