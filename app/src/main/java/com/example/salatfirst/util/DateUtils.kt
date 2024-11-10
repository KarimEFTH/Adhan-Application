package com.example.salatfirst.util


import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    // Format d'affichage de l'heure (par exemple, "10:30 AM")
    private const val TIME_FORMAT = "hh:mm a"
    private const val DATE_FORMAT = "dd/MM/yyyy"

    /**
     * Formate une Date en chaîne de caractères pour l'afficher sous forme d'heure.
     * Exemple : "10:00 AM"
     */
    fun formatTime(date: Date): String {
        val formatter = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        return formatter.format(date)
    }

    /**
     * Formate une Date en chaîne de caractères pour l'afficher sous forme de date.
     * Exemple : "21/08/2023"
     */
    fun formatDate(date: Date): String {
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return formatter.format(date)
    }

    /**
     * Convertit une chaîne de caractères au format heure en objet Date.
     * Exemple d'entrée : "10:30 AM"
     */
    fun parseTime(time: String): Date? {
        val formatter = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        return try {
            formatter.parse(time)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Convertit une chaîne de caractères au format date en objet Date.
     * Exemple d'entrée : "21/08/2023"
     */
    fun parseDate(date: String): Date? {
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return try {
            formatter.parse(date)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Vérifie si une date correspond au jour actuel.
     */
    fun isToday(date: Date): Boolean {
        val today = Calendar.getInstance()
        val givenDate = Calendar.getInstance().apply { time = date }
        return today.get(Calendar.YEAR) == givenDate.get(Calendar.YEAR) &&
                today.get(Calendar.DAY_OF_YEAR) == givenDate.get(Calendar.DAY_OF_YEAR)
    }

    /**
     * Calculer la différence en minutes entre deux heures.
     */
    fun minutesBetween(start: Date, end: Date): Long {
        val diff = end.time - start.time
        return diff / (1000 * 60)
    }
}