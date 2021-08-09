package com.example.userapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.userapplication.databinding.ActivityFilterBinding

class FilterActivity: AppCompatActivity() {
    lateinit var viewBinding: ActivityFilterBinding
    fun OnCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.filter_title)
        viewBinding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.filterButtonApply.setOnClickListener {
            intent = Intent()
            intent.putExtra("to_one", viewBinding.filterCheckboxToOne.isChecked)
            intent.putExtra("to_two", viewBinding.filterCheckboxToTwo.isChecked)
            intent.putExtra("two", viewBinding.filterCheckboxTwo.isChecked)

            setResult(RESULT_OK, intent)
            finish()
        }

        viewBinding.filterCheckboxToOne.setOnClickListener {
            if(!viewBinding.filterCheckboxToOne.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = false
            if(viewBinding.filterCheckboxToOne.isChecked && viewBinding.filterCheckboxToTwo.isChecked && viewBinding.filterCheckboxTwo.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = true
        }
        viewBinding.filterCheckboxToTwo.setOnClickListener {
            if(!viewBinding.filterCheckboxToTwo.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = false
            if(viewBinding.filterCheckboxToOne.isChecked && viewBinding.filterCheckboxToTwo.isChecked && viewBinding.filterCheckboxTwo.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = true
        }
        viewBinding.filterCheckboxTwo.setOnClickListener {
            if(!viewBinding.filterCheckboxTwo.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = false
            if(viewBinding.filterCheckboxToOne.isChecked && viewBinding.filterCheckboxToTwo.isChecked && viewBinding.filterCheckboxTwo.isChecked)
                viewBinding.filterCheckboxSetAll.isChecked = true
        }
        viewBinding.filterCheckboxSetAll.setOnClickListener {
            if(viewBinding.filterCheckboxSetAll.isChecked)
            {
                viewBinding.filterCheckboxToOne.isChecked = true
                viewBinding.filterCheckboxToTwo.isChecked = true
                viewBinding.filterCheckboxTwo.isChecked = true
            }
            else
            {
                viewBinding.filterCheckboxToOne.isChecked = false
                viewBinding.filterCheckboxToTwo.isChecked = false
                viewBinding.filterCheckboxTwo.isChecked = false
            }
        }
    }
}