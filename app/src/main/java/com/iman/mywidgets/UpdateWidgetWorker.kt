package com.iman.mywidgets

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.widget.RemoteViews
import androidx.work.Worker
import androidx.work.WorkerParameters


class UpdateWidgetWorker(private val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val manager = AppWidgetManager.getInstance(context)
        val view = RemoteViews(context.packageName, R.layout.random_number_widget)
        val theWidget = ComponentName(context, RandomNumbersWidget::class.java)
        val lastUpdate = "Random: " + NumberGenerator.generate(100)
        view.setTextViewText(R.id.appwidget_text, lastUpdate)
        manager.updateAppWidget(theWidget, view)
        return Result.success()
    }

}