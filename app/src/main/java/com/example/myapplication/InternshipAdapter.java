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
    internshipModelList.add(new InternshipModel("C1","A1","F1","100$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C2","A2","F2","200$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C3","A3","F3","300$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C4","A4","F4","400$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C5","A5","F5","500$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C6","A6","F6","600$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C7","A7","F7","700$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C8","A8","F8","800$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C9","A9","F9","900$",R.drawable.ic_launcher_foreground));
    internshipModelList.add(new InternshipModel("C10","A10","F10","1000$",R.drawable.ic_launcher_foreground));


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
