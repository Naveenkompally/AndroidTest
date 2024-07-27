package com.jtpl.alogorithamtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Spinner
import com.jtpl.alogorithamtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var gridView: GridView
    private lateinit var ruleSpinner: Spinner
    private lateinit var numberGridAdapter: NumberGridAdapter
    private var highLightedNumbers :Set<Int> = setOf()
    private var numbers : List<Int> = (1..100).toList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView =findViewById(R.id.gridView)
        ruleSpinner =findViewById(R.id.ruleSpinner)

        numberGridAdapter = NumberGridAdapter(this,numbers,highLightedNumbers)
        gridView.adapter =numberGridAdapter

        val rules = arrayOf("Odd Numbers","Even Numbers","Prime Numbers","Fibonacci sequence")
        val spinnerAdapter  = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,rules)
        spinnerAdapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
        ruleSpinner.adapter=spinnerAdapter

        ruleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                updateHighLightedNumbers(position)
                numberGridAdapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }

    private  fun updateHighLightedNumbers(rulePosition : Int){
         val limit = 100
        highLightedNumbers = when (rulePosition){
            0 -> NumberUtils.getOddNumbers(limit)
            1 -> NumberUtils.getEvenNumbers(limit)
            2 -> NumberUtils.getPrimeNumbers(limit)
            3 -> NumberUtils.getFibonacciNumbers(limit)
            else -> setOf()
        }

        numberGridAdapter= NumberGridAdapter(this,numbers, highLightedNumbers)
        gridView.adapter=numberGridAdapter
    }
}