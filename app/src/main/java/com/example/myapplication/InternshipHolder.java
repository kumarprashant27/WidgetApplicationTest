package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InternshipHolder extends RecyclerView.ViewHolder {

    private TextView internshipName;
    private TextView internshipCompany;
    private TextView internshipCity;
    private TextView internshipStipend;
    private ImageView internshipCompanyImage;

    Context context;

    public InternshipHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        internshipName=(TextView)itemView.findViewById(R.id.internship_type);
        internshipCompany=(TextView)itemView.findViewById(R.id.internship_company);
        internshipCity=(TextView)itemView.findViewById(R.id.internship_city);
        internshipStipend=(TextView)itemView.findViewById(R.id.internship_stipend);
        internshipCompanyImage=(ImageView) itemView.findViewById(R.id.company_image);
    }

    public void bindData(InternshipModel internshipModel)
    {
        internshipName.setText(internshipModel.internship_name);
        internshipCompany.setText(internshipModel.internship_company_name);
        internshipCity.setText(internshipModel.internship_city);
        internshipStipend.setText(internshipModel.internship_stipend);
        internshipCompanyImage.setImageResource(internshipModel.internship_company_image);
    }

}
