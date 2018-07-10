package br.com.accera.db;

import android.content.Context;

import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.database.Database;

import br.com.accera.data.user.dao.DaoMaster;
import br.com.accera.data.user.dao.DaoSession;

/**
 * The type Database session helper.
 *
 * @author MAYCON CARDOSO
 */
public class DbSessionHelper {
    //==============================================================================================
    // ATRIBUTOS
    //==============================================================================================
    private static DbSessionHelper ourInstance = null;
    private DaoMaster.DevOpenHelper mHelper;
    private Database mDb;
    private DaoSession mDynamicSession;
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METODOS
    //==============================================================================================
    private DbSessionHelper(@NotNull Context context) {
        // Modulo de entidade dinamica
        mHelper = new DaoMaster.DevOpenHelper( context,  "timesheet-db" );
        mDb = mHelper.getWritableDb();

        DaoMaster mDynamicMaster = new DaoMaster( mDb );
        mDynamicSession = mDynamicMaster.newSession();
    }

    /**
     * Init.
     *
     * @param context            the context
     */
    public synchronized static void init( Context context) {
        if(ourInstance != null){
            closeAll();
        }
        ourInstance = new DbSessionHelper( context );
    }

    /**
     * Gets cached session.
     *
     * @return the cached session
     */
    @NotNull
    public static DaoSession getDynamicSession() {
        if( ourInstance == null) {
            throw new RuntimeException( "Sessao do banco não foi inicializaca." );
        }

        ourInstance.mDynamicSession.clear();
        return ourInstance.mDynamicSession;
    }

    private static void closeAll() {
        ourInstance.mDb.close();
        ourInstance.mHelper.close();

        ourInstance.mDb = null;
        ourInstance.mHelper = null;
        ourInstance.mDynamicSession = null;
        ourInstance = null;
    }
    //==============================================================================================

}