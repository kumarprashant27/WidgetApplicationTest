package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class InternshipAdapter extends RecyclerView.Adapter<InternshipHolder> {

    private List<InternshipModel> internshipModelList;
    public InternshipAdapter() {
    internshipModelList =new ArrayList<>();
    internshipModelList.add(new InternshipModel("Mobile App Development","ABC ltd.","Meerut"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Marketing","DEF ltd.","Ghaziabad"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Sales","GHI ltd.","Gurugram"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Mobile App Development","JKL ltd.","Delhi"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Web Development","MNO ltd.","Faridabad"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Volunteer","PQR ltd.","Pune"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Marketing","STU ltd.","Banglore"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Writer","VWX ltd.","Mysore"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Mobile App Development","YZA ltd.","Chennai"," :1000/month",R.drawable.intern));
    internshipModelList.add(new InternshipModel("Sales","AGM ltd.","Sri lanka"," :1000/month",R.drawable.intern));

    }



    @Override
    public InternshipHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        Context context =viewGroup.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.internship_item_layout,viewGroup,false);
        return new InternshipHolder(view);
    }

    @Override
    public void onBindViewHolder( InternshipHolder internshipHolder, int i) {

        InternshipModel internshipModel = internshipModelList.get(i);
        internshipHolder.bindData(internshipModel);
    }

    @Override
    public int getItemCount() {
        return internshipModelList.size();
    }
}
