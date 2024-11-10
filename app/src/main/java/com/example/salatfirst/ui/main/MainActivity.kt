package com.example.salatfirst.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.salatfirst.R
import com.example.salatfirst.util.NotificationUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Appeler la fonction pour vérifier la permission et afficher la notification
        NotificationUtils.checkAndShowNotification(this, "C'est l'heure de votre rappel!")
    }

    // Gérer la réponse de la demande de permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Passer le résultat à NotificationUtils
        NotificationUtils.handlePermissionResult(requestCode, grantResults, this, "C'est l'heure de votre rappel!")
    }
}