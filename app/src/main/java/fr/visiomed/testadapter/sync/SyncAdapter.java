package fr.visiomed.testadapter.sync;

import android.accounts.Account;
import android.content.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


/**
 * Created by aaitzeouay on 01/08/2017.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    private final static String TAG = "SyncAdapter";

    private int requestsCount;

    public SyncAdapter(Context context) {
        super(context, true);
        Log.e(TAG, "Sync adapter constructor");
    }

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        Log.e(TAG, "Sync adapter constructor autoInitialize");
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        Log.e(TAG, "Sync adapter constructor allowParallelSyncs");
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, android.content.SyncResult syncResult) {
        Log.e(TAG, "Perform sync");
    }
}
