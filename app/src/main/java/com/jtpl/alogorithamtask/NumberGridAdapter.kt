package com.jtpl.alogorithamtask

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NumberGridAdapter(private val context: Context,
    private val numbers: List<Int>,
    private val highLightedNumbers: Set<Int>):BaseAdapter() {

    override fun getCount(): Int {
        return  numbers.size
    }

    override fun getItem(position: Int): Any {
        return numbers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,parent,false)
            viewHolder = ViewHolder(view)
            view.tag=viewHolder
        }else{
            view =convertView
            viewHolder =view.tag as ViewHolder
        }

        val number = numbers[position]
        viewHolder.textView.text = number.toString()

        if (highLightedNumbers.contains(number)){
            viewHolder.textView.setBackgroundColor(Color.YELLOW)
        }else{
            viewHolder.textView.setBackgroundColor(Color.TRANSPARENT)
        }
        return view
    }

    private class  ViewHolder(view: View){
        val textView : TextView = view.findViewById(android.R.id.text1)
    }
}