package fr.visiomed.testadapter.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by aaitzeouay on 01/08/2017.
 */

public class SyncService extends Service {

    private static SyncAdapter syncAdapter = null;
    private static final Object syncAdapterLock = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("SyncService", "From here");
        synchronized (syncAdapterLock) {
            if(syncAdapter == null) {
                syncAdapter = new SyncAdapter(getApplicationContext());
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return syncAdapter.getSyncAdapterBinder();
    }
}