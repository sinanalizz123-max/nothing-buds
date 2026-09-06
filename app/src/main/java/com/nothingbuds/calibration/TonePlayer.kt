package com.nothingbuds.calibration

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlin.math.PI
import kotlin.math.sin

/**
 * Plays looping sine tones for the listening test. Levels stay conservative:
 * volume never exceeds [CalibrationTones.MAX_LEVEL].
 */
class TonePlayer {
    private var track: AudioTrack? = null

    fun play(freqHz: Int, volume: Float) {
        stop()
        val rate = 44100
        val frames = rate
        val data = ShortArray(frames) { i ->
            (sin(2.0 * PI * freqHz * i / rate) * Short.MAX_VALUE).toInt().toShort()
        }
        track = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setSampleRate(rate)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .build()
            )
            .setBufferSizeInBytes(data.size * 2)
            .setTransferMode(AudioTrack.MODE_STATIC)
            .build()
            .also {
                it.write(data, 0, data.size)
                it.setVolume(volume.coerceIn(0f, CalibrationTones.MAX_LEVEL))
                it.setLoopPoints(0, frames, -1)
                it.play()
            }
    }

    fun setVolume(volume: Float) {
        track?.setVolume(volume.coerceIn(0f, CalibrationTones.MAX_LEVEL))
    }

    fun stop() {
        track?.let {
            try {
                it.stop()
                it.release()
            } catch (_: Exception) {
            }
        }
        track = null
    }
}
