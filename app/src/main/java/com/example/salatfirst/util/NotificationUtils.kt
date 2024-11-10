package com.example.salatfirst.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.salatfirst.R

object NotificationUtils {

    // Constante pour identifier la demande de permission
    private const val REQUEST_NOTIFICATION_PERMISSION = 1001

    // Fonction principale pour vérifier la permission et afficher la notification
    fun checkAndShowNotification(context: Context, message: String) {
        // Si la version d'Android est 13 ou plus, on vérifie et demande la permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                // Demander la permission
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    REQUEST_NOTIFICATION_PERMISSION
                )
            } else {
                // La permission est déjà accordée, afficher la notification
                showNotification(context, message)
            }
        } else {
            // Si Android 12 ou moins, on affiche directement la notification
            showNotification(context, message)
        }
    }

    // Afficher la notification si la permission est accordée
    fun showNotification(context: Context, message: String) {
        val builder = NotificationCompat.Builder(context, "channel_id")
            .setSmallIcon(R.drawable.ic_notifications) // Icône de la notification
            .setContentTitle("Rappel")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(1, builder.build())
    }

    // Gérer la réponse de la demande de permission
    fun handlePermissionResult(
        requestCode: Int,
        grantResults: IntArray,
        context: Context,
        message: String
    ) {
        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, envoyer la notification
                showNotification(context, message)
            } else {
                // Permission refusée
                Toast.makeText(context, "Permission de notification refusée", Toast.LENGTH_SHORT).show()
            }
        }
    }
}