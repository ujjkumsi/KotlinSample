/*
 * MIT License
 *
 * Copyright (c) 2017 Ujjwal Kumar Singh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.murs.ujjwal.kotlinsample.util

/**
 * Created by Ujjwal on 02/07/17.
 */

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class DateUtil {

    companion object {

        fun formatDate(originalDate: String): String {

            try {
                val sdf = SimpleDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH)
                val timeZone = TimeZone.getTimeZone(Constants.IST_TIME_ZONE)
                sdf.timeZone = timeZone
                val date = sdf.parse(originalDate)
                val calendar = Calendar.getInstance()
                calendar.time = date
                val month = calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.SHORT,
                        Locale.getDefault())
                val dayOFMonth = calendar.get(Calendar.DAY_OF_MONTH)
                val hours = calendar.get(Calendar.HOUR_OF_DAY)
                val minutes = calendar.get(Calendar.MINUTE)

                return StringBuilder()
                        .append(dayOFMonth.toString())
                        .append(" ")
                        .append(month)
                        .append(" ")
                        .append(String.format(Locale.getDefault(), Constants.LEADING_ZERO_TEMPLATE, hours))
                        .append(":")
                        .append(String.format(Locale.getDefault(), Constants.LEADING_ZERO_TEMPLATE, minutes))
                        .toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return originalDate
        }
    }

}
