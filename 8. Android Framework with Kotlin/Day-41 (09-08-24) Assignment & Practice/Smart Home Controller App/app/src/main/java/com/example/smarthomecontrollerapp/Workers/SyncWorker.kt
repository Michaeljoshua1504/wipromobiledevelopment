package com.example.smarthomecontrollerapp.Workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class SyncWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        // Sync data with server
        return Result.success()
    }
}