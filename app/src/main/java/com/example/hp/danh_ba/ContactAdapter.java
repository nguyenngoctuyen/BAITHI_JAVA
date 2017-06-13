package com.example.hp.danh_ba;

/**
 * Created by HP on 6/13/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by chien on 10/25/16.
 */

public class ContactAdapter extends ArrayAdapter<Contact>{

    private Context context;
    private int resource;
    private List<Contact> arrayContact;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource=resource;
        this.arrayContact=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview,parent,false);
            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrayContact.get(position);

        viewHolder.tvName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());

        if(contact.isMale()){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_male);
        }else {
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_female);
        }

        return convertView;
    }
    public class ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;
    }
}

