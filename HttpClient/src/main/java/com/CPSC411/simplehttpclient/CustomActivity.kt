package com.CPSC411.simplehttpclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class CustomActivity : AppCompatActivity()
{
    lateinit var  cList : MutableList<Claim>
    lateinit var  cService : ClaimService
    lateinit var temp : String
    /////////////////////////////////////////////////////////////////////////////////
    private fun refreshScreen() {
        //
        Log.d("Claim Service", "Refreshing... ")
        val claimTitleView : EditText = findViewById(R.id.claim_title)
        val dateView : EditText = findViewById(R.id.date)
        claimTitleView.setText("")
        dateView.setText("")
    }

    /////////////////////////////////////////////////////////////////////////////////
    //refreshes the status
    fun refStat(stat : String)
    {
        val statusView : TextView = findViewById(R.id.status)
        statusView.setText("Status:     <${stat}>")
    }

    /////////////////////////////////////////////////////////////////////////////////
    public fun returnTitle() : String
    {
        var title : EditText? = findViewById(R.id.claim_title)
        if (title != null)
            temp = title.text.toString()
        else
            temp = "Title Not Found!"
        return temp
    }

    /////////////////////////////////////////////////////////////////////////////////
    public fun returnDate() : String
    {
        var date : EditText? = findViewById(R.id.date)
        if (date != null)
            temp = date.text.toString()
        else
            temp = "blank"
        return temp
    }
    /////////////////////////////////////////////////////////////////////////////////

    //entry point
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        val bView : Button = findViewById(R.id.add_btn)

        //INITIALIZE cservice
        cService = ClaimService(this)

        //creates a claim from the user input and refreshes the screen

        //****FIX! CLICKING ON BUTTON BREAKS APPLICATION******//
        bView.setOnClickListener{
            //collect the data inputted in the text boxes
            val jsonstr = cService.collectInfo()

            //make a claim using the information
            cService.addClaim(jsonstr)
            refreshScreen()
        }

    }


}