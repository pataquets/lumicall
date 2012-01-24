package org.lumicall.android.db;

import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LumicallDataSource {

	// Database fields
	private SQLiteDatabase db;
	private DatabaseHelper helper;

	public LumicallDataSource(Context context) {
		helper = new DatabaseHelper(context);
	}

	public void open() throws SQLException {
		db = helper.getWritableDatabase();
	}

	public void close() {
		helper.close();
	}
	
	public SIPIdentity getSIPIdentity(long id) {
		return SIPIdentity.loadFromDatabase(db, id);
	}
	
	public List<SIPIdentity> getSIPIdentities() {
		return SIPIdentity.loadFromDatabase(db);
	}
	
	public void persistSIPIdentity(SIPIdentity sipIdentity) {
		sipIdentity.commit(db);
	}
	
	public void deleteSIPIdentity(SIPIdentity sipIdentity) {
		sipIdentity.delete(db);
	}

}