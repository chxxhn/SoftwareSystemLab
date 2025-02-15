package com.example.myapplication2

    fun Year(number: Int): Int{
        if(number % 4 == 0)
        {
            if(number % 400 != 0 && number % 100 == 0) return 0
            else return 1
        }
        else return 0
    }

    fun printer(number: Int)
    {
        if(number == 1) println("윤년이 맞습니다")
        else if(number == 0) println("윤년이 아닙니다")
    }

    fun main()
    {
        println("2000년은 윤년일까?")
        printer(Year(2000))

        println("1900년은 윤년일까?")
        printer(Year(1900))

        println("2020년은 윤년일까?")
        printer(Year(2020))

        println("2013년은 윤년일까?")
        printer(Year(2013))
    }
