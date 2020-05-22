package com.merlin.task;

import android.util.Log;
 class Debug {
        private static String mTag;
        private static boolean mPrintClass = false;
        private static final String DEFAULT_TAG = "LM";

        public Debug() {
        }

        public static void D(String msg) {
            D( mTag, msg);
        }

        public static void D(String tag, String msg) {
            tag = null == tag ? mTag : tag;
            if (isNeedPrintDebug(3,  tag, msg)) {
                Log.d(null == tag ? DEFAULT_TAG : tag, formatMessage( msg));
            }

        }

        public static void I(Class<?> cls, String msg) {
            I(cls, mTag, msg);
        }

        public static void I(Class<?> cls, String tag, String msg) {
            tag = null == tag ? mTag : tag;
            if (isNeedPrintDebug(4, tag, msg)) {
                Log.i(null == tag ? DEFAULT_TAG : tag, formatMessage(msg));
            }

        }

        public static void W(Class<?> cls, String msg) {
            W(cls, mTag, msg);
        }

        public static void W(Class<?> cls, String tag, String msg) {
            tag = null == tag ? mTag : tag;
            if (isNeedPrintDebug(5, tag, msg)) {
                Log.w(null == tag ? DEFAULT_TAG : tag, formatMessage(msg));
            }

        }

        public static void E(Class<?> cls, String msg) {
            E(cls, mTag, msg, (Exception)null);
        }

        public static void E(Class<?> cls, String msg, Throwable e) {
            E(cls, mTag, msg, e);
        }

        public static void E(Class<?> cls, String tag, String msg, Throwable e) {
            tag = null == tag ? mTag : tag;
            if (isNeedPrintDebug(6, tag, msg)) {
                Log.e(null == tag ? DEFAULT_TAG : tag, formatMessage( msg), e);
            }

        }

        private static String formatMessage(String msg) {
            return (null == msg ? "" : msg) + (mPrintClass ?"":"");
        }


        private static boolean isNeedPrintDebug(int type, String tag, String msg) {
            return true;
        }

    }
