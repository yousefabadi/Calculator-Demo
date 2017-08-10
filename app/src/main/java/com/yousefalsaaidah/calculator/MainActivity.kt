package com.yousefalsaaidah.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numClicked(view: View){
        //to clean the result
        if(isNewOp) etResult.setText("")

        isNewOp=false
        val buSelected:Button = view as Button
        var dataEntry:String = etResult.text.toString()
        when(buSelected.id){
            bu0.id->{
                dataEntry+="0"
            }
            bu1.id->{
                dataEntry+="1"
            }
            bu2.id->{
                dataEntry+="2"
            }
            bu3.id->{
                dataEntry+="3"
            }
            bu4.id->{
                dataEntry+="4"
            }
            bu5.id->{
                dataEntry+="5"
            }
            bu6.id->{
                dataEntry+="6"
            }
            bu7.id->{
                dataEntry+="7"
            }
            bu8.id->{
                dataEntry+="8"
            }
            bu9.id->{
                dataEntry+="9"
            }
            buDot.id->{
                //TODO to prevent the user to add more than one dot
                dataEntry+="."
            }
            buSumMin.id->{
                //to swap between - and +
                dataEntry="-"+dataEntry
            }
        }
        etResult.setText(dataEntry)
    }
    var op ="*"
    var firstNum =""
    var isNewOp=true
    fun opClicked(view:View){
        val buSelected:Button = view as Button
        when(buSelected.id){
            buSum.id->{
                op = "+"
            }
            buMin.id->{
                op = "-"
            }
            buDiv.id->{
                op = "/"
            }
            buMul.id->{
                op = "*"
            }
        }
        firstNum=etResult.text.toString()
        isNewOp=true

    }

    var result:Double?=null
    fun equalEvent(view:View){
        val newNum = etResult.text.toString()
        when(op){
            "+"->result = firstNum.toDouble()+newNum.toDouble()
            "-"->result = firstNum.toDouble()-newNum.toDouble()
            "*"->result = firstNum.toDouble()*newNum.toDouble()
            "/"->result = firstNum.toDouble()/newNum.toDouble()
        }

        etResult.setText(result.toString())
        isNewOp=true
    }

    fun percentEvent(view:View){
        val numPercent = etResult.text.toString().toDouble()/100
        etResult.setText(numPercent.toString())
        isNewOp=true
    }

    fun cleanEvent(view:View){
        etResult.setText("0")
        isNewOp=true
    }
}
