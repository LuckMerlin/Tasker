package com.merlin.test;

import android.net.Uri;

import com.merlin.task.Callback;
import com.merlin.task.Controller;
import com.merlin.task.FileTask;
import com.merlin.task.FromTo;

import java.io.File;
import java.io.InputStream;

public abstract class DownloadTask extends FileTask<FromTo<Uri, File>> {

    protected InputStream onOpenStream(){
        return null;
    }

    @Override
    protected final Controller onExecute(FromTo<Uri, File> arg, Callback... callbacks) {
        Uri uri=null!=arg?arg.getFrom():null;
        File to=null!=arg?arg.getTo():null;
        if (null==uri||null==to){
            notifyUpdate(FINISH,"Download task arg is NULL.",this,callbacks);
            return null;
        }
        InputStream is=onOpenStream();
        if (null==is){
            notifyUpdate(FINISH,"Download task arg is NULL.",this,callbacks);
            return null;
        }
//        is.read();
        return super.onExecute(arg, callbacks);
    }
}
