package com.xrojan.lrthubkotlin.activities

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Joshua de Guzman on 09/07/2018.
 */

open class BaseActivity : AppCompatActivity() {
    private val tag = BaseActivity::class.java.simpleName
    private val subscriptions = CompositeDisposable()

    /**
     * Loads requested fragment in a specific layout resource
     * @param layoutId
     * @param fragment
     */
    fun loadFragment(layoutId: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
                .replace(layoutId, fragment, tag)
                .commitNow()
    }

    /**
     * Create disposable subscriptions
     * @param disposable
     */
    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }

    /**
     * Base error logging
     * @param message
     */
    fun showError(tag: String, message: String) {
        Log.e(tag, message)
    }

    /**
     * Override activity life cycles
     */
    override fun onStop() {
        super.onStop()
        subscriptions.clear()
    }
}