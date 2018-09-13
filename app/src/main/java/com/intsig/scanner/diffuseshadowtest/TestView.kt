package com.intsig.scanner.diffuseshadowtest

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Author：lingzhuang_bu
 * Date：2018/9/12
 * Description：
 */
class TestView : View {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    lateinit var mPaint: Paint
    lateinit var mBitmap: Bitmap

    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = Color.parseColor("#FF19BC9C")
        mPaint.textSize = 64f
        mPaint.alpha = 255
        mPaint.setShadowLayer(60f, 300f, 300f, Color.RED)
//        val blurMaskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
//        mPaint.maskFilter = blurMaskFilter
//        mBitmap = Test.feather(BitmapFactory.decodeResource(resources, R.mipmap.ic_prestige_512))
//        setLayerType(View.LAYER_TYPE_SOFTWARE,null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), 10f, 10f, mPaint)
//        canvas?.drawBitmap(mBitmap, 100f, 100f, mPaint)
//        canvas?.drawText("Grakki TEST", 100f, 100f, mPaint)
        canvas?.drawRect(200f, 200f, 400f, 400f, mPaint)
    }
}