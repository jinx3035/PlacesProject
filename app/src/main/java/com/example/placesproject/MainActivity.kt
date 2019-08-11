package com.example.placesproject

import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.karumi.dexter.Dexter
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.contracts.Returns


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var permissionListener: PermissionListener
    private lateinit var builder: android.app.AlertDialog.Builder
    private lateinit var dialogInterface: DialogInterface
    private lateinit var token: PermissionToken


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            startActivity(Intent(this, MapActivity.class)))
        }

        button = findViewById(R.id.btn_grant)
        button.setOnClickListener{button}

        Dexter.withActivity(this).withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(permissionListener )

                permissionListener.onPermissionDenied(permissionDeniedResponse())

                permissionListener.onPermissionRationaleShouldBeShown(permissionRequest())

                permissionListener.onPermissionGranted(PermissionGrantedResponse(startActivity(Intent(this, MapActivity.class)))

    }


    private fun permissionDeniedResponse(): PermissionDeniedResponse {
        builder.setTitle("Permission Denied")
            .setMessage("Permission permanently denied. Change in settings")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("OK",   { dialogInterface, i ->  })
       dialogInterface.OnClick(intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS))

        }

    private fun permissionRequest(): PermissionRequest {
        token.continuePermissionRequest()

        }

    }

private fun DialogInterface.OnClick(intent: Intent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

