package com.merlin.test;

import android.net.Uri;

import com.merlin.task.Callback;
import com.merlin.task.Controller;
import com.merlin.task.FileTask;
import com.merlin.task.FromTo;

import java.io.File;

public abstract class DownloadTask extends FileTask<FromTo<Uri, File>> {

    @Override
    protected Controller onExecute(FromTo<Uri, File> arg, Callback... callbacks) {
        Uri uri=null!=arg?arg.getFrom():null;
        File to=null!=arg?arg.getTo():null;
        if (null==uri||null==to){
            notifyUpdate(FINISH,"Download task arg is NULL.",this,callbacks);
            return null;
        }

        return super.onExecute(arg, callbacks);
    }
}
