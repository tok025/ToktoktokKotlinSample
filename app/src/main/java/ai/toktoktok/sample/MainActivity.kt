package ai.toktoktok.sample

import ai.toktoktok.sdk.TokTokTok
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TokTokTok.init(this)
        TokTokTok.show(this)
        TokTokTok.setToktoktokListener(object : TokTokTok.TokTokTokListener {
            override fun onContentsClosed() {
                Log.d(MainActivity::class.java.simpleName, "onContentsClosed()")
            }

            override fun onContentsLoaded() {
                Log.d(MainActivity::class.java.simpleName, "onContentsLoaded()")
            }

            override fun onFailedToLoadContents(errorCode: Int, errorMsg: String) {
                Log.d(MainActivity::class.java.simpleName,
                    "onFailedToLoadContents(" +
                            errorCode + ", " + errorMsg + ")")
            }

            override fun onContentsStarted() {
                Log.d(MainActivity::class.java.simpleName, "onContentsStarted()")
            }
        })
    }
}