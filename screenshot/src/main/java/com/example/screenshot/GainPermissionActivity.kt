package com.example.screenshot

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle

class GainPermissionActivity : Activity() {

    companion object {
        val KEY_PERMISSIONS = "KEY_PERMISSIONS"

        @JvmStatic
        fun start(context: Context, permission: String) {
            val starter = Intent(context, GainPermissionActivity::class.java)
            starter.putExtra(KEY_PERMISSIONS, permission)
            context.startActivity(starter)
        }
    }

    private var permission = Manifest.permission.READ_EXTERNAL_STORAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_gain_permission)
//        window.addFlags(WindowManager.)

        permission = intent.getStringExtra(KEY_PERMISSIONS) as String
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf<String>(permission), 1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        finish()
    }
}