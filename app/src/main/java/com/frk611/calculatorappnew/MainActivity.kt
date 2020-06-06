package com.frk611.calculatorappnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view:View) {
        if (isNewOp) {
            showResult.setText("")
        }
        isNewOp=false

        val buSelect= view as Button
        var buClickValue:String=showResult.text.toString()
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDot.id->{
                //TODO: prevent adding more than one dot
                buClickValue+="."
            }
            buPlusMinus.id->{
                buClickValue="-" + buClickValue
            }

        }
        showResult.setText(buClickValue)

    }
var op="*"
    var oldNumber=""
    var isNewOp=true
    fun buOperation(view:View){

        val buSelect= view as Button
        when(buSelect.id){
            buMul.id->{
                op="*"
            }
            buDiv.id->{
                op="/"
            }
            buSum.id->{
                op="+"
            }
            buSub.id->{
                op="-"
            }
        }

        oldNumber=showResult.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view:View){

        var newNumber=showResult.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"-> {
                finalNumber= oldNumber.toDouble()*newNumber.toDouble()
            }
            "/"->{
                finalNumber= oldNumber.toDouble()/newNumber.toDouble()
            }
            "+"->{
                finalNumber= oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber= oldNumber.toDouble()-newNumber.toDouble()
            }
        }
        showResult.setText(finalNumber.toString())
        isNewOp=true
    }
    fun Percent(view:View){
        val number:Double=showResult.text.toString().toDouble()/100
        showResult.setText(number.toString())
    }
    fun Clean(view:View){
        showResult.setText("0")
        isNewOp=true
    }
}