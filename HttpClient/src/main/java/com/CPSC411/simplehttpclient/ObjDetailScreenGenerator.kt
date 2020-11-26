package com.CPSC411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {



        // 1. Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.BLACK)
    ///////////////////////////////////////////////////////////////////////////////////////////////
        //1.1. Create Headline
        val temp = LinearLayout((ctx))
        temp.orientation = LinearLayout. HORIZONTAL
        var lbl2 = TextView(ctx)
        lbl2.text = "Please Enter Claim Information"
        lbl2.gravity = Gravity.CENTER
        val tParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        temp.layoutParams = tParams
        tParams.gravity = Gravity.CENTER
        temp.addView(lbl2, tParams)
        temp.setBackgroundColor(Color.GREEN)

        layoutObj.addView(temp, tParams)
    //////////////////////////////////////////////////////////////////////////////////////////////
        // 2. Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        // 3. Add Next Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.GRAY)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_btn)

        nButton.setBackgroundColor(Color.GREEN)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        //
        layoutObj.addView(nLayout, nParams)


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //4. Add Status Message
        val stats = LinearLayout((ctx))
        stats.orientation = LinearLayout. HORIZONTAL
        var lbl3 = TextView(ctx)
        lbl3.setId(R.id.status)
        lbl3.text = "Status:      <Status Message>"
        lbl3.setTextColor(Color.GREEN)
        lbl3.gravity = Gravity.CENTER
        val sParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        stats.layoutParams = sParams
        sParams.gravity = Gravity.CENTER
        stats.addView(lbl3, sParams)
        stats.setBackgroundColor(Color.BLACK)

        layoutObj.addView(stats, sParams)
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


        return layoutObj
    }
}