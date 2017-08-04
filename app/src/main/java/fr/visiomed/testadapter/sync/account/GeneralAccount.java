package fr.visiomed.testadapter.sync.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by aaitzeouay on 03/08/2017.
 */

public final class GeneralAccount {

    private static final String ACCOUNT_TYPE = "fr.visiomed.testadapter";
    public static final String AUTHORITY = "fr.visiomed.testadapter.sync";
    private static final String ACCOUNT_NAME = "Test Amrane";

    public static Account getAccount() {
        return new Account(ACCOUNT_NAME, ACCOUNT_TYPE);
    }


    public static void createSyncAccount(Context context) {
        Log.e("createSyncAccount", "From here");
        boolean created = false;
        Account account = getAccount();
        AccountManager manager = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        if (manager.addAccountExplicitly(account, null, null)) {
            final long SYNC_FREQUENCY = 60 * 60;
            ContentResolver.setIsSyncable(account, AUTHORITY, 1);
            ContentResolver.setSyncAutomatically(account, AUTHORITY, true);
            ContentResolver.setMasterSyncAutomatically(true);
            ContentResolver.addPeriodicSync(account, AUTHORITY, new Bundle(), SYNC_FREQUENCY);
            created = true;
        }

        if (created) {
            runSyncNow();
        }
    }

    public static void runSyncNow() {
        Log.e("runSyncNow", "From here");
        Bundle settingsBundle = new Bundle();
        settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(getAccount(), AUTHORITY, settingsBundle);
    }
}