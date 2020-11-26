package com.CPSC411.simplehttpclient

import java.util.*

//give UUID a random value and set isSolved to false
data class Claim (var id: UUID = UUID.randomUUID(), var title:String?, var date:String?, var isSolved:Boolean=false)
