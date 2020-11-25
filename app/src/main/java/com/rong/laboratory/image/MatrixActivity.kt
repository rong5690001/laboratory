package com.rong.laboratory.image

import android.graphics.Matrix
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.rong.laboratory.R
import kotlinx.android.synthetic.main.activity_matrix.*

class MatrixActivity : AppCompatActivity(), View.OnClickListener {

    private val matrix: Matrix by lazy {
        Matrix()
    }

    private lateinit var sourceMatrix: Matrix
    private var sourceMatrixValues: FloatArray = FloatArray(9)

    private val valuesMatrix : Matrix by lazy {
        Matrix()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)
        image.scaleType = ImageView.ScaleType.MATRIX
        sourceMatrix = image.imageMatrix
        sourceMatrix.getValues(sourceMatrixValues)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rotation -> {
                matrix.getValues(sourceMatrixValues)
                matrix.postRotate(90f, 300f, 300f)
                image.imageMatrix = matrix
            }
            R.id.zoom -> {
                matrix.postScale(90f, 500f)
                image.imageMatrix = matrix
            }
            R.id.reset -> {
                valuesMatrix.setValues(sourceMatrixValues)
                image.imageMatrix = valuesMatrix
            }
        }
    }
}
