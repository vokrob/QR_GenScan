package com.vokrob.qr_genscan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ScannerActivity : AppCompatActivity(), ZBarScannerView.ResultHandler {
    private lateinit var zbView: ZBarScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        zbView = ZBarScannerView(this)

        setContentView(zbView)
    }

    override fun onResume() {
        super.onResume()

        zbView.setResultHandler(this)
        zbView.startCamera()
    }

    override fun onPause() {
        super.onPause()

        zbView.stopCamera()
    }

    override fun handleResult(result: Result?) {
        Log.d("MyLog", "Result:${result?.contents}")

        finish()
    }
}
























